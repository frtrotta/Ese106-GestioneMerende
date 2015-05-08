package gestionemerende;

public class ElementoOrdine {
	private Articolo articolo;
	private Ordine ordine;
	private int quantita;
	
	public ElementoOrdine(Articolo articolo, Ordine ordine, int quantita) {
		if (articolo != null)
			this.articolo = articolo;
		else
			throw new IllegalArgumentException("articolo cannot be null");
		
		if (ordine != null)
			this.ordine = ordine;
		else
			throw new IllegalArgumentException("ordine cannot be null");
		
		if (quantita > 0)
			this.quantita = quantita;
		else
			throw new IllegalArgumentException("quantita must be positive");
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public int getQuantita() {
		return quantita;
	}
	
	public double getCostoTotale() {
		return articolo.getCostoUnitario() * quantita;
	}
	
	public void increaseQuantitaBy(int increment) {
		if (increment >= 0) {
			this.quantita += increment;
		}
		else
			throw new IllegalArgumentException("quantita must be non negative");
	}	
}
