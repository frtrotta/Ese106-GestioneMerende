package gestionemerende;

import java.util.*;

public class Istituto {
	private String nome;
	private Vector<Classe> classi;
	
	public Istituto(String nome) {
		if(nome != null)
			this.nome = nome;
		else
			throw new IllegalArgumentException("nome cannot be null");
		
		classi = new Vector<Classe>();
	}

	public String getNome() {
		return nome;
	}

	public Vector<Classe> getClassi() {
		return classi;
	}
	
	public void addClasse(Classe c) {
		if(c != null)
			this.classi.add(c);
		else
			throw new IllegalArgumentException("c cannot be null");
	}

	@Override
	public String toString() {
		return "Istituto [nome=" + nome + ", numeroClassi=" + classi.size() + "]";
	}
	
	
}
