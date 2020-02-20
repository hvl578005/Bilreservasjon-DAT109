package no.hvl.dat109;

/**
 * 
 * @author KathrineH
 * 
 * Denne klassen er for å lagre reservasjonen til kunden.
 * Dette er for å lett søke opp hvilken bil kunden leier og hvilket kontor den leies/returneres.s
 *
 */

public class Reservasjonsskjema {
	
	private Kontor utleiekontor;
	private Kontor returkontor;
	private String datokl1;
	private String kl;
	private int dager;
	private Bil bil;
	private Kunde kunde;
	
	/**
	 * 
	 * @param utleiekontor
	 * @param returkontor
	 * @param datokl1
	 * @param kl
	 * @param dager
	 * @param bil
	 * @param kunde
	 */
	
	public Reservasjonsskjema (Kontor utleiekontor, Kontor returkontor, String datokl1,
			String kl, int dager, Bil bil, Kunde kunde) {
		this.utleiekontor = utleiekontor;
		this.returkontor = returkontor;
		this.datokl1 = datokl1;
		this.kl = kl;
		this.dager = dager;
		this.bil = bil;
	}
	
	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Kontor getUtleiekontor() {
		return utleiekontor;
	}

	public void setUtleiekontor(Kontor utleiekontor) {
		this.utleiekontor = utleiekontor;
	}

	public Kontor getReturkontor() {
		return returkontor;
	}

	public void setReturkontor(Kontor returkontor) {
		this.returkontor = returkontor;
	}

	public String getDatokl1() {
		return datokl1;
	}

	public void setDatokl1(String datokl1) {
		this.datokl1 = datokl1;
	}

	public int getDager() {
		return dager;
	}

	public void setDager(int dager) {
		this.dager = dager;
	}
	
	

	public Bil getBil() {
		return bil;
	}

	public void setBil(Bil bil) {
		this.bil = bil;
	}
	
	public String getKl() {
		return kl;
	}

	public void setKl(String kl) {
		this.kl = kl;
	}

	@Override
	public String toString() {
		return "Reservasjonsskjema: [utleiekontor=" + utleiekontor + ", returkontor=" + returkontor + ", dato og klokkeslett for utleie="
				+ datokl1 + " " + kl + ", antall dager for ønsket leieopphold=" + dager + ", bil=" + bil.toString() + "]";
	}
	
	

}
