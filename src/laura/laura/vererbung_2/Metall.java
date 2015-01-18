package laura.vererbung_2;

public class Metall extends Element{
	
	private boolean halbmetall;
	private double leitf�higkeit;

	public Metall(String name, String symbol, int ordnungszahl, char schale,
			int agg, boolean hg, boolean halbmetall, double leitf�higkeit) {
		
		super(name, symbol, ordnungszahl, schale, agg, hg);
		// TODO Auto-generated constructor stub
		
		this.halbmetall = halbmetall;
		this.leitf�higkeit = leitf�higkeit;
		
	}
	
	public void setHalbmetall(boolean halbmetall) {
		this.halbmetall = halbmetall;
	}
	
	public boolean isHalbmetall() {
		return halbmetall;
	}
	
	public void setLeitf�higkeit(double leitf�higkeit) {
		this.leitf�higkeit = leitf�higkeit;
	}
	
	public double getLeitf�higkeit() {
		return leitf�higkeit;
	}
		

	@Override
	
	public String toString() {
		String info =
				"\n Element: " + this.getName()
				+ "\n Symbol: " + this.getSymbol() 
				+ "\n Ordnungszahl: " + this.getOrdnungszahl() 
				+ "\n Schale: " + this.getSchale() 
				+ "\n Aggregatszustand: " + this.getAggregatzustand() 
				+ "\n Hauptgruppe: " + this.isHauptgruppe()
				+ "\n Halbmetall: " + this.halbmetall 
				+ "\n Leitf�higkeit: " + this.leitf�higkeit;
			
		return info;
	}


		
	
		
	
}
