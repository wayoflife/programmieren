package moritz.account_aufgabe;

public class Account {
	private double kontostand;
	private Inhaber inhaber;

	public double getKontostand() {
		return kontostand;
	}

	public void einzahlen(double betrag) {
		if (betrag > 0) {
			this.kontostand = this.kontostand + betrag;
		}
	}

	public void auszahlen(double betrag) {
		if (betrag < this.kontostand) {
			this.kontostand = this.kontostand - betrag;
		}
	}
	
	public Account(double kontostand, Inhaber inhaber) {
		this.kontostand=kontostand;
		this.inhaber=inhaber;
	}

	@Override
	public String toString() {
		return "Der Account von " + this.inhaber.vorname + " "
				+ this.inhaber.nachname + " hat einen Kontostand von: "
				+ this.kontostand;
	}

}
