package moritz.myshop;

public class Kunde {
	private String vorname;
	private String nachname;
	
	public Kunde(String vor, String nach) {
		// TODO Auto-generated constructor stub
		this.vorname=vor;
		this.nachname=nach;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.vorname + " " + this.nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	

}
