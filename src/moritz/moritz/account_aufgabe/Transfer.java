package moritz.account_aufgabe;

public class Transfer {
	private double betrag;
	private Account source;
	private Account ziel;

	public Transfer(double betrag, Account source, Account ziel) {
		// TODO Auto-generated constructor stub
		this.betrag = betrag;
		this.source = source;
		this.ziel = ziel;
	}

	public void execute() {
		if (source.getKontostand() > this.betrag) {
			ziel.einzahlen(this.betrag);
			source.auszahlen(this.betrag);
		} else {
			System.out
					.println("Ueberweisung nicht moeglich, da zu wenig Geld auf dem Konto des Senders zur Verfuegung steht!");
		}
	}

}
