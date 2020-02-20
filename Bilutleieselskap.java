package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author KathrineH
 *
 * Objekt klassen til bilutleieselskapet. 
 */

public class Bilutleieselskap {
	
	private String navn;
	private String telefonnummer;
	private Adresse firmaadresse;
	private List<Kontor> kontor;
	private List<Kunde> kunde;
	
	/**
	 * bilutleieselskapet har allerede en bestemt adresse da adressen er det samme som hovedkontoret (oslo)
	 * her har man en liste av kontor og en liste av kunder.
	 * med denne konsturktøren blir det automatisk lagd fem kontorer
	 * og man legger til de kontorene i listen
	 * deretter kaller man på kontorene og bruker metoden leggtilbiler()
	 */
	
	public Bilutleieselskap() {
		
		kontor = new ArrayList<Kontor>();
		kunde = new ArrayList<Kunde>();
		
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
		Adresse a6 = new Adresse("Maudlandsveien 1", "4311", "Hommersåk");
		Kunde k = new Kunde("Kathrine", "Hermansen", a6, "46694148");
				
		kontor.add(k1);
		kontor.add(k2);
		kontor.add(k3);
		kontor.add(k4);
		kontor.add(k5);
		kunde.add(k);
		
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
	/**
	 * 
	 * @param k
	 * metode for å legge til kontor i kontorlisten
	 */
	
	public void leggTilKontor(Kontor k) {
		kontor.add(k);
	}
	
	/**
	 * 
	 * @param k
	 * metode for å legge til kunde i kundelisten
	 */
	
	public void leggtilKunde(Kunde k) {
		kunde.add(k);
	}
	
	/**
	 * 
	 * @param telefonnummer
	 * @return
	 * metode for å kunne finne ønsket kunde med bruk av telefonnummer
	 * 
	 */
	
	public Kunde finnKunde(String telefonnummer) {
		return kunde.stream().filter(p -> p.getTelefonnummer().contentEquals(telefonnummer))
				.collect(Collectors.toList()).get(0);
	}
	
	/**
	 * 
	 * @param kontornummer
	 * @return
	 * metode for å finne kontor med å søke etter kontornummer
	 */
	
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
