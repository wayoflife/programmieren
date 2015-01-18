package laura.jbay;

import java.util.Calendar;

public class Auktion {
	
	private Ware ware;
	private Gebot gebot;
	private double preis;
	private Calendar ende;
	private static double INCREMENT = 1.0;
	
	public Auktion (){
		this.gebot = null;
		this.preis = 0.0;
	}
	
	public boolean gebotAbgeben(Gebot g){
		if(g.getHoechst() < (preis+INCREMENT)){
			return false;
		}
		if(this.gebot == null){
			this.gebot = g;
			this.preis = INCREMENT;
			return true;
		}
		if (g.getBieter()== gebot.getBieter()){
			if (gebot.getHoechst()< g.getHoechst()){
				this.gebot = g;				
				return true;
			}
			else{
				return false;
			}		
		}
		if (g.getHoechst()<gebot.getHoechst() && g.getHoechst() > (preis+INCREMENT)){
			this.preis = g.getHoechst();
			return false;
		}
		if (g.getHoechst()>gebot.getHoechst() && g.getHoechst() > (preis+INCREMENT)){
			this.preis = gebot.getHoechst()+INCREMENT;
			this.gebot = g;
			return true;
		}
		return false;		
	}
}
