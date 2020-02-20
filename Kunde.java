package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author KathrineH
 * 
 * Dette er objekt klassen for kunder. Hver kunde har en liste av reservasjoner der det står oppført
 * hvilken bil også videre kunden leier.
 *
 */

public class Kunde {
	
	private String fornavn;
	private String etternavn;
	private Adresse adresse;
	private String telefonnummer;
	private List<Reservasjonsskjema> reservasjon;
	
	/**
	 * 
	 * @param fornavn
	 * @param etternavn
	 * @param adresse
	 * @param telefonnummer
	 */
	
	public Kunde(String fornavn, String etternavn, Adresse adresse, String telefonnummer) {
		reservasjon = new ArrayList<Reservasjonsskjema>();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefonnummer = telefonnummer;
	}
	/**
	 * 
	 */
	
	public Kunde() {
		reservasjon = new ArrayList<Reservasjonsskjema>();
		
	}
	
	/**
	 * 
	 * @param r
	 * 
	 * metode for å legge til reservasjon i reservasjonslisten til kunden
	 */
	
	public void leggTilReservasjon(Reservasjonsskjema r) {
		reservasjon.add(r);
	}
	
	
	public String getFornavn() {
		return fornavn;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
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


	public List<Reservasjonsskjema> getReservasjon() {
		return reservasjon;
	}

	@Override
	public String toString() {
		return "Kunde: " + fornavn + " " + etternavn + " " + adresse +  " Telefonnummer: " + telefonnummer;
	}

}
