package no.hvl.dat109;

public class Adresse {
	
	private String gateAdresse;
	private String postnr;
	private Sted sted;
	private String kundeSted;
	
	public Adresse (String gateAdresse, String postnr, Sted sted) {
		this.gateAdresse = gateAdresse;
		this.postnr = postnr;
		this.sted = sted;
	}
	
	public Adresse (String gateAdresse, String postnr, String kundeSted) {
		this.gateAdresse = gateAdresse;
		this.postnr = postnr;
		this.kundeSted = kundeSted;
	}
	
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
