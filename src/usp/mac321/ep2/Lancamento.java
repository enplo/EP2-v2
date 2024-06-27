package usp.mac321.ep2;
import java.util.GregorianCalendar;
import java.time.LocalDate;

public class Lancamento {
	private static long contadorDeLancamentos;
	private long identificador;
	private int dia, mes, ano;
	private GregorianCalendar data;
	private Usuario usuario;
	private boolean receitaOuDespesa; //True para despesa e false para receita
	private TipoOperacao tipo;
	private String descricao;
	private double valor;
	private EstadoLancamento estado;
	
	private LeitorFinancasPessoais leitor;

	Lancamento(int dia, int mes, int ano, Usuario usuario, boolean receitaOuDespesa, TipoOperacao tipo, String descricao, double valor, LeitorFinancasPessoais leitor){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
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
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
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

	public String getStringData() {
		String sDia = "" + dia;
		if(dia<10) {
			sDia = "0" + sDia;
		}
		
		String sMes = "" + mes;
		if(mes<10) {
			sMes = "0" + sMes;
		}
		
		String sAno = "" + ano;
		if(ano<10) {
			sAno = "0" + sAno;
		}
		return sDia+"/"+sMes+"/"+sAno;
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
