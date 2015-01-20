package moritz.myshop;

public class Bestellung {
	private Kunde kunde;
	private Produkt produkt;
	
	public Bestellung(Kunde kunde, Produkt produkt) {
		// TODO Auto-generated constructor stub
		this.kunde=kunde;
		this.produkt=produkt;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}
	
	

}
