package no.hvl.dat109;

/**
 * 
 * @author KathrineH
 * klassen for å fullføre reservasjonen. her betaler man med kredittkort
 *
 */

public class Utleie {
	
	private String kredittkort;
	private String registreringsnummer;
	private int kmavstand;
	private String dato;
	private String kl;
	private int dager;
	
	/**
	 * 
	 * @param kredittkort
	 * @param registreringsnummer
	 * @param kmavstand
	 * @param dato
	 * @param kl
	 * @param dager
	 */
	
	public Utleie (String kredittkort, String registreringsnummer, int kmavstand, String dato, String kl, int dager) {
		this.kredittkort = kredittkort;
		this.registreringsnummer = registreringsnummer;
		this.kmavstand = kmavstand;
		this.dato = dato;
		this.kl = kl;
		this.dager = dager;
	}
	
	public Utleie () {
		
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

	

	public int getDager() {
		return dager;
	}

	public void setDager(int dager) {
		this.dager = dager;
	}

	@Override
	public String toString() {
		return "Utleie: Kredittkort: ***************. Registreringsnummer: " + registreringsnummer 
				+ ". Kilometeravstand: " + kmavstand + ". Dato og klokkeslett for leie: " + dato + " " + kl 
				+ ". Antall dager for leie: " + dager + ".";
	}
	
	
	
	

}
