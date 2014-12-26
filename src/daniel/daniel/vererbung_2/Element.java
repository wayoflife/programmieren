package daniel.vererbung_2;

public class Element {

	private String name;
	private String symbol;
	private int ordnungszahl;
	private char schale;
	private int aggregatzustand;
	private boolean hauptgruppe;
	
	public Element(String name, String symbol, int ordnungszahl, char schale,
			int aggregatzustand, boolean hauptgruppe) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.ordnungszahl = ordnungszahl;
		this.schale = schale;
		this.aggregatzustand = aggregatzustand;
		this.hauptgruppe = hauptgruppe;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setOrdnungszahl(int ordnungszahl) {
		this.ordnungszahl = ordnungszahl;
	}
	
	public int getOrdnungszahl() {
		return ordnungszahl;
	}
	
	public void setSchale(char schale) {
		this.schale = schale;
	}
	
	public char getSchale() {
		return schale;
	}
	
	public void setAggregatzustand(int aggregatzustand) {
		this.aggregatzustand = aggregatzustand;
	}
	
	public int getAggregatzustand() {
		return aggregatzustand;
	}
	
	public void setHauptgruppe(boolean hauptgruppe) {
		this.hauptgruppe = hauptgruppe;
	}
	
	public boolean isHauptgruppe() {
		return hauptgruppe;
	}
	
	@Override
	public String toString() {
		String h = "H";
		if(!hauptgruppe) h = "N";
		String a = "gasf.|";
		if(aggregatzustand == 1) a = "fest|";
		if(aggregatzustand == 2) a = "fls|";
		return this.symbol + "|" 
				+ this.name + "|" 
				+ this.ordnungszahl + "|" 
				+ this.schale + "|"
				+ a 
				+ h;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Element 
				&& ((Element) obj).getOrdnungszahl() == this.ordnungszahl;
	}
}
