package no.hvl.dat109;

/**
 * 
 * @author KathrineH
 * 
 * Denne klassen er for returnering av biler.
 * Her lagres det dato og klokkeslett for retur, og den nye kilometeravstanden til bilen som skal oppdateres.
 *
 */

public class Retur {
	
	private String dato;
	private String klokkeslett;
	private int kilometeravstand;
	
	/**
	 * 
	 * @param dato
	 * @param klokkeslett
	 * @param kilometeravstand
	 */
	
	public Retur(String dato, String klokkeslett, int kilometeravstand) {
		this.dato = dato;
		this.klokkeslett = klokkeslett;
		this.kilometeravstand = kilometeravstand;
	}
	
	public String getDato() {
		return dato;
	}
	
	public void setDato(String dato) {
		this.dato = dato;
	}
	
	public String getKlokkeslett() {
		return klokkeslett;
	}
	
	public void setKlokkeslett(String klokkeslett) {
		this.klokkeslett = klokkeslett;
	}
	
	public int getKilometeravstand() {
		return kilometeravstand;
	}
	
	public void setKilometeravstand(int kilometeravstand) {
		this.kilometeravstand = kilometeravstand;
	}
	
}
