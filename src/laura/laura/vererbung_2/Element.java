package laura.vererbung_2;

public class Element {

	private String name;
	private String symbol;
	private int ordnungszahl;
	private char schale;
	private int agg;
	private boolean hg;
	
	public Element(	String name, String symbol, int ordnungszahl, char schale,
	int agg, boolean hg){
		this.name = name;
		this.symbol =symbol;
		this.ordnungszahl = ordnungszahl;
		this.schale = schale;
		this.agg = agg;
		this.hg = hg;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName (){
		return name;
	}

	public void setSymbol(String symbol){
		this.symbol = symbol;
	}
	
	public String getSymbol(){
		return symbol;
	}
	
	public void setOrdnungszahl(int ordnungszahl){
		this.ordnungszahl = ordnungszahl;
	}
	
	public int getOrdnungszahl(){
		return ordnungszahl;
	}
	
	public void setSchale(char schale){
		this.schale = schale;
	}
	
	public char getSchale(){
		return schale;
	}
	public void setAggregatzustand(int agg){
		this.agg = agg;
	}
	
	public int getAggregatzustand(){
		return agg;
	}
	
	public void setHauptgruppe(boolean hg){
		this.hg = hg;
	}
	
	public boolean isHauptgruppe(){
		return hg;
	}
	
	@Override 
	public String toString() {
		String info =
				"\n Element: " + this.name 
				+ "\n Symbol: " + this.symbol 
				+ "\n Ordnungszahl: " + this.ordnungszahl 
				+ "\n Schale: " + this.schale 
				+ "\n Aggregatszustand: " + this.agg 
				+ "\n Hauptgruppe: " + this.hg + "\n";
		return info;
	}
	
	public boolean equals(Object o){
		 
		boolean gleich = false;
		if (o instanceof Element){
			 Element e = (Element)o;
			 if (this.ordnungszahl == e.ordnungszahl){
				 gleich = true;
			 }
		}
		return gleich;
	}

}
