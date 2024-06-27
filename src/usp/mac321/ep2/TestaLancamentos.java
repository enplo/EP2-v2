    package usp.mac321.ep2;
    import static org.junit.jupiter.api.Assertions.*;

    import java.io.ByteArrayOutputStream;
    import java.io.PrintStream;
    import java.util.List;

    import org.junit.jupiter.api.AfterEach;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;


    public class TestaLancamentos {
        Lancamento lancamento;
        LeitorFinancasPessoais leitor;
        
        @BeforeEach
        public void setUp() {
            leitor = new LeitorFinancasPessoais();
            leitor.leUsuarios("csv/usuarios.csv");
            leitor.leTiposDespesas("csv/tiposDespesas.csv");
            leitor.leTiposReceitas("csv/tiposReceitas.csv");
            lancamento = leitor.leLancamentos("csv/lancamentos.csv").get(0);
        }


        @Test
        public void testeGetters() {
            String saida = "ID: "+lancamento.getID() + "Descrição: "+lancamento.getDescricao() + "Valor: "+ lancamento.getValor() + " É despesa: " +lancamento.isDespesa();
            assertEquals(" ",saida);
            lancamento.setDescricao("Teste");
            assertEquals("Teste", lancamento.getDescricao());
            assertEquals("Executado", lancamento.getEstado());
        }

        @Test
        public void testeSetData() {
            lancamento.setData(1, 0, 2100);
            assertEquals("Planejado", lancamento.getEstado());
        }

        @Test
        public void testeSetUsuario() {
            Usuario u = new Usuario("Zezinho", "José Josimarson Eleutério");
            lancamento.setUsuario(u);
            assertEquals("Planejado", lancamento.getEstado());

        }


        @Test
        public void setValor() {
            lancamento.setValor(-950);
            assertEquals("Inválida", lancamento.getEstado());
        }

        @Test
        public void setTipo() {
            TipoDespesa t = new TipoDespesa("abcd");
            lancamento.setValor(1000);
            lancamento.setTipo(t);
            assertEquals("Inválida", lancamento.getEstado());
        }


    }
