package moritz.account_aufgabe;

public class Main {

	public static void main(String[] args) {
		Inhaber daniel = new Inhaber("Daniel", "Betsche");
		Account accdaniel = new Account(1000, daniel);
		System.out.println(accdaniel.toString());

		Inhaber moritz = new Inhaber("Moritz", "Gabriel");
		Account accmoritz = new Account(500, moritz);
		System.out.println(accmoritz.toString());
		
		Transfer trans1 = new Transfer(600, accmoritz, accdaniel);
		
		trans1.execute();
		
		System.out.println(accmoritz.toString());
		System.out.println(accdaniel.toString());
	}

}
