package no.hvl.dat109;

public class Reservasjonsskjema {
	
	private Kontor utleiekontor;
	private Kontor returkontor;
	private String datokl1;
	private int dager;
	private Bil bil;
	
	public Reservasjonsskjema (Kontor utleiekontor, Kontor returkontor, String datokl1, int dager, Bil bil) {
		this.utleiekontor = utleiekontor;
		this.returkontor = returkontor;
		this.datokl1 = datokl1;
		this.dager = dager;
		this.bil = bil;
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

	@Override
	public String toString() {
		return "Reservasjonsskjema: [utleiekontor=" + utleiekontor + ", returkontor=" + returkontor + ", dato og klokkeslett for utleie="
				+ datokl1 + ", antall dager for ønsket leieopphold=" + dager + ", bil=" + bil.toString() + "]";
	}
	
	

}
