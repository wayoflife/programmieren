package moritz.event_aufgaben;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Huetchenspiel extends JFrame {
	private JLabel lblspieler;
	private JTextField txtspieler, txtversuch;
	private JButton bthuetchen1, bthuetchen2, bthuetchen3, btstatistik, btexit;
	private int versuche;
	private int huetchen;

	public void neuesSpiel() {
		versuche = 1;
		huetchen = (int) (Math.random() * 3 + 1);
	}
	

	public Huetchenspiel() {
		// TODO Auto-generated constructor stub
		super("Huetchenspiel");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 1, 5, 5));
		this.setSize(400, 300);

		JPanel pnlspieler = new JPanel();
		this.add(pnlspieler);
		lblspieler = new JLabel("Spielername");
		pnlspieler.add(lblspieler);
		txtspieler = new JTextField(20);
		pnlspieler.add(txtspieler);

		JPanel btrow1 = new JPanel();
		this.add(btrow1);
		bthuetchen1 = new JButton("Huetchen 1");
		btrow1.add(bthuetchen1);
		bthuetchen2 = new JButton("Huetchen 2");
		btrow1.add(bthuetchen2);
		bthuetchen3 = new JButton("Huetchen 3");
		btrow1.add(bthuetchen3);

		JPanel btrow2 = new JPanel();
		this.add(btrow2);
		btstatistik = new JButton("Statistik");
		btrow2.add(btstatistik);
		btexit = new JButton("exit");
		btrow2.add(btexit);

		JPanel pnlversuch = new JPanel();
		this.add(pnlversuch);
		txtversuch = new JTextField(25);
		txtversuch.setEditable(false);
		pnlversuch.add(txtversuch);

		bthuetchen1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtspieler.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name fehlt!");
				} else {
					if (huetchen == 1) {
						txtversuch.setText("Versuch " + versuche
								+ " Gewonnen: Die Kugel war unter Hut "
								+ huetchen);
						neuesSpiel();
					} else {
						txtversuch.setText("Versuch " + versuche
								+ " Falsch: Die Kugel war unter Hut "
								+ huetchen);
						versuche++;
						huetchen = (int) (Math.random() * 3 + 1);
					}

				}

			}
		});

		bthuetchen2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtspieler.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name fehlt!");
				} else {
					if (huetchen == 2) {
						txtversuch.setText("Versuch " + versuche
								+ " Gewonnen: Die Kugel war unter Hut "
								+ huetchen);
						neuesSpiel();
					} else {
						txtversuch.setText("Versuch " + versuche
								+ " Falsch: Die Kugel war unter Hut "
								+ huetchen);
						versuche++;
						huetchen = (int) (Math.random() * 3 + 1);
					}

				}

			}
		});

		bthuetchen3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtspieler.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name fehlt!");
				} else {
					if (huetchen == 3) {
						txtversuch.setText("Versuch " + versuche
								+ " Gewonnen: Die Kugel war unter Hut "
								+ huetchen);
						neuesSpiel();
					} else {
						txtversuch.setText("Versuch " + versuche
								+ " Falsch: Die Kugel war unter Hut "
								+ huetchen);
						versuche++;
						huetchen = (int) (Math.random() * 3 + 1);
					}

				}

			}
		});
		
		btexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Huetchenspiel.this.dispose();
				
			}
		});
		
		
		neuesSpiel();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Huetchenspiel();
	}
}
