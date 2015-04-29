package gestionemerende;

import java.util.*;

public class Ordine {
	private String codice;
	private Vector<Articolo> articoli;
	private Classe classe;
	
	public Ordine(String codice) {
		if(codice != null)
			this.codice = codice;
		else
			throw new IllegalArgumentException("codice cannot be null");
		
		articoli = new Vector<Articolo>();
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		if(classe != null)
			this.classe = classe;
		else
			throw new IllegalArgumentException("classe cannot be null");
	}

	public String getCodice() {
		return codice;
	}

	public Vector<Articolo> getArticoli() {
		return articoli;
	}
	
	public void addArticolo(Articolo a) {
		if(a != null)
			articoli.add(a);
		else
			throw new IllegalArgumentException("a cannot be null");
	}
	
	public int getNumeroArticoli() {
		return articoli.size();
	}
	
	public double getCostoTotale() {
		double r = 0;
		for(Articolo a: articoli)
			r += a.getCostoUnitario();
		return r;
	}

	@Override
	public String toString() {
		return "Ordine [codice=" + codice + ", numeroArticoli=" + articoli.size()
				+ ", classe=" + classe + "]";
	}
}
