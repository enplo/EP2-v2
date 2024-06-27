package usp.mac321.ep2;

import java.io.*;
import java.util.*;

public class EscritorLancamentos implements EscritorLancamentosDAO {

	@Override
	public void escreveLancamentos(List<Lancamento> l, String nomeArquivoLancamentos) {
		try {
			PrintWriter writer = new PrintWriter(nomeArquivoLancamentos, "UTF-8");
			writer.println("ID,Data,Responsável,Despesa?,SubCategoria,Valor,Descrição");
			for(Lancamento i: l) {
				String despesa = "FALSE";
				if(i.getROuD()) {
					despesa = "TRUE";
					}
				writer.println(i.getID() + "," + i.getStringData() + "," +
				i.getUser().getApelido() + "," + despesa + "," + i.getTipo().getNome() + "," + i.getValor() +
				"," + i.getDescricao());
			}
			writer.close();
		}
		catch(FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("IOException2: " + e.getMessage());
		} 
	}

}
