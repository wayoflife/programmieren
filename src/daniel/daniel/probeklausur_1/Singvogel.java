package daniel.probeklausur_1;

public class Singvogel extends ZooTier {
	public Singvogel(String name, String art) {
		super(name, art, "K�rner");
	}
	
	public String getTierDaten(){
		return super.getTierDaten() + "Singvogel";
	}
}
