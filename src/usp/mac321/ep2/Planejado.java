package usp.mac321.ep2;
import java.time.LocalDate;
import java.util.GregorianCalendar;


public class Planejado implements EstadoLancamento {
    @Override
    public void setUser(Lancamento lancamento, Usuario u, LeitorFinancasPessoais leitor) {
        try {
            leitor.getUsuarioFromList(u.getApelido());
        }

        catch (UsuarioNaoExistenteException e){
            lancamento.mudaEstado(new Invalido());
        }
    }
@   Override
        public void setData(Lancamento lancamento, int dia, int mes, int ano, LeitorFinancasPessoais leitor) {
            if (dia <= 0 || mes <= 0 || ano <= 0) {
                lancamento.mudaEstado(new Invalido());
            } 
            
            else {
                GregorianCalendar novaData = new GregorianCalendar(ano, mes - 1, dia);
                LocalDate dataAtual = LocalDate.now();

                LocalDate localDate = novaData.toZonedDateTime().toLocalDate();
                if (localDate.isBefore(dataAtual)) {
                    lancamento.mudaEstado(new Executado());
                } 
                
                else if (localDate.isAfter(dataAtual)) {
                    lancamento.mudaEstado(new Planejado());
                }

                
            }
        }

    @Override
    public void setTipo(Lancamento lancamento, TipoOperacao t, LeitorFinancasPessoais leitor) {
        try {
            if(t.isDespesa()) {
                leitor.getTipoDespesaFromList(t.getNome());
            }

            else {
                leitor.getTipoReceitaFromList(t.getNome()); 
            }
        }

        catch(TipoNaoRegistradoException e) {
            lancamento.mudaEstado(new Invalido());
        }
    }

    @Override
    public void setValor(Lancamento lancamento, double valor, LeitorFinancasPessoais leitor) {
        if (valor < 0) {
            lancamento.mudaEstado(new Invalido());
        } 
        
        
    }
}
