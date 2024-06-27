package usp.mac321.ep2;
import java.util.GregorianCalendar;
import java.time.LocalDate;

public class Lancamento {
	private static long contadorDeLancamentos;
	private long identificador;
	private GregorianCalendar data;
	private Usuario usuario;
	private boolean receitaOuDespesa; //True para despesa e false para receita
	private TipoOperacao tipo;
	private String descricao;
	private double valor;
	private EstadoLancamento estado;
	
	private LeitorFinancasPessoais leitor;

	Lancamento(int dia, int mes, int ano, Usuario usuario, boolean receitaOuDespesa, TipoOperacao tipo, String descricao, double valor, LeitorFinancasPessoais leitor){
		data = new GregorianCalendar(ano, mes, ano);
		this.usuario = usuario;
		this.receitaOuDespesa = receitaOuDespesa;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		identificador = contadorDeLancamentos;
		contadorDeLancamentos++;
		this.leitor = leitor;
				
	}
	
	Lancamento(int dia, int mes, int ano, Usuario usuario, boolean receitaOuDespesa, TipoOperacao tipo, String descricao, double valor, long identificador){
		data = new GregorianCalendar(ano, mes, dia);
		this.usuario = usuario;
		this.receitaOuDespesa = receitaOuDespesa;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		this.identificador = identificador;

		if(contadorDeLancamentos<=identificador) {
			contadorDeLancamentos=identificador+1;
		}
		
		
	}

	public void mudaEstado(EstadoLancamento el){
		estado = el;
	}
	
	public String getEstado() {
		return estado.estado();	
	}


	public long getID() {
		return identificador;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isDespesa(){
		return receitaOuDespesa;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setUsuario(Usuario usuario) {
		estado.setUsuario(this, usuario, leitor);
		
			this.usuario = usuario;
    }

    public void setData(int dia, int mes, int ano) {
        estado.setData(this, dia, mes, ano, leitor);
		data = new GregorianCalendar(ano, mes- 1, dia);
    }

    public void setTipo(TipoOperacao tipo) {
        estado.setTipo(this, tipo, leitor);
		this.tipo = tipo;
	
	}

    public void setValor(double valor) {
        	estado.setValor(this, valor, leitor);
			this.valor = valor;
    }



}
