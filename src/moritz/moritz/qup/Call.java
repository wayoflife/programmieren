package moritz.qup;

public class Call {
	private int idkunde;
	private DeskApp deskapp;

	public Call(int kunde, DeskApp deskapp) {
		// TODO Auto-generated constructor stub
		this.idkunde = kunde;
		this.deskapp = deskapp;
	}

	public int getIdkunde() {
		return idkunde;
	}

	public void setIdkunde(int idkunde) {
		this.idkunde = idkunde;
	}

	public DeskApp getDeskapp() {
		return deskapp;
	}

	public void setDeskapp(DeskApp deskapp) {
		this.deskapp = deskapp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.idkunde + ": " + this.deskapp.toString();
	}

}
