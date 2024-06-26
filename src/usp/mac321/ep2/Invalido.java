package usp.mac321.ep2;
import java.util.GregorianCalendar;

    public class Invalido implements EstadoLancamento {
    @Override
    public void setUser(Lancamento lancamento, Usuario u) {
        lancamento.user = u;
    }

    @Override
    public void setData(Lancamento lancamento, int dia, int mes, int ano) {
        lancamento.data = new GregorianCalendar(ano, mes - 1, dia);
    }

    @Override
    public void setTipo(Lancamento lancamento, TipoOperacao t) {
        lancamento.tipo = t;
    }

    @Override
    public void setValor(Lancamento lancamento, double valor) {
        lancamento.valor = valor;
    }
}