package daniel.dreieck;

public class Punkt {
	private double x;
	private double y;

	public Punkt(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void verschieben(double x, double y) {
		this.x += x;
		this.y += y;
	}

	public void rotate(double winkel) {
		double radius = Math.sqrt(x * x + y * y);
		this.x = radius * Math.cos(winkel);
		this.y = radius * Math.sin(winkel);
	}
}
