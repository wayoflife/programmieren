package laura.vererbung_1;

public class Fahrzeug {
	private double position;
	private double geschwindigkeit;
	private double maxgeschwindigkeit;
	private int raeder;
		
	public Fahrzeug(double position, double geschwindigkeit,
			double maxgeschwindigkeit, int raeder) {
		// TODO Auto-generated constructor stub
		this.position = position;
		this.geschwindigkeit = geschwindigkeit;
		this.maxgeschwindigkeit = maxgeschwindigkeit;
		this.raeder = raeder;
	}


	public void bewege(double min){
		if (geschwindigkeit != 0) {
			position = position + ((geschwindigkeit / 60) * min);
		}
	}
	
	public void setGeschwindigkeit(double aktGeschw){
		if (aktGeschw <= maxgeschwindigkeit) {
			geschwindigkeit = aktGeschw;
		} else {
			
		}
	}
	
	public double maxGeschwindigkeit(){
		return maxgeschwindigkeit;
	}
	
	public int anzahlRaeder() {
		return raeder;
	}
	
	public void setMaxgeschwindigkeit(double maxgeschwindigkeit) {
		this.maxgeschwindigkeit = maxgeschwindigkeit;
	}
	
	public String toString(){
		String info =
		"\n Fahrzeugtyp: " + this.getClass().getSimpleName()
			+ "\n Aktuelle Position des Fahrzeugs: " + this.position 
			+ "\n Aktuelle Geschwindigkeit des Fahrzeugs: " + geschwindigkeit 
			+"\n Maximale Geschwindigkeit des Fahrzeugs: "+ maxgeschwindigkeit 
			+ "\n Anzahl der Räder des Fahrzeugs: "+raeder;
		return info;
	}
}
