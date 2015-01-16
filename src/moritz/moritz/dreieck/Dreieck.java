package moritz.dreieck;

public class Dreieck {
	private Punkt punkt1;
	private Punkt punkt2;
	private Punkt punkt3;

	public Dreieck(Punkt p1, Punkt p2, Punkt p3) {
		// TODO Auto-generated constructor stub
		this.punkt1 = p1;
		this.punkt2 = p2;
		this.punkt3 = p3;
	}

	/*
	 * public void verschiebeDreieck(int x, int y){
	 * this.punkt1.setxKoordinate(this.punkt1.getxKoordinate()+x);
	 * this.punkt1.setyKoordinate(this.punkt1.getyKoordinate()+y);
	 * 
	 * this.punkt2.setxKoordinate(this.punkt2.getxKoordinate()+x);
	 * this.punkt2.setyKoordinate(this.punkt2.getyKoordinate()+y);
	 * 
	 * this.punkt3.setxKoordinate(this.punkt3.getxKoordinate()+x);
	 * this.punkt3.setyKoordinate(this.punkt3.getyKoordinate()+y);
	 * 
	 * Verschieben ohne Methode in der Klasse Punkt }
	 */

	public void verschiebeDreieck(int x, int y) {
		// Verbesserte Methode nach Einsicht der Loesung:
		punkt1.verschieben(x, y);
		punkt2.verschieben(x, y);
		punkt3.verschieben(x, y);
	}

	public double berechneUmfang() {
		// Die Methode berechneAbstand ist im Nachhinein etwas umst�ndlich, aber
		// sollte trotzdem funktionieren
		return this.punkt1.berechneAbstand(this.punkt2)
				+ this.punkt2.berechneAbstand(this.punkt3)
				+ this.punkt3.berechneAbstand(this.punkt3);
	}

	public double berechneFlaecheninhalt() {
		double a = 0;
		double s = 0.5 * (berechneUmfang());
		double abstanda = this.punkt1.berechneAbstand(this.punkt2);
		double abstandb = this.punkt2.berechneAbstand(this.punkt3);
		double abstandc = this.punkt3.berechneAbstand(this.punkt1);
		a = Math.sqrt(s * (s - abstanda) * (s - abstandb) * (s - abstandc));

		return a;
	}

	public Punkt getPunkt1() {
		return punkt1;
	}

	public void setPunkt1(Punkt punkt1) {
		this.punkt1 = punkt1;
	}

	public Punkt getPunkt2() {
		return punkt2;
	}

	public void setPunkt2(Punkt punkt2) {
		this.punkt2 = punkt2;
	}

	public Punkt getPunkt3() {
		return punkt3;
	}

	public void setPunkt3(Punkt punkt3) {
		this.punkt3 = punkt3;
	}

}
