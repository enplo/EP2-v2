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
    
    @BeforeAll
    public void setUp() {
        lancamento = leitor.leLancamentos("csv/lancamentos.csv").get(0);
    }


    @Test
    public void testeGetters() {
        String saida = "ID: "+lancamento.getID() + "Descrição: "+lancamento.getDescricao() + "Valor: "+ lancamento.getValor() + " É despesa: " +lancamento.isDespesa();
        assertEquals(" ",saida);
   
    }
}
