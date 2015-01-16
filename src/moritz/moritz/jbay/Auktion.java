package moritz.jbay;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Auktion {
	private Ware ware;
	private Gebot gebot;
	private double aktuellerPreis;
	private Calendar endeAuktion;
	private static double INCREMENT = 1.0;

	public Auktion() {
		// TODO Auto-generated constructor stub
		this.gebot = null;
		this.aktuellerPreis = 0.0;
	}

	public Ware getWare() {
		return ware;
	}

	public Gebot getGebot() {
		return gebot;
	}

	public double getAktuellerPreis() {
		return aktuellerPreis;
	}

	public Calendar getEndeAuktion() {
		return endeAuktion;
	}

	public static double getINCREMENT() {
		return INCREMENT;
	}

	public boolean gebotAbgeben(Gebot g) {
		FileWriter fw;
		try {
			fw = new FileWriter("gebote.txt", true);
			fw.write("[" + Calendar.getInstance().getTime().toString() + "]"
					+ " Gebot von " + g.getBieter().getFullName()
					+ " für " + this.ware.titel + " "
					+ g.getHoechstbetrag() + " Euro." + "\n");
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		if (g.getHoechstbetrag() < aktuellerPreis + INCREMENT) {
			return false;
		}
		if (gebot == null) {
			gebot = g;
			aktuellerPreis = INCREMENT;
			return true;
		}
		if (g.getBieter().equals(gebot.getBieter())) {
			gebot = g;
			return true;
		}
		if (g.getHoechstbetrag() >= aktuellerPreis + INCREMENT
				&& g.getHoechstbetrag() <= aktuellerPreis) {
			aktuellerPreis = Math.min(g.getHoechstbetrag() + INCREMENT,
					gebot.getHoechstbetrag());
			return true;
		}
		if (g.getHoechstbetrag() >= aktuellerPreis + INCREMENT
				&& g.getHoechstbetrag() > gebot.getHoechstbetrag()) {
			aktuellerPreis = Math.min(g.getHoechstbetrag(),
					gebot.getHoechstbetrag() + INCREMENT);
			return true;
		}
		return false;

	}

	Auktion(Ware ware, int dauer) {
		this.ware = ware;
		endeAuktion = Calendar.getInstance();
		endeAuktion.setTimeInMillis(System.currentTimeMillis() + dauer * 60
				* 1000);
	}

	public String getFullName() {
		if (gebot == null) {
			return "---";
		}
		return gebot.getBieter().getFullName();
	}
}
