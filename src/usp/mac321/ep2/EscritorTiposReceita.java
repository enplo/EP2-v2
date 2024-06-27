package usp.mac321.ep2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class EscritorTiposReceita implements EscritorTiposReceitaDAO {
	
	@Override
	public void escreveTiposReceita(List<TipoReceita> l, String nomeArquivoUsuarios) {
		try {
			PrintWriter writer = new PrintWriter(nomeArquivoUsuarios, "UTF-8");
			writer.println("Categoria,SubCategoria");
			for(TipoReceita i: l) {
				if(!i.isSub()) {
					for(int j = 0; j<i.getListaSubcategorias().size(); j++) {
						writer.print(i.getNome());
						writer.println("," + i.getListaSubcategorias().get(j).getNome());
					}
				}
			}
			writer.close();
		}
		catch(FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("IOException2: " + e.getMessage());
		} 
	}
}
