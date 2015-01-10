package moritz.jbay;

import java.util.ArrayList;
import java.util.List;

public class Auktionshaus {
	private ArrayList<Auktion> auktionen = new ArrayList<>();
	private ArrayList<BieterTerminal> terminals = new ArrayList<>();

	
	public void addAuktion(Auktion a){
		auktionen.add(a);
	}
	
	public void removeAuktion(Auktion a){
		auktionen.remove(a);
	}
	
	public List<Auktion> getAuktionen(){
		return auktionen;
	}
	
	public void registerTerminal(BieterTerminal b){
		terminals.add(b);
	}
	
	public void unregisterTerminal(BieterTerminal b){
		terminals.remove(b);
	}
	
	public void updateTerminals(){
		for (BieterTerminal b : terminals) {
			b.update();
		}
	}
}

