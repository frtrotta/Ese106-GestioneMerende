package ese106;

import gestionemerende.*;

public class Ese106 {

	public static void main(String[] args) throws Exception {
		Istituto volta = new Istituto("A. Volta");
		Classe quartaAINF = new Classe("4ainf");
		volta.addClasse(quartaAINF);
		
		Bibita cocaCola = new Bibita("coca30cl", "Coca-Cola", 1.5, 40, 30);
		
		Ordine primo = new Ordine("4ainf-20150429");
		primo.addArticolo(cocaCola, 1);
		System.out.print("Test01a..");
		if(primo.getNumeroArticoli() == 1)
			System.out.println("OK");
		else
			System.out.println("ERRORE");

		primo.addArticolo(cocaCola, 1);
		System.out.print("Test01b..");
		if(primo.getNumeroArticoli() == 2)
			System.out.println("OK");
		else
			System.out.println("ERRORE");
		
		System.out.print("Test01c..");
		if(primo.getCostoTotale() == 3.0)
			System.out.println("OK");
		else
			System.out.println("ERRORE");
		
		System.out.print("Test02...");
		Panino cotoletta = null;
		try {
			cotoletta = new Panino("cotoletta", "Panino alla cotoletta con kectchup e maionese", 2.5, 100, true, true);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if(e.getMessage().equals("You are confused..."))
				System.out.println("OK");
			else
				System.out.println("ERRORE");
		}
		
		System.out.print("Test03...");
		try {
			primo.addArticolo(cotoletta, 13);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if(e.getMessage().equals("a cannot be null"))
				System.out.println("OK");
			else
				System.out.println("ERRORE");
		}
		
		System.out.print("Test04...");
		quartaAINF.addOrdine(primo);
		if(quartaAINF.getOrdini().size() == 1)
			System.out.println("OK");
		else
			System.out.println("ERRORE");
		
		Ordine secondo =  new Ordine("4ainf-20150430");
		secondo.addArticolo(cocaCola, 3);
		quartaAINF.addOrdine(secondo);
		System.out.print("Test05a..");
		if(secondo.getClasse() == quartaAINF)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		System.out.print("Test05b..");
		if(cocaCola.getTotaleOrdini() == 5)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		System.out.print("Test06...");
		secondo =  new Ordine("4ainf-20150430");
		Schifezza patatine = new Schifezza("patatine-rustiche", "Patatine molto molto grasse", 1, 200);
		secondo.addArticolo(patatine, 3);
		try {
			quartaAINF.addOrdine(secondo);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if(e.getMessage().equals("Ordine 4ainf-20150430 already present"))
				System.out.println("OK");
			else
				System.out.println("ERRORE");
		}
		
	}

}
