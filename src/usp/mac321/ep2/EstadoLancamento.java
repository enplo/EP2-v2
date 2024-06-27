package usp.mac321.ep2;

public interface EstadoLancamento {
	
        public void setUsuario(Lancamento lancamento, Usuario u, LeitorFinancasPessoais leitor);
        public void setData(Lancamento lancamento, int dia, int mes, int ano, LeitorFinancasPessoais leitor);
        public void setTipo(Lancamento lancamento, TipoOperacao t, LeitorFinancasPessoais leitor);
        public void setValor(Lancamento lancamento, double valor, LeitorFinancasPessoais leitor);
        public String estado();
   
}
