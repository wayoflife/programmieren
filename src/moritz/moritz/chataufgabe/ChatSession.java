package moritz.chataufgabe;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatSession extends JFrame {
	String nickname;
	Network netz;
	JButton btnick, btwho, btlogoff, btclear;
	JTextArea txtachat;
	JTextField txteingabe;

	public ChatSession(String nickname, final Network netz) {
		// TODO Auto-generated constructor stub
		super("#" + nickname);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.nickname = nickname;
		this.netz = netz;

		JPanel pnlbuttons = new JPanel();
		this.add(pnlbuttons, BorderLayout.NORTH);
		btnick = new JButton("Nick");
		pnlbuttons.add(btnick);
		btwho = new JButton("Who?");
		pnlbuttons.add(btwho);
		btlogoff = new JButton("Logoff");
		pnlbuttons.add(btlogoff);
		btclear = new JButton("Clear");
		pnlbuttons.add(btclear);

		txtachat = new JTextArea();
		JScrollPane scroll = new JScrollPane(txtachat);
		this.add(scroll, BorderLayout.CENTER);

		JPanel pnleingabe = new JPanel();
		this.add(pnleingabe, BorderLayout.SOUTH);
		txteingabe = new JTextField(30);
		pnleingabe.add(txteingabe);

		btnick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String newnick = JOptionPane
						.showInputDialog("Bitte neuen Nick eingeben");
				netz.send(ChatSession.this.nickname
						+ " HAS CHANGED HIS NICK TO " + newnick);
				ChatSession.this.nickname = newnick;
				ChatSession.this.setTitle("#" + newnick);
			}
		});

		btwho.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				txtachat.append("INFO: " + netz.getAllUsersAsString() + "\n");

			}
		});

		btlogoff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChatSession.this.setVisible(false);
				ChatSession.this.dispose();
				netz.send(ChatSession.this.nickname + " HAS LOGGED OF");

			}
		});

		btclear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChatSession.this.txtachat.setText("");
			}
		});

		txteingabe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				netz.send(">>" + txteingabe.getText(),
						ChatSession.this.nickname);
				txteingabe.setText("");

			}
		});

		this.setVisible(true);
	}

}
