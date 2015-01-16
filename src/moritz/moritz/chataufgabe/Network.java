package moritz.chataufgabe;

import java.util.ArrayList;

public class Network {

	ArrayList<ChatSession> chats = new ArrayList<ChatSession>();

	public Network() {
		// TODO Auto-generated constructor stub
	}

	public void addChat(ChatSession chat) {
		chats.add(chat);
	}

	public void send(String message, String nickname) {

		for (ChatSession c : chats) {
			c.txtachat.append("#" + nickname + ": " + message + "\n");
		}
	}

	public void send(String message) {
		for (ChatSession c : chats) {
			c.txtachat.append("INFO: " + message + "\n");
		}
	}

	public String getAllUsersAsString() {
		StringBuilder user = new StringBuilder();
		for (ChatSession c : chats) {
			user.append("#" + c.nickname + " ");
		}

		return user.toString();
	}

}
