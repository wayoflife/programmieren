package daniel.probeklausur_1;

public class ZooFileException extends Exception {
	public ZooFileException() {
		super("Fehler: Tiere konnten nicht in Datei gespeichert werden!");
	}
}
