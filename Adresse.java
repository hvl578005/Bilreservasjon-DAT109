package no.hvl.dat109;

/**
 * 
 * @author KathrineH
 * 
 * Denne klassen sørger for at bilselskapet og hver kunde og kontor
 * får en adresse bestående av gate adresse, post nr og sted.
 * Kontor og selskap bruker enum til Sted siden det finnes kun 5 kontorer,
 * men kunder kan være fra overalt i Norge så de bruker en annen konstruktør
 * der sted er en String
 *
 */

public class Adresse {
	
	private String gateAdresse;
	private String postnr;
	private Sted sted;
	private String kundeSted;
	
	/**
	 * 
	 * @param gateAdresse
	 * @param postnr
	 * @param sted
	 */
	
	public Adresse (String gateAdresse, String postnr, Sted sted) {
		this.gateAdresse = gateAdresse;
		this.postnr = postnr;
		this.sted = sted;
	}
	
	/**
	 * 
	 * @param gateAdresse
	 * @param postnr
	 * @param kundeSted
	 */
	
	public Adresse (String gateAdresse, String postnr, String kundeSted) {
		this.gateAdresse = gateAdresse;
		this.postnr = postnr;
		this.kundeSted = kundeSted;
	}

	/**
	 * 
	 */
	
	public Adresse() {
		
	}
	
	
	public String getGateAdresse() {
		return gateAdresse;
	}
	
	public void setGateAdresse(String gateAdresse) {
		this.gateAdresse = gateAdresse;
	}
	
	
	public Sted getSted() {
		return sted;
	}

	public void setSted(Sted sted) {
		this.sted = sted;
	}

	public String getKundeSted() {
		return kundeSted;
	}

	public void setKundeSted(String kundeSted) {
		this.kundeSted = kundeSted;
	}

	public String getPostnr() {
		return postnr;
	}

	public void setPostnr(String postnr) {
		this.postnr = postnr;
	}

	@Override
	public String toString() {
		return "Adresse: " + gateAdresse + " " + postnr + " " + kundeSted + ".";
	}
	
}
