package moritz.myshop;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;

public class Lager{
	private String name;
	private LinkedList<Bestellung> bestellungen = new LinkedList<Bestellung>();
	private LagerTerminal lt;
	
	public Lager(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.lt = new LagerTerminal(this);
		
		
	}
	
	public void addBestellung(Bestellung b){
		bestellungen.add(b);
	}
	
	public void removeBestellung(Bestellung b){
		bestellungen.remove(b);
	}
	
	public LinkedList<Bestellung> getallBestellungen(){
		return bestellungen;
	}

	public String getName() {
		return name;
	}

}
