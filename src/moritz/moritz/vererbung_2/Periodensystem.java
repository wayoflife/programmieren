package moritz.vererbung_2;

import java.util.ArrayList;

import daniel.vererbung_2.Element;
import daniel.vererbung_2.Metall;

public class Periodensystem {

	Element[] elemente = new Element[118];

	public boolean hasElement(int oz) {
		if(elemente[oz]==null){
			return false;
		}
		return true;
	}

	public void addElement(Element e) {
		if (elemente[e.getOrdnungszahl()] == null) {
			elemente[e.getOrdnungszahl()] = e;
		}
	}

	public Element getElement(int oz) {
		return elemente[oz];
	}

	public Element[] getAllMetalls() {
		ArrayList<Element> temp = new ArrayList<Element>();
		for (Element e : elemente) {
			if (e instanceof Metall && !((Metall) e).isHalbmetall()) {
				temp.add(e);
			}

		}
		return temp.toArray(new Element[0]);
	}

	public static void main(String[] args) {
		Periodensystem test = new Periodensystem();
		test.addElement(new Element("Wasserstoff", "H", 1, 'K', 3, true));
		test.addElement(new Element("Helium", "He", 2, 'K', 3, true));
		test.addElement(new Metall("Natrium", "Na", 11, 'M', 1, true, false,
				21e6));
		test.addElement(new Metall("Eisen", "Fe", 26, 'N', 1, false, false,
				10.02e6));
		test.addElement(new Metall("Germanium", "Ge", 32, 'N', 1, false, true,
				1.45));
		test.addElement(new Element("Brom", "Br", 35, 'N', 2, true));
		test.addElement(new Metall("Tellur", "Te", 52, 'O', 1, true, true,
				0.005));
		test.addElement(new Metall("Gold", "Au", 79, 'P', 1, false, false, 44e6));

		System.out.println(test.getElement(79));

		for (Element e : test.getAllMetalls()) {
			System.out.println(e);
		}

	}
}
