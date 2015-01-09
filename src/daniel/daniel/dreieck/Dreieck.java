package daniel.dreieck;

public class Dreieck {
	private Punkt a, b, c;

	public Dreieck(Punkt a, Punkt b, Punkt c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void verschieben(double x, double y){
		a.verschieben(x, y);
		b.verschieben(x, y);
		c.verschieben(x, y);
	}
	
	public void rotieren(double winkel){
		a.rotate(winkel);
		b.rotate(winkel);
		c.rotate(winkel);
	}
	
	public double umfang(){
		return abstand(a, b) + abstand(b, c) + abstand(c, a);
	}
	
	private double abstand(Punkt a, Punkt b){ //Hilfsmethode zum ausrechnen des Abstands zwischen zwei Punkten 
		return Math.sqrt(Math.pow(b.getX()-a.getX(),2)+Math.pow(b.getY()-a.getY(),2));
	}
	
	public double flaeche(){
		double s = 0.5 * umfang();
		double abstand_a = abstand(a, b);
		double abstand_b = abstand(b, c);
		double abstand_c = abstand(c, a);
		return Math.sqrt(s * (s-abstand_a)*(s-abstand_b)*(s-abstand_c));
	}
}
