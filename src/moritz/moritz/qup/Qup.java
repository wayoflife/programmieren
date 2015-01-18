package moritz.qup;

public class Qup {
public static void main(String[] args) {
	WaitingQueue qu = new WaitingQueue();
	for (int i = 0; i <5; i++) {
		System.out.println("Nummer " + qu.getNummer() + " gezogen");
	}
	
	new DeskApp(qu, "Herr Maier", "Sachbearbeitung 1", "Raum 102");
	new DeskApp(qu, "Herr Schmid", "Sachbearbeitung 2", "Raum 104");
	new DeskApp(qu, "Herr Müller", "Sachbearbeitung 4", "Raum 103");
	new QueueDisplay(qu);
	new QueueDisplay(qu);
}
}
