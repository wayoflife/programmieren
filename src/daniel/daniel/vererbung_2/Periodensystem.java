package daniel.vererbung_2;

import java.util.ArrayList;

public class Periodensystem {

	private Element[] elemente;
	
	public Periodensystem() {
		elemente = new Element[118];
		this.addElement(new Element("Wasserstoff", "H", 1, 'K', 3, true));
		this.addElement(new Element("Helium", "He", 2, 'K', 3, true));
		this.addElement(new Metall("Natrium", "Na", 11, 'M', 1, true, false, 21e6));
		this.addElement(new Metall("Eisen", "Fe", 26, 'N', 1, false, false, 10.02e6));
		this.addElement(new Metall("Germanium", "Ge", 32, 'N', 1, false, true, 1.45));
		this.addElement(new Element("Brom", "Br", 35, 'N', 2, true));
		this.addElement(new Metall("Tellur", "Te", 52, 'O', 1, true, true, 0.005));
		this.addElement(new Metall("Gold", "Au", 79, 'P', 1, false, false, 44e6));
	}
	
	public static void main(String[] args) {
		Periodensystem p = new Periodensystem();
		for(Element e : p.getAllMetalls()){
			System.out.println(e);
		}
		System.out.println(p.getElement(79));
	}
	
	public void addElement(Element e){
		if(this.elemente[e.getOrdnungszahl()] == null) this.elemente[e.getOrdnungszahl()] = e;
	}
	
	public boolean hasElement(int oz){
//		if(this.elemente[oz] != null) return true;
//		return false;
		return this.elemente[oz] != null;
	}
	
	public Element getElement(int oz){
		return this.elemente[oz];
	}
	
	public Element[] getAllMetalls(){
		ArrayList<Element> temp = new ArrayList<>();
		for(Element e : elemente) if(e instanceof Metall && !((Metall) e).isHalbmetall()) temp.add(e);
		return temp.toArray(new Element[0]);
	}
}
