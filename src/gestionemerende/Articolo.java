package gestionemerende;

abstract public class Articolo {
	private String codice;
	private String descrizione;
	private double costoUnitario;
	private double apportoCalorico;
	
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
}
