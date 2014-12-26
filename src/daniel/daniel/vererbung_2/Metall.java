package daniel.vererbung_2;

public class Metall extends Element {

	private boolean halbmetall;
	private double leitfaehigkeit;
	
	public Metall(String name, String symbol, int ordnungszahl, char schale,
			int aggregatzustand, boolean hauptgruppe, boolean halbtmetall,
			double leitfaehigkeit) {
		super(name, symbol, ordnungszahl, schale, aggregatzustand, hauptgruppe);
		this.halbmetall = halbtmetall;
		this.leitfaehigkeit = leitfaehigkeit;
	}

	public void setHalbmetall(boolean halbmetall) {
		this.halbmetall = halbmetall;
	}
	
	public boolean isHalbmetall() {
		return halbmetall;
	}
	
	public void setLeitfaehigkeit(double leitfaehigkeit) {
		this.leitfaehigkeit = leitfaehigkeit;
	}
	
	public double getLeitfaehigkeit() {
		return leitfaehigkeit;
	}
	
	@Override
	public String toString() {
		return super.toString() + "|" 
				+ this.halbmetall + "|"
				+ this.leitfaehigkeit;
	}
}
