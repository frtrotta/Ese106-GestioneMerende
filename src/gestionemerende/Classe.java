package gestionemerende;

import java.util.Vector;

public class Classe {
	private String nome;
	private Vector<Ordine> ordini;
	
	public Classe(String nome) {
		if(nome != null)
			this.nome = nome;
		else
			throw new IllegalArgumentException("nome cannot be null");
		
		ordini = new Vector<Ordine>();
	}

	public String getNome() {
		return nome;
	}

	public Vector<Ordine> getOrdini() {
		return ordini;
	}
	
	public void addOrdine(Ordine o) throws Exception {
		if(o != null) {
			for(Ordine p : this.ordini) {
				if(p.getCodice().equals(o.getCodice()))
					throw new Exception("Ordine " + o.getCodice() + " already present");
			}
			ordini.add(o);
			o.setClasse(this);
		}
		else
			throw new IllegalArgumentException("o cannot be null");
	}
	
	@Override
	public String toString() {
		return "Classe [nome=" + nome + ", numeroOrdini=" + ordini.size() + "]";
	}
}
