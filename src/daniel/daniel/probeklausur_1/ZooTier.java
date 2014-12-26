package daniel.probeklausur_1;

public abstract class ZooTier {
	private String name;
	private String art;
	private String lieblingsfutter;
	
	public ZooTier(String name, String art, String futter) {
		this.name = name;
		this.art = art;
		this.lieblingsfutter = futter;
	}
	
	public void fuettern(String futter){
		if(futter == this.lieblingsfutter){
			System.out.println(name + " (" + art + ") frisst " + futter);
		} else {
			System.out.println(name + " (" + art + ") verschm�ht " + futter);
		}
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + " (" + art + ")";
	}
	
	public String getTierDaten(){
		return name+";"+art+";";
	}
}
