package moritz.vererbung_2;

public class Metall extends Element {
	private boolean halbmetall;
	private double leitfaehigkeit;

	public Metall(String name, String symbol, int ordnungszahl, char schale,
			int zustand, boolean hauptgruppe, boolean halbmetall,
			double leitfaehigkeit) {
		// TODO Auto-generated constructor stub
		super(name, symbol, ordnungszahl, schale, zustand, hauptgruppe);
		this.halbmetall = halbmetall;
		this.leitfaehigkeit = leitfaehigkeit;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Das Element " + this.getName() + " hat das Symbol "
				+ this.getSymbol() + " und hat die Ordnungszahl "
				+ this.getOrdnungszahl() + ".\n"
				+ " Element befindet sich in einer Hauptgruppe: "
				+ this.isHauptgruppe() + ".\n"
				+ "Seine Leitfaehigkeit betraegt " + this.leitfaehigkeit
				+ " und es ist ein Halbmetall: " + this.leitfaehigkeit + ".";
	}

}
