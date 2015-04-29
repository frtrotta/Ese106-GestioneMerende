package gestionemerende;

public class Panino extends Articolo {
	private boolean vegetariano;
	private boolean carneSuina;
	
	public Panino(String codice, String descrizione, double costoUnitario,
			double apportoCalorico, boolean vegetariano, boolean carneSuina) {
		super(codice, descrizione, costoUnitario, apportoCalorico);
		if(!vegetariano && !carneSuina) {
			this.vegetariano = vegetariano;
			this.carneSuina = carneSuina;
		}
		else
			throw new IllegalArgumentException("You are confused...");
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public boolean isCarneSuina() {
		return carneSuina;
	}
}
