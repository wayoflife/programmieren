package moritz.dreieck;

public class Dreieck2{
	private Linie linie1;
	private Linie linie2;
	private Linie linie3;
	
	public Dreieck2(Punkt a, Punkt b, Punkt c) {
		// TODO Auto-generated constructor stub
		this.linie1 = new Linie(a, b);
		this.linie2 = new Linie(b, c);
		this.linie3 = new Linie(c, a);
		
	}
	
	public Dreieck2(Linie a, Linie b, Linie c){
		this.linie1=a;
		this.linie2=b;
		this.linie3=c;
	}
	

}
