package moritz.jbay;

public class Gebot {
	private double hoechstbetrag;
	private Bieter bieter;

	public Gebot(double hoechstbetrag, Bieter bieter) {
		this.hoechstbetrag = hoechstbetrag;
		this.bieter = bieter;
	}

	public double getHoechstbetrag() {
		return hoechstbetrag;
	}

	public void setHoechstbetrag(double hoechstbetrag) {
		this.hoechstbetrag = hoechstbetrag;
	}

	public Bieter getBieter() {
		return bieter;
	}

	public void setBieter(Bieter bieter) {
		this.bieter = bieter;
	}
}
