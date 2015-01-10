package daniel.jbay;

public class Bieter {
	
	private String vorname, nachname;
	

	public Bieter(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public String getFullName(){
		return vorname + " " + nachname;
	}
}
