package daniel.probeklausur_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Zoo {
	
	private int animalcount;
	private ZooTier[] tiere;

	/**Probeklausur Zoo
	 * 
	 * @author Daniel Betsche dbetsche@gmail.com
	 * @param args
	 */
	public static void main(String[] args) {
		Zoo z = new Zoo();
		try {
			z.addAnimal(new Raubtier("Fred", "Tiger"));
			z.addAnimal(new Raubtier("Lisa", "Tiger"));
			z.addAnimal(new Raubtier("Simba", "L�we"));
			z.addAnimal(new Singvogel("Hansi", "Kleiber"));
			z.addAnimal(new Singvogel("Sina", "Schneeammer"));
			z.addAnimal(new Singvogel("Henry", "Zaunkoenig"));
		} catch (ZooCapacityException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			z.saveToFile("zootiere.txt");
			System.out.println("Tiere in Datei gespeichert!");
		} catch (ZooFileException e) {
			System.out.println(e.getMessage());
		}
		
		z.fuettern("K�rner");
		System.out.println("Gibt es 'Fred' im Zoo? " + z.existsAnimal("Fred"));
		System.out.println("Gibt es 'Kimba' im Zoo? " + z.existsAnimal("Kimba"));
		System.out.println("Gibt es 'Henry' im Zoo? " + z.existsAnimal("Henry"));
		System.out.println("Gibt es 'Lotte' im Zoo? " + z.existsAnimal("Lotte"));
	}
	
	public Zoo() {
		this(5);
	}
	
	public Zoo(int max) {
		this.animalcount = 0;
		this.tiere = new ZooTier[max];
	}
	
	public void addAnimal(ZooTier tier) throws ZooCapacityException{
		if(animalcount == tiere.length){
			throw new ZooCapacityException();
		} else {
			tiere[animalcount] = tier;
			animalcount++;
			System.out.println(tier + " wurde zum Zoo hinzugef�gt");
		}
	}
	
	public ZooTier[] getAnimals(){
		return Arrays.copyOf(tiere, animalcount);
	}
	
	public boolean existsAnimal(String name){
		for(ZooTier t : tiere) if(t != null && t.getName() == name) return true;
		return false;
	}
	
	public void fuettern(String futter){
		for(ZooTier t : tiere) if(t != null) t.fuettern(futter);
	}
	
	public void saveToFile(String filename) throws ZooFileException{
		File save = new File(filename);
		try {
			PrintWriter pw = new PrintWriter(save);
			for(ZooTier t: tiere) pw.println(t.getTierDaten());
			pw.close();
		} catch (FileNotFoundException e) {
			throw new ZooFileException();
		}
	}
}
