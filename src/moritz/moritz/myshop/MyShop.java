package moritz.myshop;

import java.util.LinkedList;
import java.util.List;

public class MyShop {

	public static void main(String[] args) {
		Lager werkzeuge = new Lager("Werkzeuge");
		Lager gartenbedarf = new Lager("Gartenbedarf");
		
		List<Produkt> produkte = new LinkedList<Produkt>();
		produkte.add(new Produkt("Hammer 500 gr.", werkzeuge));
		produkte.add(new Produkt("Schraubenzieher 10mm", werkzeuge));
		produkte.add(new Produkt("Veilchen", gartenbedarf));
		produkte.add(new Produkt("Torf 20kg", gartenbedarf));
		new KundenTerminal(produkte);
		
	}
}


// moritz.gabriel@gmx.de

/*Buttons ließen sich nicht rot färben, wegen MacOS*/