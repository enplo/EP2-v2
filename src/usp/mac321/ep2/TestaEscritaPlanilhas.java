package usp.mac321.ep2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestaEscritaPlanilhas {

	
	List<Usuario>      usuarios;
	List<TipoDespesa>  tiposDespesas;
	List<TipoReceita>  tiposReceitas;
	List<Lancamento>   lancamentos;
	LeitorFinancasPessoaisDAO leitor;

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@BeforeEach
	void setUp() throws Exception {
		leitor = new LeitorFinancasPessoais();  //MUDAR
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
		usuarios = leitor.leUsuarios("csv//usuarios.csv");
		tiposDespesas = leitor.leTiposDespesas("csv//tiposDespesas.csv");
		tiposReceitas = leitor.leTiposReceitas("csv//tiposReceitas.csv");
		lancamentos = leitor.leLancamentos("csv//lancamentos.csv");
	}
	
	@AfterEach
	public void cleanUpStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
	}

	@Test
	public void testWriteUsuarios(){
		EscritorUsuarios escritor = new EscritorUsuarios();
		usuarios.add(new Usuario("Usuário Teste", "NOME"));
		escritor.escreveUsuarios(usuarios, "csv//testeEscritaUsuarios.csv");
		usuarios.clear();
		usuarios = leitor.leUsuarios("csv//testeEscritaUsuarios.csv");
		System.out.println("Apelido,Nome");
		for(Usuario i: usuarios) {
			System.out.println(i.getApelido() + "," + i.getNome());
		}
		
		assertEquals("Apelido,Nome\nPai,Epaminondas Encerrabodes Eleutério\nZezinho,José Josimarson Eleutério\nUsuário Teste,NOME\n",outContent.toString());
	}
	
	@Test
	public void testWriteTiposReceitas(){
		EscritorTiposReceita escritor = new EscritorTiposReceita();
		TipoReceita a = new TipoReceita("TESTE SUBCATEGORIA A", true);
		TipoReceita b = new TipoReceita("TESTE SUBCATEGORIA B", true);
		TipoReceita c = new TipoReceita("TESTE SUBCATEGORIA C", true);
		List<TipoReceita> subtiposDeD = new ArrayList<TipoReceita>();
		subtiposDeD.add(c);
		TipoReceita d = new TipoReceita("TESTE CATEGORIA D", subtiposDeD);
		d.setSub(false);
		tiposReceitas.add(a);
		tiposReceitas.add(b);
		tiposReceitas.add(c);
		tiposReceitas.add(d);
		List<TipoReceita> novasSubsDoTipo2 = tiposReceitas.get(2).getListaSubcategorias();
		novasSubsDoTipo2.add(a);
		novasSubsDoTipo2.add(b);
		tiposReceitas.get(2).setSubcategorias(novasSubsDoTipo2);
		escritor.escreveTiposReceita(tiposReceitas, "csv//testeEscritaTiposReceitas.csv");
		tiposReceitas.clear();
		tiposReceitas = leitor.leTiposReceitas("csv//testeEscritaTiposReceitas.csv");
		System.out.println("Categoria,subCategoria");
		for(TipoReceita i: tiposReceitas) {
			if(!i.isSub()) {
				for(TipoReceita j: i.getListaSubcategorias()) {
					System.out.println(i.getNome() + "," + j.getNome());
				}
			}
		}
		
		assertEquals("Categoria,subCategoria\n"
				+ "Salário,Principal\n"
				+ "Salário,Bico\n"
				+ "Salário,TESTE SUBCATEGORIA A\n"
				+ "Salário,TESTE SUBCATEGORIA B\n"
				+ "Investimento,Popança\n"
				+ "Investimento,Renda Fixa\n"
				+ "TESTE CATEGORIA D,TESTE SUBCATEGORIA C\n",outContent.toString());
	}
	
	@Test
	public void testWriteTiposDespesas(){
			EscritorTiposDespesa escritor = new EscritorTiposDespesa();
			TipoDespesa a = new TipoDespesa("TESTE SUBCATEGORIA A", true);
			TipoDespesa b = new TipoDespesa("TESTE SUBCATEGORIA B", true);
			TipoDespesa c = new TipoDespesa("TESTE SUBCATEGORIA C", true);
			List<TipoDespesa> subtiposDeD = new ArrayList<TipoDespesa>();
			subtiposDeD.add(c);
			TipoDespesa d = new TipoDespesa("TESTE CATEGORIA D", subtiposDeD);
			d.setSub(false);
			tiposDespesas.add(a);
			tiposDespesas.add(b);
			tiposDespesas.add(c);
			tiposDespesas.add(d);
			List<TipoDespesa> novasSubsDoTipo2 = tiposDespesas.get(2).getListaSubcategorias();
			novasSubsDoTipo2.add(a);
			novasSubsDoTipo2.add(b);
			tiposDespesas.get(2).setSubcategorias(novasSubsDoTipo2);
			escritor.escreveTiposDespesa(tiposDespesas, "csv//testeEscritaTiposDespesas.csv");
			tiposDespesas.clear();
			tiposDespesas = leitor.leTiposDespesas("csv//testeEscritaTiposDespesas.csv");
			System.out.println("Categoria,subCategoria");
			for(TipoDespesa i: tiposDespesas) {
				if(!i.isSub()) {
					for(TipoDespesa j: i.getListaSubcategorias()) {
						System.out.println(i.getNome() + "," + j.getNome());
					}
				}
			}
			
			assertEquals("Categoria,subCategoria\n"
					+ "Educação,Curso de Idioma\n"
					+ "Educação,Jardim da Infância\n"
					+ "Educação,TESTE SUBCATEGORIA A\n"
					+ "Educação,TESTE SUBCATEGORIA B\n"
					+ "Alimentação,Supermercado\n"
					+ "Alimentação,Sacolão\n"
					+ "Lazer,Cinema\n"
					+ "Lazer,Streaming\n"
					+ "TESTE CATEGORIA D,TESTE SUBCATEGORIA C\n",outContent.toString());
		}
	
	@Test
	public void testWriteLancamentos(){
		//CHECAR SE CLASSE LANCAMENTOS TEM MESMOS CONSTRUTORES ENTRE ESSE AQUI E O GIT!!!
		EscritorLancamentos escritor = new EscritorLancamentos();
		lancamentos.clear();
		
		for(Lancamento i: lancamentos) {
			String despesa = "FALSE";
			if(i.getROuD()) {
				despesa = "TRUE";
				}
			//String data = i.getData().toZonedDateTime().format(DateTimeFormatter.ofPattern("dd/MM/YY"));
			System.out.println(i.getID() + "," + i.getStringData() + "," +
					i.getUser().getApelido() + "," + despesa + "," + i.getTipo().getNome() + "," + i.getValor() +
					"," + i.getDescricao());
		}
		
		lancamentos.add(new Lancamento(1, 3, 25, usuarios.get(0), false, tiposReceitas.get(0), "DESC TESTE", 20, 2));
		escritor.escreveLancamentos(lancamentos, "csv//testeEscritaLancamentos.csv");
		lancamentos.clear();
		lancamentos = leitor.leLancamentos("csv//testeEscritaLancamentos.csv");
		System.out.println("ID,Data,Responsável,Despesa?,SubCategoria,Valor,Descrição");
		for(Lancamento i: lancamentos) {
			String despesa = "FALSE";
			if(i.getROuD()) {
				despesa = "TRUE";
				}
			System.out.println(i.getID() + "," + i.getStringData() + "," +
					i.getUser().getApelido() + "," + despesa + "," + i.getTipo().getNome() + "," + i.getValor() +
					"," + i.getDescricao());
		}
		
		assertEquals("ID,Data,Responsável,Despesa?,SubCategoria,Valor,Descrição\n"
				+ "2,01/03/25,Pai,FALSE,Principal,20.0,DESC TESTE\n",outContent.toString());
	}
	

}
