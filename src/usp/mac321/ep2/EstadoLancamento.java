package usp.mac321.ep2;

public interface EstadoLancamento {
	
        void setUser(Lancamento lancamento, Usuario u, LeitorFinancasPessoais leitor);
        void setData(Lancamento lancamento, int dia, int mes, int ano, LeitorFinancasPessoais leitor);
        void setTipo(Lancamento lancamento, TipoOperacao t, LeitorFinancasPessoais leitor);
        void setValor(Lancamento lancamento, double valor, LeitorFinancasPessoais leitor);
    
   
}
