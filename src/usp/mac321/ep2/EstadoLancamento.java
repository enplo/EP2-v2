package usp.mac321.ep2;

public interface EstadoLancamento {
	
        void setUser(Lancamento lancamento, Usuario u);
        void setData(Lancamento lancamento, int dia, int mes, int ano);
        void setTipo(Lancamento lancamento, TipoOperacao t);
        void setValor(Lancamento lancamento, double valor);
    
   
}
