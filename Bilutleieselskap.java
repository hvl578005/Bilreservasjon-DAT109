package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class Bilutleieselskap {
	
	private String navn;
	private String telefonnummer;
	private Adresse firmaadresse;
	private List<Kontor> kontor;
	
	public Bilutleieselskap() {
		
		kontor = new ArrayList<Kontor>();
		
		Adresse a1 = new Adresse("St Hanshaugen 37", "5311", Sted.OSLO);
		Kontor k1 = new Kontor(1, a1, "57805444");
		Adresse a2 = new Adresse("Madlaveien 8", "0122", Sted.STAVANGER);
		Kontor k2 = new Kontor(2, a2, "12345678");
		Adresse a3 = new Adresse("Fredrik Grans Vei 2", "5044", Sted.BERGEN);
		Kontor k3 = new Kontor(3, a3, "22334455");
		Adresse a4 = new Adresse("Jølebakken 44", "8944", Sted.TRONDHEIM);
		Kontor k4 = new Kontor(4, a4, "466041494");
		Adresse a5 = new Adresse("Kristiansandsvei 1", "3632", Sted.KRISTIANSAND);
		Kontor k5 = new Kontor(5, a5, "23456789");
		
		kontor.add(k1);
		kontor.add(k2);
		kontor.add(k3);
		kontor.add(k4);
		kontor.add(k5);
		
		/* LEGGE TIL BILER*/
		k1.leggTilBiler();
		k2.leggTilBiler();
		k3.leggTilBiler();
		k4.leggTilBiler();
		k5.leggTilBiler();
		
		this.navn = "WonderCar";
		this.telefonnummer = "47804129";
		this.firmaadresse = new Adresse("St Hanshaugen 37", "5311", Sted.OSLO);
	}
	
	public void leggTilKontor(Kontor k) {
		kontor.add(k);
	}
	
	public Kontor finnKontor(int kontornummer) {
		return kontor.get(kontornummer-1);
	}
	
	public String getNavn() {
		return navn;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}


	public Adresse getFirmaadresse() {
		return firmaadresse;
	}


	public List<Kontor> getKontor() {
		return kontor;
	}	
}
