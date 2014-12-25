package moritz.vererbung_1;

public class Fahrzeug {
	double position;
	double geschwindigkeit;
	double maximalgeschwindigkeit;
	int raeder;

	public Fahrzeug() {
		// TODO Auto-generated constructor stub
		this.maximalgeschwindigkeit=0;
		this.raeder=0;
	}

	public Fahrzeug(double position, double geschwindigkeit,
			double maximalgeschwindigkeit, int raeder) {
		this.position=position;
		this.geschwindigkeit=geschwindigkeit;
		this.maximalgeschwindigkeit=0;
		this.raeder=0;

	}

	public void bewege(double minuten) {
		if (geschwindigkeit != 0) {
			position = position + ((geschwindigkeit / 60) * minuten);
		} else {
		}
	}

	public void setGeschwindigkeit(double speed) {
		if (speed <= maximalgeschwindigkeit) {
			geschwindigkeit = speed;
		} else {
		}
	}

	public double maxGeschwindigkeit() {
		return maximalgeschwindigkeit;
	}

	public int anzahlRaeder() {
		return raeder;
	}

	public String toString() {
		String erg = "";
		erg += "Das " + this.getClass().getSimpleName()
				+ " ist ein Fahrzeug mit " + raeder
				+ "Raedern und darf maximal " + maximalgeschwindigkeit
				+ " km/h fahren. \n";
		erg += "Seine aktuelle Geschwindigkeit betraegt " + geschwindigkeit
				+ " km/h. \n";
		erg+= "Es hat bisher " + this.position + " km/h zurückgelegt.";

		return erg;
	}

}
