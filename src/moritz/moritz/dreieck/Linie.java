package moritz.dreieck;

public class Linie {
	private Punkt startPunkt;
	private Punkt endPunkt;

	public Linie(Punkt a, Punkt b) {
		// TODO Auto-generated constructor stub
		this.startPunkt = a;
		this.endPunkt = b;
	}

	public double berechneLaenge() {
		return Math.sqrt(
				Math.pow(this.startPunkt.getxKoordinate()- this.endPunkt.getxKoordinate(), 2)
				+ Math.pow(this.startPunkt.getyKoordinate()	- this.endPunkt.getyKoordinate(), 2)
						);
	}
	
	public Punkt getStartPunkt() {
		return startPunkt;
	}

	public void setStartPunkt(Punkt startPunkt) {
		this.startPunkt = startPunkt;
	}

	public Punkt getEndPunkt() {
		return endPunkt;
	}

	public void setEndPunkt(Punkt endPunkt) {
		this.endPunkt = endPunkt;
	}

}
