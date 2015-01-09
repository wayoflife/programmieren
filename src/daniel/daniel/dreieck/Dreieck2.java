package daniel.dreieck;

public class Dreieck2 {
	private Linie l1, l2, l3;

	public Dreieck2(Punkt p1, Punkt p2, Punkt p3) {
		l1 = new Linie(p1, p2);
		l2 = new Linie(p2, p3);
		l3 = new Linie(p3, p1);
	}

	public Dreieck2(Linie l1, Linie l2, Linie l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}
}
