package daniel.dreieck;

public class Linie {

	private Punkt anfang, ende;
	
	public Linie(Punkt anfang, Punkt ende) {
		this.anfang = anfang;
		this.ende = ende;
	}
	
	public Punkt getAnfang() {
		return anfang;
	}
	
	public Punkt getEnde() {
		return ende;
	}
}
