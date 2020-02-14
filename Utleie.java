package no.hvl.dat109;

public class Utleie {
	
	String kredittkort;
	String registreringsnummer;
	int kmavstand;
	String dato;
	String kl;
	String dator;
	String klr;
	
	public Utleie (String kredittkort, String registreringsnummer, int kmavstand, String dato, String kl, String dator, String klr) {
		this.kredittkort = kredittkort;
		this.registreringsnummer = registreringsnummer;
		this.kmavstand = kmavstand;
		this.dato = dato;
		this.kl = kl;
		this.dator = dator;
		this.klr = klr;
	}

	public String getKredittkort() {
		return kredittkort;
	}

	public void setKredittkort(String kredittkort) {
		this.kredittkort = kredittkort;
	}

	public String getRegistreringsnummer() {
		return registreringsnummer;
	}

	public void setRegistreringsnummer(String registreringsnummer) {
		this.registreringsnummer = registreringsnummer;
	}

	public int getKmavstand() {
		return kmavstand;
	}

	public void setKmavstand(int kmavstand) {
		this.kmavstand = kmavstand;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getKl() {
		return kl;
	}

	public void setKl(String kl) {
		this.kl = kl;
	}

	public String getDator() {
		return dator;
	}

	public void setDator(String dator) {
		this.dator = dator;
	}

	public String getKlr() {
		return klr;
	}

	public void setKlr(String klr) {
		this.klr = klr;
	}
	
	

}
