package daniel.account;

public class Account {
	String kontoinhaber;
	float kontostand;

	Account(String pkontoinhaber, float pkontostand) {
		this.kontoinhaber = pkontoinhaber;
		this.kontostand = pkontostand;
	}

	float getKontostand() {
		return this.kontostand;
	}

	void abhebung(float betrag) {
		this.kontostand -= betrag;
	}

	void einzahlung(float betrag) {
		this.kontostand += betrag;
	}
}