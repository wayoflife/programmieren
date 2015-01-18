package laura.jbay;

public class Gebot {
	
	private double hoechst;
	private Bieter bieter;
	
	public Gebot(double hoechst, Bieter bieter){
		this.hoechst = hoechst;
		this.bieter = bieter;
	}
	
	public void setHoechst(double hoechst){
		this.hoechst = hoechst;
	}
	
	public double getHoechst(){
		return hoechst;
		
	}
	
	public void setBieter(Bieter bieter){
		this.bieter = bieter;
	}
	
	public Bieter getBieter(){
		return bieter;		
	}
}
