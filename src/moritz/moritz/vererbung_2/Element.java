package moritz.vererbung_2;

public class Element {
	private String name;
	private String symbol;
	private int ordnungszahl;
	private char schale;
	private int zustand;
	private boolean hauptgruppe;

	public Element(String name, String symbol, int ordnungszahl, char schale,
			int zustand, boolean hauptgruppe) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.symbol = symbol;
		this.ordnungszahl = ordnungszahl;
		this.schale = schale;
		this.zustand = zustand;
		this.hauptgruppe = hauptgruppe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getOrdnungszahl() {
		return ordnungszahl;
	}

	public void setOrdnungszahl(int ordnungszahl) {
		this.ordnungszahl = ordnungszahl;
	}

	public char getSchale() {
		return schale;
	}

	public void setSchale(char schale) {
		this.schale = schale;
	}

	public int getZustand() {
		return zustand;
	}

	public void setZustand(int zustand) {
		this.zustand = zustand;
	}

	public boolean isHauptgruppe() {
		return hauptgruppe;
	}

	public void setHauptgruppe(boolean hauptgruppe) {
		this.hauptgruppe = hauptgruppe;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Das Element " + this.name + " hat das Symbol " + this.symbol
				+ " und hat die Ordnungszahl " + this.ordnungszahl + ".\n"
				+ " Element befindet sich in einer Hauptgruppe: "
				+ this.hauptgruppe;
	}
	
	public boolean equals(Object o){
		boolean w = false;
		if(o instanceof Element){
			Element p = (Element) o;
			if(this.ordnungszahl==p.ordnungszahl){
				w=true;
			}
		}
		
		
		
		return w;
	}

}
