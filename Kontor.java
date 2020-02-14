package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kontor {
	
	private int kontornummer;
	private Adresse adresse;
	private String telefonnummer;
	private List<Bil> biler;
	
	
	public Kontor(int kontornummer, Adresse adresse, String telefonnummer) {
		biler = new ArrayList<Bil>();
		this.kontornummer = kontornummer;
		this.telefonnummer = telefonnummer;
		this.adresse = new Adresse(adresse.getGateAdresse(), adresse.getPostnr(), adresse.getSted());
		
	}
	
	public void leggTilBiler() {
		
		/* LEGG TIL BILER */
		Bil b1 = new Bil(1, "AU12345", "Tesla", "X", "Svart", Utleiegruppe.STORBIL, true);
		Bil b2 = new Bil (2, "KZ4389", "Tesla", "2", "Hvit", Utleiegruppe.MELLOMBIL, true);
		Bil b3 = new Bil(3,"MK6666", "Nissan", "Leaf", "Rosa", Utleiegruppe.LITENBIL, true);
		Bil b4 = new Bil(4, "LE3898", "Volvo", "VF70", "Hvit", Utleiegruppe.STORBIL, true);
		Bil b5 = new Bil(5, "NN9161", "Bentley", "GT", "Passion Pink", Utleiegruppe.STORBIL, true);
		
		biler.add(b1);
		biler.add(b2);
		biler.add(b3);
		biler.add(b4);
		biler.add(b5);
	}
	
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
