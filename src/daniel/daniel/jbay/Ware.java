package daniel.jbay;

public class Ware {
	
	private String titel, beschreibung;

	public Ware(String titel, String beschreibung) {
		this.titel = titel;
		this.beschreibung = beschreibung;
	}
	
	public String getTitel() {
		return this.titel;
	}
	
	public String getBeschreibung() {
		return this.beschreibung;
	}
}
