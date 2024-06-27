package usp.mac321.ep2;

import java.util.*;

public class TipoDespesa implements TipoOperacao {
	String nomeDoTipo;
	boolean sub;
	TipoDespesa tipoDerivado;
	List<TipoDespesa> subcategorias = new ArrayList<TipoDespesa>();
	boolean despesa = true;


	TipoDespesa(String n){
		nomeDoTipo = n;
		sub = true;
	}
	
	TipoDespesa(String n, List<TipoDespesa> t){
		nomeDoTipo = n;
		subcategorias = t;
		sub = false;
	}
	
	TipoDespesa(String n, boolean b){
		nomeDoTipo = n;
		sub = b;
	}
	
	public void setTipoDerivado(TipoDespesa t) {
		tipoDerivado = t;
	}
	
	public void setSubcategorias(List<TipoDespesa> t) {
		subcategorias = t;
	}
	
	@Override
	public String getNome() {
		return nomeDoTipo;
	}
	public String getSubcategorias() {
		String sc = "Categoria: " + this.getNome() + " Subcategorias: ";
		
		for (TipoDespesa t: subcategorias) {
			sc += t.getNome() +  " ";
		}
		
		return sc;
	}
	
	public boolean isDespesa() {
		return despesa;
	}
	
	@Override
	public String toString() {
		if(sub) {
			return tipoDerivado.toString() + ": " + nomeDoTipo;
		}
		
		return nomeDoTipo;
	}

	public boolean isSub(){
		return sub;
	}

	public List<TipoReceita> getListaSubcategorias() {
		return subcategorias;
	}
}
