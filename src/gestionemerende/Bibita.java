package gestionemerende;

public class Bibita extends Articolo {
	private double quantita;

	public Bibita(String codice, String descrizione, double costoUnitario,
			double apportoCalorico, double quantita) {
		super(codice, descrizione, costoUnitario, apportoCalorico);
		
		if(quantita > 0)
			this.quantita = quantita;
		else
			throw new IllegalArgumentException("quantita must be positive");
	}

	public double getQuantita() {
		return quantita;
	}	
}
