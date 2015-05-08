package gestionemerende;

import java.util.*;

public class Ordine {
	private String codice;
	private Vector<ElementoOrdine> elementiOrdine;
	private Classe classe;
	
	public Ordine(String codice) {
		if(codice != null)
			this.codice = codice;
		else
			throw new IllegalArgumentException("codice cannot be null");
		
		elementiOrdine = new Vector<ElementoOrdine>();
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

	public Vector<ElementoOrdine> getElementiOrdine() {
		return elementiOrdine;
	}
	
	/***
	 * Adds the specified Articolo to the Ordine.
	 * In case Articolo is present in the Ordine, quantita is incremented.
	 * @param a
	 * @param quantita
	 */
	public void addArticolo(Articolo a, int quantita) {
		if(a == null)
			throw new IllegalArgumentException("a cannot be null");
		if(quantita <= 0)
			throw new IllegalArgumentException("quantita must be positive");
		
		ElementoOrdine newEO = new ElementoOrdine(a, this, quantita);
		ElementoOrdine foundEO = null;
		
		for (ElementoOrdine eo : elementiOrdine) {
			if (eo.getArticolo().equals(newEO.getArticolo())) {
				foundEO = eo;
				// break;
			}
		}
		
		if (foundEO == null) {
			// Articolo does not exists in elementiOrdine
			elementiOrdine.addElement(newEO);
			newEO.getArticolo().addElementoOrdine(newEO);
		}
		else {
			// Articolo already exists in elementiOrdine
			foundEO.increaseQuantitaBy(newEO.getQuantita());
		}
	}
	
	public int getNumeroArticoli() {
		int r = 0;
		for (ElementoOrdine eo : elementiOrdine) {
			r += eo.getQuantita();
		}
		return r;
	}
	
	public double getCostoTotale() {
		double r = 0;
		for(ElementoOrdine eo : elementiOrdine) {
			r += eo.getCostoTotale();
		}
		return r;
	}
}
