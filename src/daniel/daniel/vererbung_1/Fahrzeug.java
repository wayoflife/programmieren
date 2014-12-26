package daniel.vererbung_1;

public class Fahrzeug {
	private double position = 0; //die position des fahrzeugs in km
	private double v = 0; // geschwindigkeit
	private double vmax = 0;
	private int raeder = 0;
	
	public Fahrzeug() {
		this.position = 0;
		this.v = 0;
		this.vmax = 0;
		this.raeder = 0;
	}
	
	public void bewege(double min){
		if(min>0){
			this.position += this.v * min/60.;
		}
	}
	
	public void setGeschwindigkeit(double v){
		if(v<=0){
			this.v = 0;
		} else if(v > vmax){
			this.v = vmax;
		} else {
			this.v = v;
		}
	}
	
	public void maxGeschwindigkeit(double vmax){
		this.vmax = vmax;
	}
	
	public void setRaeder(int r){
		this.raeder = r;
	}
	
	@Override
	public String toString() {
		return "Aktuelle position: " + this.position 
				+"\nAktuelle Geschwindigkeit: " + this.v
				+"\nMaximale Geschwindigkeit: " + this.vmax
				+"\nAnzahl Raeder: " + this.raeder;
	}
}
