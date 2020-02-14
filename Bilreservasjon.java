package no.hvl.dat109;

import java.util.Scanner;

public class Bilreservasjon {
	private Scanner scanner = new Scanner(System.in);
	private Bilutleieselskap bilselskap = new Bilutleieselskap();
	private int kontorutleie;
	private int returkontor;
	private String bilmerke;
	private String modell;
	
	public void velg() {
		String tekst = "Hei og velkommen til " + bilselskap.getNavn() + " bilutleieselskap!"
				+ "\nHvis du vil leie bil skriv inn 1. \nHvis du vil returnere bil skriv inn 2.";
				
		System.out.println(tekst);
		
		int svar = scanner.nextInt();
		scanner.nextLine();
		
		switch (svar) {
		case 1: opprettReservasjon();
		case 2: returnerBil();
		default: feil();
		}
	}
	
	public void feil() {
		
		String feilmelding = "Feilmelding: Du må skrive inn 1 eller 2. Vennligst prøv igjen.";
		
		System.out.println(feilmelding);
		
		int svar = scanner.nextInt();
		scanner.nextLine();
		
		switch (svar) {
		case 1: opprettReservasjon();
		case 2: returnerBil();
		default: feil();
		}
		
	}
	
	
	public void opprettReservasjon() {
	
		System.out.println("Vennligst skriv inn nr til hvilket av våre kontorer du ønsker å leie bil fra.");
		System.out.println(bilselskap.getKontor().toString());
		
		kontorutleie = scanner.nextInt();
		scanner.nextLine();
		String regexTall = "^[1-5]$";
		
		
		while (!Integer.toString(kontorutleie).matches(regexTall)) {
			System.out.println("Vennligst skriv en av kontorene oppført.");
			kontorutleie = scanner.nextInt();	
		}
		
		Kontor valgt = bilselskap.finnKontor(kontorutleie);
		
		System.out.println("Takk for at du valgte kontor " + valgt.toString());
		System.out.print("Vennligst skriv inn hvor du ønsker å returnere bilen");
		
		returkontor = scanner.nextInt();
		scanner.nextLine();
		
		while (!Integer.toString(returkontor).matches(regexTall)) {
			System.out.println("Vennligst skriv en av kontorene oppført.");
			returkontor = scanner.nextInt();
		}
		
		Kontor kontorretur = bilselskap.finnKontor(returkontor);
		
		System.out.println(kontorretur.toString() + " er registrert.");
		
		System.out.println("Vennligst skriv inn ønsket dato og klokkeslett for utleie. Eksempel: 01-01-2020 kl 13:00");
		String datoutleie = scanner.nextLine();
		System.out.println("Vennligst skriv inn dager for ønsket leie opphold.");
		int dager = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println();
		System.out.println("Liste over tilgjengelige biler til dagene du har valgt " + valgt.toString());
		
		System.out.println(valgt.getBiler().toString());
		System.out.println();
		
		System.out.println("Pris for liten bil per dag = 1000 kr"
				+ "\nPris for mellom bil = 1200 kr"
				+ "\nPris for stor bil = 1500 kr"
				+ "\nPris for stasjonsvogn er 1700 kr");
		
		System.out.println("Vennligst skriv inn hvilket bilmerke, deretter modell du ønsker.");
		bilmerke = scanner.nextLine();
		
		while (!valgt.getBiler().stream().anyMatch(p -> p.getBilmerke().contentEquals(bilmerke))) {
			System.out.println("Ikke registrert bilmerke, dobbeltsjekk for skrivefeil. Prøv igjen");
			bilmerke = scanner.nextLine();
		}
		
		System.out.println(bilmerke + " er registrert. Skriv inn modell.");
		modell = scanner.nextLine();
		
		while (!valgt.getBiler().stream().anyMatch(p -> p.getModell().contentEquals(modell))) {
			System.out.println("Ikke registrert bilmerke, dobbeltsjekk for skrivefeil. Prøv igjen");
			modell = scanner.nextLine();
		}
		
		Bil bil = valgt.finnBil(modell);
		bil.setLedig(false);
		
		Kunde nyKunde = opprettKunde();
		
		Reservasjonsskjema reservasjon = new Reservasjonsskjema(valgt, kontorretur, datoutleie, dager, bil);
		
		System.out.println("Du har nå reservert din bil. Her er din bekreftelse:");
		System.out.println(reservasjon.toString());
		
		nyKunde.leggTilReservasjon(reservasjon);
		
	}
	
	public void returnerBil() {
		
	}
	
	public Kunde opprettKunde() {
		
		Kunde nyKunde = new Kunde();
		
		System.out.println("Vennligst skriv inn din kundeinformasjon."
				+ "\nFornavn:");
		String fornavn = scanner.nextLine();
		System.out.println("Etternavn:");
		String etternavn = scanner.nextLine();
		System.out.println("Telefonnummer:");
		String telefonnummer = scanner.nextLine();
		System.out.println("Adresse (gate adresse, post nr, sted)");
		String gateadresse = scanner.nextLine();
		String postnr = scanner.nextLine();
		String sted = scanner.nextLine();
		
		Adresse kundeadr = new Adresse(gateadresse, postnr, sted);
		
		nyKunde.setFornavn(fornavn);
		nyKunde.setEtternavn(etternavn);
		nyKunde.setTelefonnummer(telefonnummer);
		nyKunde.setAdresse(kundeadr);
		
		System.out.println("Velkommen, her er din kundeprofil.");
		System.out.println(nyKunde.toString());
		
		return nyKunde;

	}
	
	public Utleie betaling() {
		
	}
	

/*	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			t.setText(("\nVelkommen til utleie kontor " + sted.toString() + "!"));
			
		}catch(NullPointerException n) {
			System.out.println("feil");
			
		}
		
	}*/

}
