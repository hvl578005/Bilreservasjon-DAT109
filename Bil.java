package no.hvl.dat109;

public class Bil {
	
	private int id;
	private String regnr;
	private String bilmerke;
	private String modell;
	private String farge;
	private Utleiegruppe utleiegruppe;
	private boolean ledig;
	
	public Bil(int id, String regnr, String bilmerke, String modell, String farge, Utleiegruppe utleiegruppe, boolean ledig) {
		this.id = id;
		this.regnr = regnr;
		this.bilmerke = bilmerke;
		this.modell = modell;
		this.farge = farge;
		this.utleiegruppe = utleiegruppe;
		this.ledig = true;
	}
	
	public Bil() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegnr() {
		return regnr;
	}
	
	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}
	
	public String getBilmerke() {
		return bilmerke;
	}
	
	public void setBilmerke(String bilmerke) {
		this.bilmerke = bilmerke;
	}
	
	public String getModell() {
		return modell;
	}
	
	public void setModell(String modell) {
		this.modell = modell;
	}
	
	public String getFarge() {
		return farge;
	}
	
	public void setFarge(String farge) {
		this.farge = farge;
	}
	
	public Utleiegruppe getUtleiegruppe() {
		return utleiegruppe;
	}
	
	public void setUtleiegruppe(Utleiegruppe utleiegruppe) {
		this.utleiegruppe = utleiegruppe;
	}
	
	public boolean isLedig() {
		return ledig;
	}
	
	public void setLedig(boolean ledig) {
		this.ledig = ledig;
	}

	@Override
	public String toString() {
		return "Bil nummer " + id + ":" + "Regnr=" + regnr + ", bilmerke=" + bilmerke + ", modell=" + modell + ", farge=" + farge
				+ ", utleiegruppe=" + utleiegruppe + "\n";
	}
	
	
	
}
