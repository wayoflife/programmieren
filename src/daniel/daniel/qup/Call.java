package daniel.qup;

public class Call {
	
	private int Kundennummer;
	private DeskApp deskApp;
	public Call(int kundennummer, DeskApp deskApp) {
		super();
		Kundennummer = kundennummer;
		this.deskApp = deskApp;
	}
	
	public int getKundennummer() {
		return Kundennummer;
	}
	
	public DeskApp getDeskApp() {
		return deskApp;
	}
	
	@Override
	public String toString() {
		return Kundennummer + ": " + deskApp.toString();
	}
}
