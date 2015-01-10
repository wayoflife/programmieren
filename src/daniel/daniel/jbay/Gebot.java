package daniel.jbay;

public class Gebot {
	
	private double maxgebot;
	private Bieter bieter;

	public Gebot(double maxgebot, Bieter bieter) {
		this.maxgebot = maxgebot;
		this.bieter = bieter;
	}
	
	public Bieter getBieter() {
		return bieter;
	}
	
	public double getMaxgebot() {
		return maxgebot;
	}
}
