package daniel.probeklausur_1;

public class Raubtier extends ZooTier {
	public Raubtier(String name, String art) {
		super(name, art, "Fleisch");
	}
	
	public String getTierDaten(){
		return super.getTierDaten() + "Raubtier";
	}
}
