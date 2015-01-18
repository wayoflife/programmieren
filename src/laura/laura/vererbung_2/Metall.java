package laura.vererbung_2;

public class Metall extends Element{
	
	private boolean halbmetall;
	private double leitfähigkeit;

	public Metall(String name, String symbol, int ordnungszahl, char schale,
			int agg, boolean hg, boolean halbmetall, double leitfähigkeit) {
		
		super(name, symbol, ordnungszahl, schale, agg, hg);
		// TODO Auto-generated constructor stub
		
		this.halbmetall = halbmetall;
		this.leitfähigkeit = leitfähigkeit;
		
	}
	
	public void setHalbmetall(boolean halbmetall) {
		this.halbmetall = halbmetall;
	}
	
	public boolean isHalbmetall() {
		return halbmetall;
	}
	
	public void setLeitfähigkeit(double leitfähigkeit) {
		this.leitfähigkeit = leitfähigkeit;
	}
	
	public double getLeitfähigkeit() {
		return leitfähigkeit;
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
				+ "\n Leitfähigkeit: " + this.leitfähigkeit;
			
		return info;
	}


		
	
		
	
}
