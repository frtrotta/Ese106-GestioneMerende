package gestionemerende;

import java.util.*;

abstract public class Articolo {
	private String codice;
	private String descrizione;
	private double costoUnitario;
	private double apportoCalorico;
	private Vector<ElementoOrdine> elementiOrdine;
	
	public Articolo(String codice, String descrizione, double costoUnitario,
			double apportoCalorico) {
		if(codice != null)
			this.codice = codice;
		else
			throw new IllegalArgumentException("codice cannot be null");
		
		if(descrizione != null)
			this.descrizione = descrizione;
		else
			throw new IllegalArgumentException("descrizione cannot be null");
		
		if(costoUnitario > 0)
			this.costoUnitario = costoUnitario;
		else
			throw new IllegalArgumentException("costoUnitario must be positive");
		
		if(apportoCalorico > 0)
			this.apportoCalorico = apportoCalorico;
		else
			throw new IllegalArgumentException("apportoCalorico must be positive");
		
		this.elementiOrdine = new Vector<ElementoOrdine>();
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public double getApportoCalorico() {
		return apportoCalorico;
	}
	
	public void addElementoOrdine(ElementoOrdine eo) {
		if(eo != null) {
			elementiOrdine.addElement(eo);
		}
		else
			throw new IllegalArgumentException("eo cannot be null");
	}
	
	/*
	 * TODO
	 * Oltre all'aggiunta di un ElementoOrdine sarebbe necessario implementare anche la rimozione.
	 * Infatti, se un Ordine non potesse essere aggiunto ad una Classe a causa di incompatibilità con
	 * gli Ordine presenti, l'Articolo rimarrebbe comunque legato all'Ordine non compatibile tremite
	 * il relativo ElementoOrdine.
	 * 
	 * L'implementazione di un metodo per la rimozione dell'ElementoOrdine è, quindi, indispensabile
	 * per la coerenza dei dati.
	 * 
	 * Le coerenza dei dati, necessaria in un sistema completo, viene trascurata in questo caso
	 * avente fini didattici.
	 */
	
	public int getTotaleOrdini() {
		int r = 0;
		for(ElementoOrdine eo : elementiOrdine) {
			r += eo.getQuantita();
		}
		return r;
	}
	
	public double getRicaviTotali() {
		double r = 0;
		for(ElementoOrdine eo : elementiOrdine) {
			r += eo.getCostoTotale();
		}
		return r;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Articolo other = (Articolo) obj;
		if (codice == null) {
			if (other.codice != null) {
				return false;
			}
		} else if (!codice.equals(other.codice)) {
			return false;
		}
		return true;
	}
}
