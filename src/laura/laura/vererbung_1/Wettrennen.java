package laura.vererbung_1;


public class Wettrennen {
	
	public static void main(String[] args) {
		
		Fahrrad fahrrad = new Fahrrad();
		Auto auto = new Auto();
		Rennwagen rennwagen = new Rennwagen();
		Krankenwagen krankenwagen = new Krankenwagen();
	
		fahrrad.setGeschwindigkeit(20);
		auto.setGeschwindigkeit(150);
		rennwagen.setGeschwindigkeit(200);
		krankenwagen.setGeschwindigkeit(80);
		
		fahrrad.bewege(300);
		auto.bewege(60);
		rennwagen.bewege(60);
		krankenwagen.bewege(60);
		
		System.out.println(fahrrad.toString());
		System.out.println(auto.toString());
		System.out.println(rennwagen.toString());
		System.out.println(krankenwagen.toString());	
	}
}
