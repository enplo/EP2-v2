package usp.mac321.ep2;
import java.util.GregorianCalendar;
import java.time.LocalDate;

public class Lancamento {
	private static long contadorDeLancamentos;
	long identificador;
	GregorianCalendar data;
	Usuario user;
	boolean receitaOuDespesa; //True para despesa e false para receita
	TipoOperacao tipo;
	String descricao;
	double valor;
	EstadoLancamento launchState;
	LocalDate diaAtual = LocalDate.now();
	LeitorFinancasPessoais leitor;

	Lancamento(int dia, int mes, int ano, Usuario user, boolean receitaOuDespesa, TipoOperacao tipo, String descricao, double valor, LeitorFinancasPessoais leitor){
		data = new GregorianCalendar(ano, mes, ano);
		this.user = user;
		this.receitaOuDespesa = receitaOuDespesa;
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
		identificador = contadorDeLancamentos;
		contadorDeLancamentos++;
		this.leitor = leitor;
			
	}
	
	Lancamento(int dia, int mes, int ano, Usuario user, boolean receitaOuDespesa, TipoOperacao tipo, String descricao, double valor, long indentificador){
		data = new GregorianCalendar(ano, mes, dia);
		this.user = user;
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
		launchState = el;
	}
	
	public long getID() {
		return identificador;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getValor() {
		return valor;
	}

	public Usuario getUser() {
		return user;
	}

	public boolean isDespesa(){
		return receitaOuDespesa;
	}





	public void setUser(Usuario user)  {
		launchState.setUser(this, user, leitor);
		this.user = user;
    }

    public void setData(int dia, int mes, int ano) {
        launchState.setData(this, dia, mes, ano, leitor);
		data = new GregorianCalendar(ano, mes- 1, dia);
    }

    public void setTipo(TipoOperacao tipo) {
        launchState.setTipo(this, tipo, leitor);
		this.tipo = tipo;
	
	}

    public void setValor(double valor) {
        	launchState.setValor(this, valor, leitor);
			this.valor = valor;
    }



}
