package moritz.event_aufgaben;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ratespiel extends JFrame {
	private JLabel spielerName, zahlEingabe;
	private JTextField name, txtZahl, versuche;
	private JButton neuesSpiel, ok, bester, exit;
	private int anzahlVersuche;
	private int zahl;

	public void neuesSpiel() {
		anzahlVersuche = 0;
		zahl = (int) ((Math.random() * 1000) + 1);
		name.setText("");
		txtZahl.setText("");
		versuche.setText("");

	}

	public void gewonnen() {
		try {
			FileWriter fw = new FileWriter("highscore.txt");
			fw.write(name.getText() + "/" + txtZahl.getText());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Ratespiel() {
		// TODO Auto-generated constructor stub
		super("Ratespiel");
		this.setSize(500, 500);
		this.setLayout(new GridLayout(4, 1, 5, 5));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel nameEingabe = new JPanel();
		this.add(nameEingabe);
		spielerName = new JLabel("Spielername");
		nameEingabe.add(spielerName);
		name = new JTextField(20);
		nameEingabe.add(name);

		JPanel zahlEingabePNL = new JPanel();
		this.add(zahlEingabePNL);
		zahlEingabe = new JLabel("Zahl zwischen 0 und 1000 eingeben");
		zahlEingabePNL.add(zahlEingabe);
		txtZahl = new JTextField(10);
		zahlEingabePNL.add(txtZahl);

		JPanel buttons = new JPanel();
		this.add(buttons);
		neuesSpiel = new JButton("Neues Spiel");
		buttons.add(neuesSpiel);
		ok = new JButton("Ok");
		buttons.add(ok);
		bester = new JButton("Bester");
		buttons.add(bester);
		exit = new JButton("Exit");
		buttons.add(exit);

		JPanel pnlversuche = new JPanel();
		this.add(pnlversuche);
		versuche = new JTextField("Anzahl Versuche", 40);
		pnlversuche.add(versuche);

		neuesSpiel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				neuesSpiel();

			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ratespiel.this.dispose();
			}
		});

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtZahl.getText().isEmpty() || name.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Eingabe fehlt! Depp!");
				} else {
					anzahlVersuche++;
					int gerateneZahl = Integer.parseInt(txtZahl.getText());
					if (gerateneZahl == zahl) {
						versuche.setText("Versuch " + anzahlVersuche + " "
								+ gerateneZahl + " ist korrekt");
						ok.setEnabled(false);
						gewonnen();

					} else if (gerateneZahl < zahl) {
						versuche.setText("Versuch " + anzahlVersuche + " "
								+ gerateneZahl + " ist zu klein");

					} else if (gerateneZahl > zahl) {
						versuche.setText("Versuch " + anzahlVersuche + " "
								+ gerateneZahl + " ist zu groß");
					}
				}

			}
		});

		bester.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					BufferedReader br = new BufferedReader(new FileReader(
							"highscore.txt"));
					if (br.ready()) {
						JOptionPane.showMessageDialog(null, br.readLine()) ;
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Fehler");
				}
			}

		});

		neuesSpiel();

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ratespiel();
	}
}
