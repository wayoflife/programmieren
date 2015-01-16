package moritz.chataufgabe;

public class Chat {
	
	public static void main(String[] args) {
		Network netz1 = new Network();
		ChatSession chat1 = new ChatSession("Tick", netz1);
		ChatSession chat3 = new ChatSession("Trick", netz1);
		ChatSession chat2 = new ChatSession("Track", netz1);
		netz1.addChat(chat1);
		netz1.addChat(chat2);
		netz1.addChat(chat3);
		
		
		
	}

}
