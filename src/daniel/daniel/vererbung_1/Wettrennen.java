package daniel.vererbung_1;

public class Wettrennen {

	public static void main(String[] args) {
		Fahrrad f = new Fahrrad();
		f.setGeschwindigkeit(20);
		Auto a = new Auto();
		a.setGeschwindigkeit(150);
		Rennwagen r = new Rennwagen();
		r.setGeschwindigkeit(200);
		Krankenwagen k = new Krankenwagen();
		k.setGeschwindigkeit(80);
		
		f.bewege(5 * 60);
		a.bewege(60);
		r.bewege(60);
		k.bewege(60);
		
		System.out.println(f);
		System.out.println(a);
		System.out.println(r);
		System.out.println(k);
	}
}
