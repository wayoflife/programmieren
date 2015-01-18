package laura.jbay;

public class Bieter {
	
	
	private String vorname, nachname;
	
	
	
	public void setFullName(String vorname, String nachname){
		this.nachname = nachname;
		this.vorname = vorname;
	}
	
	public String getFullName(){
		return vorname + " " + nachname;	
	}
}
