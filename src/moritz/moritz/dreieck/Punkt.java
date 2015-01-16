package moritz.dreieck;

public class Punkt {
	private double xKoordinate;
	private double yKoordinate;

	public Punkt(double x, double y) {
		// TODO Auto-generated constructor stub
		this.xKoordinate = x;
		this.yKoordinate = y;
	}

	public void verschieben(double x, double y) {
		xKoordinate += x;
		yKoordinate += y;
	}

	public double berechneAbstand(Punkt p) {
		return Math.sqrt(Math.pow(this.xKoordinate - p.xKoordinate, 2)
				+ Math.pow(this.yKoordinate - p.yKoordinate, 2));
	}

	public double getxKoordinate() {
		return xKoordinate;
	}

	public void setxKoordinate(double xKoordinate) {
		this.xKoordinate = xKoordinate;
	}

	public double getyKoordinate() {
		return yKoordinate;
	}

	public void setyKoordinate(double yKoordinate) {
		this.yKoordinate = yKoordinate;
	}

}
