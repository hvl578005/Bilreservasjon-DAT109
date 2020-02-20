package no.hvl.dat109;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 
 * @author KathrineH
 * hovedklassen, her foregår alle de nødvendige metodene for at brukergrensesnittet skal fungere.
 *
 */

public class Bilreservasjon {
	private Scanner scanner = new Scanner(System.in);
	private Bilutleieselskap bilselskap = new Bilutleieselskap();
	private int kontorutleie;
	private int returkontor;
	private String bilmerke;
	private String modell;
	
	/**
	 * metode for at kunden kan velge om de vil leie bil, returnere bil eller avslutte programmet.
	 */
	
	public void velg() {
		String tekst = "Hei og velkommen til " + bilselskap.getNavn() + " bilutleieselskap!"
				+ "\nHvis du vil leie bil skriv inn 1. \nHvis du vil returnere bil skriv inn 2."
				+ "\nHvis du vil avslutte programmet skriv inn 3.";
				
		System.out.println(tekst);
		
		int svar = scanner.nextInt();
		scanner.nextLine();
		
		switch (svar) {
		case 1: opprettReservasjon(); break;
		case 2: returnerBil(); break;
		case 3: avslutt(); break;
		default: feil(); break;
		}
	}
	
	/**
	 * feilmelding metode
	 */
	
	public void feil() {
		
		String feilmelding = "Feilmelding: Du må skrive inn 1, 2 eller 3. Vennligst prøv igjen.";
		
		System.out.println(feilmelding);
		
		int svar = scanner.nextInt();
		scanner.nextLine();
		
		switch (svar) {
		case 1: opprettReservasjon(); break;
		case 2: returnerBil(); break;
		case 3: avslutt(); break;
		default: feil(); break;
		}
		
	}
	
	/**
	 * metode for å opprette en reservasjon. her brukes i hovedsak scanner slik at programmet kan lese inn
	 * svarene til kunden og bruke dem videre. 
	 */
	
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
		
		System.out.println("Vennligst skriv inn ønsket dato for utleie. Eksempel: 01-01-2020");
		String datoutleie = scanner.nextLine();
		System.out.println("Vennligst skriv inn ønsket klokkeslett for utleie. Eksempel: 01-01-2020");
		String klutleie = scanner.nextLine();
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
		
		Reservasjonsskjema reservasjon = new Reservasjonsskjema(valgt, kontorretur, datoutleie, klutleie, dager, bil, nyKunde);
		
		System.out.println("Du har nå reservert din bil:");
		System.out.println(reservasjon.toString());
		
		nyKunde.leggTilReservasjon(reservasjon);
		
		System.out.println("Du har nå reservert din bil. For å fullføre din reservasjon, vennligst skriv inn:");
		//velg();
		
		System.out.println("Kredittkort nummer:");
		String kredittkort = scanner.nextLine();
		
		
		String regnr = bil.getRegnr();
		String dato = reservasjon.getDatokl1();
		String kl = reservasjon.getKl();
		int dagretur = reservasjon.getDager();
		int kmavstand = bil.getKmavstand();
		
		Utleie utleie = new Utleie (kredittkort, regnr, kmavstand, dato, kl, dagretur);
		
		System.out.println("Tusen takk for din reservasjon, " + nyKunde.getFornavn() + ". Her er din bekreftelse:");
		System.out.println(utleie.toString());
		velg();
		
	}
	
	/**
	 * 
	 * @return nyKunde
	 * metode for å opprette kunde
	 * bruker scanner for å få inn nødvendig kundeinformasjon
	 */
	
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
		
		bilselskap.leggtilKunde(nyKunde);
		
		return nyKunde;

	}

	/**
	 * metode for å returnere bil
	 * med bruk av scanner leses inn telefonnummer og utleie kontor til kunden for å 
	 * kunne hente reservasjonen og bilen kunden har leid
	 * deretter ferdiggjør programmet returneringen
	 */
	
	public void returnerBil() {
		
		System.out.println("Vennligst skriv inn ditt telefonnummer.");
		String telefonnummer = scanner.nextLine();
		System.out.println("Vennligst skriv inn nr til kontor du leide fra.");
		System.out.println(bilselskap.getKontor().toString());
		
		kontorutleie = scanner.nextInt();
		scanner.nextLine();
		String regexTall = "^[1-5]$";
		
		
		while (!Integer.toString(kontorutleie).matches(regexTall)) {
			System.out.println("Vennligst skriv en av kontorene oppført.");
			kontorutleie = scanner.nextInt();	
		}
		
		Kontor valgt = bilselskap.finnKontor(kontorutleie);
		
		Kunde k = bilselskap.finnKunde(telefonnummer);
		
		List<String> bilmerke = k.getReservasjon().stream()
				.map(p -> p.getBil().getBilmerke())
				.collect(Collectors.toList());
				
		List<String> modell = k.getReservasjon().stream()
				.map(p -> p.getBil().getModell())
				.collect(Collectors.toList());
		
		List<Integer> kmavstand = k.getReservasjon().stream()
				.map(p -> p.getBil().getKmavstand())
				.collect(Collectors.toList());
		
		System.out.println("Velkommen tilbake " + k.getFornavn() + " " + k.getEtternavn() + "!");
		System.out.println("Du har leid en " + bilmerke + " " + modell + ".");
		System.out.println("Vennligst skriv inn dato for retur:");
		String datoretur = scanner.nextLine();
		System.out.println("Klokkeslett for retur:");
		String kl = scanner.nextLine();
		System.out.println("Nåværende kilometeravstand på bil:");
		int kmavstandny = scanner.nextInt();
		scanner.nextLine();
	
		Bil b = valgt.finnBil(modell.get(0));
		b.setLedig(true);
		int forrige = b.getKmavstand();
		b.setKmavstand(forrige + kmavstandny);
		
		Retur retur = new Retur(datoretur, kl, forrige+kmavstandny);
		
		System.out.println("Din retur er nå lagret. Takk for at du benyttet deg av WonderCar.");
		
		velg();
		
	}

	/**
	 * metode for å avslutte programmet
	 */
	
	public void avslutt() {
		System.out.println("Ha en fin dag.");
		scanner.close();
	}

}
