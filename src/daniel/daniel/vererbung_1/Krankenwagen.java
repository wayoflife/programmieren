package daniel.vererbung_1;

public class Krankenwagen extends Auto {
	private boolean blaulicht;
	
	public Krankenwagen() {
		super();
		this.blaulicht = false;
	}
	
	public void blaulichtschalten(){
		this.blaulicht = !this.blaulicht;
	}
	
	public boolean blaulichtAn(){
		return this.blaulicht;
	}
}
