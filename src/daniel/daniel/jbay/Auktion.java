package daniel.jbay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class Auktion {
	
	private static final double INCREMENT = 1.0;
	
	private Ware ware;
	private Gebot gebot;
	private double preis;
	private Calendar ende;
	private File log;

	public Auktion(Ware w, int dauer) {
		this.ware = w;
		this.preis = 0.0;
		ende = Calendar.getInstance();
		ende.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
		log = new File("auktionen.txt");
	}

	public boolean gebotAbgeben(Gebot g){
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(log, true));
			pw.println("[" + Calendar.getInstance().getTime().toString()+"] Gebot von " 
						+ g.getBieter().getFullName() + " f�r " + ware.getTitel() +": " + g.getMaxgebot());
			pw.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if(g.getMaxgebot() < preis + INCREMENT) return false;
		if(gebot == null) {
			this.preis = INCREMENT;
			this.gebot = g;
			return true;
		}
		if(gebot.getBieter().equals(g.getBieter())) {
			this.gebot = g;
			return true;
		}
		if(g.getMaxgebot() >= preis+INCREMENT && g.getMaxgebot() <= gebot.getMaxgebot()){
			this.preis = g.getMaxgebot() + INCREMENT;
			return false;
		}
		if(g.getMaxgebot() >= preis+INCREMENT && g.getMaxgebot() > gebot.getMaxgebot()){
			this.preis = gebot.getMaxgebot() + INCREMENT;
			this.gebot = g;
			return true;
		}
		return false;
	}
	
	public Calendar getEnde() {
		return ende;
	}
	
	public Gebot getGebot() {
		return gebot;
	}
	
	public double getPreis() {
		return preis;
	}
	
	public Ware getWare() {
		return ware;
	}
	
	public static double getIncrement() {
		return INCREMENT;
	}

	public boolean beendet() {
		return Calendar.getInstance().after(ende);
	}
	
	public String getTitel(){
		return ware.getTitel();
	}
	
	public String getFullName(){
		if(gebot == null){
			return "---";
		} else {
			return gebot.getBieter().getFullName();
		}
	}
	
	public double getMindestgebot(){
		return preis + INCREMENT;
	}
}
