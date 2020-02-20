package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author KathrineH
 * 
 * Klasse for å opprette objekter av kontorer.
 * Hvert kontor har en arrayList av biler
 *
 */

public class Kontor {
	
	private int kontornummer;
	private Adresse adresse;
	private String telefonnummer;
	private List<Bil> biler;
	
	/**
	 * 
	 * @param kontornummer
	 * @param adresse
	 * @param telefonnummer
	 */
	
	public Kontor(int kontornummer, Adresse adresse, String telefonnummer) {
		biler = new ArrayList<Bil>();
		this.kontornummer = kontornummer;
		this.telefonnummer = telefonnummer;
		this.adresse = new Adresse(adresse.getGateAdresse(), adresse.getPostnr(), adresse.getSted());
		
	}
	/**
	 * metode for å legge til objekter av biler inn i listen av biler hvert kontor har.
	 */
	
	public void leggTilBiler() {
		
		/* LEGG TIL BILER */
		Bil b1 = new Bil(1, "AU12345", "Tesla", "X", "Svart", Utleiegruppe.STORBIL, true, 25000);
		Bil b2 = new Bil (2, "KZ4389", "Tesla", "2", "Hvit", Utleiegruppe.MELLOMBIL, true, 30000);
		Bil b3 = new Bil(3,"MK6666", "Nissan", "Leaf", "Rosa", Utleiegruppe.LITENBIL, true, 5000);
		Bil b4 = new Bil(4, "LE3898", "Volvo", "VF70", "Hvit", Utleiegruppe.STORBIL, true, 90000);
		Bil b5 = new Bil(5, "NN9161", "Bentley", "GT", "Passion Pink", Utleiegruppe.STORBIL, true, 12300);
		
		biler.add(b1);
		biler.add(b2);
		biler.add(b3);
		biler.add(b4);
		biler.add(b5);
	}
	
	/**
	 * 
	 * @param bilmodell
	 * @return
	 * 
	 * metode for å finne bil objektet man søker etter ved bruk av bilmodell variabelen
	 * 
	 */
	
	public Bil finnBil(String bilmodell) {
		return biler.stream().filter(p -> p.getModell().equals(bilmodell)).collect(Collectors.toList()).get(0);
	}
	
	public int getKontornummer() {
		return kontornummer;
	}

	public void setKontornummer(int kontornummer) {
		this.kontornummer = kontornummer;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public List<Bil> getBiler() {
		return biler;
	}	
	
	public String toString() {
		return "Kontor " + kontornummer + " " + getAdresse().getSted() + "";
	}

}
