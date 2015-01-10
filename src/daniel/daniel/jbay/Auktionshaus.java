package daniel.jbay;

import java.util.ArrayList;
import java.util.List;

public class Auktionshaus {
	
	private ArrayList<Auktion> auktionen = new ArrayList<>();
	private ArrayList<BieterTerminal> terminals = new ArrayList<>();

	public Auktionshaus() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAuktion(Auktion a){
		auktionen.add(a);
	}
	
	public void removeAuktion(Auktion a){
		auktionen.remove(a);
	}
	
	public List<Auktion> getAuktionen(){
		return auktionen;
	}
	
	public void register(BieterTerminal bt){
		terminals.add(bt);
	}
	
	public void unregister(BieterTerminal bt){
		terminals.remove(bt);
	}
	
	public void updateTerminals(){
		for(int i=0; i<terminals.size(); i++){
			terminals.get(i).update();
		}
	}
}
