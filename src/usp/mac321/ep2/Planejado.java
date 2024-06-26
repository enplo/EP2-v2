package usp.mac321.ep2;
import java.time.LocalDate;
import java.util.GregorianCalendar;


public class Planejado implements EstadoLancamento {
    @Override
    public void setUser(Lancamento lancamento, Usuario u) {
        lancamento.user = u;
    }
@   Override
        public void setData(Lancamento lancamento, int dia, int mes, int ano) {
            if (dia <= 0 || mes <= 0 || ano <= 0) {
                lancamento.mudaEstado(new Invalido());
            } else {
                GregorianCalendar novaData = new GregorianCalendar(ano, mes - 1, dia);
                LocalDate dataAtual = LocalDate.now();

                LocalDate localDate = novaData.toZonedDateTime().toLocalDate();
                if (localDate.isBefore(dataAtual)) {
                    lancamento.mudaEstado(new Executado());
                } else if (localDate.isAfter(dataAtual)) {
                    lancamento.mudaEstado(new Planejado());
                }

                lancamento.data = novaData;
            }
        }

    @Override
    public void setTipo(Lancamento lancamento, TipoOperacao t) {
        lancamento.tipo = t;
    }

    @Override
    public void setValor(Lancamento lancamento, double valor) {
        if (valor < 0) {
            lancamento.mudaEstado(new Invalido());
        } else {
            lancamento.valor = valor;
        }
    }
}
