package usp.mac321.ep2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TesteLeitura2 {

	
	List<Usuario>      usuarios;
	List<TipoDespesa>  tiposDespesas;
	List<TipoReceita>  tiposReceitas;
	List<Lancamento>   lancamentos;
	LeitorFinancasPessoaisDAO leitor;

	
	
	@BeforeEach
	void setUp() throws Exception {
		leitor = new LeitorFinancasPessoais();
		
	}
	


	@Test
	public void testTiposDespesas(){
		tiposDespesas = leitor.leTiposDespesas("csv\\tiposDespesas.csv");
		assertEquals(6, tiposDespesas.size());
		assertEquals("Categoria: Educação Subcategorias: Curso de Idioma ",tiposDespesas.get(0).getSubcategorias());
		
	}
	
	@Test
	public void testTiposReceitas(){
		tiposReceitas = leitor.leTiposReceitas("csv\\tiposReceitas.csv");
		assertEquals(4, tiposReceitas.size());
		assertEquals("Categoria: Salário Subcategorias: Principal ",tiposReceitas.get(0).getSubcategoria());
	}
	
	
	@Test
	public void testUsuarios(){
		usuarios = leitor.leUsuarios("csv\\usuarios.csv");
		assertEquals(2, usuarios.size());
		assertEquals("Pai", usuarios.get(0).getApelido());
		assertEquals("Zezinho", usuarios.get(1).getApelido());
		assertEquals("Epaminondas Encerrabodes Eleutério", usuarios.get(0).getNome());
		assertEquals("José Josimarson Eleutério",usuarios.get(1).getNome());
		
	}
	
	
	
	
	
	
	@Test
	public void testLancamentosOK(){
		usuarios = leitor.leUsuarios("csv\\usuarios.csv");
		lancamentos = leitor.leLancamentos("csv\\lancamentos.csv");
		assertEquals(8, lancamentos.size());
	}
/*
	@Test
	public void testLancamentoUsuarioDesconhecido(){
		// TODO
		fail();
	}
	@Test
	public void testLancamentoDespesaDesconhecida(){
		// TODO
		fail();
	}
	@Test
	public void testLancamentoReceiraDesconhecida(){
		// TODO
		fail();
	}
	
*/
}
