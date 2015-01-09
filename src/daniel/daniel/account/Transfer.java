package daniel.account;

public class Transfer {
	Account quellkonto;
	Account zielkonto;
	float betrag;

	Transfer(Account quelle, Account ziel, float ueberweisung) {
		this.quellkonto = quelle;
		this.zielkonto = ziel;
		this.betrag = ueberweisung;
	}

	void execute() {
		this.quellkonto.abhebung(this.betrag);
		this.zielkonto.einzahlung(this.betrag);
	}
}