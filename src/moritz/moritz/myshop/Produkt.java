package moritz.myshop;

public class Produkt {
	private String name;
	private Lager lager;
	
	public Produkt(String name, Lager lager) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.lager=lager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lager getLager() {
		return lager;
	}

	public void setLager(Lager lager) {
		this.lager = lager;
	}
	
	

}
