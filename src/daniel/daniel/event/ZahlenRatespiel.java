package daniel.event;

import java.awt.GridLayout;
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

public class ZahlenRatespiel extends JFrame {
	
	private int zahl, versuche;
	
	private JLabel lblname, lblzahl;
	private JTextField txtname, txtzahl, txtanzeige;
	private JButton btnneu, btnok, btnbester, btnexit;
	
	public ZahlenRatespiel() {
		super("Zahlen Ratespiel");
		this.setSize(600, 300);
		this.setLayout(new GridLayout(4, 1, 5, 5));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlname = new JPanel();
		this.add(pnlname);
		lblname = new JLabel("Spielername");
		pnlname.add(lblname);
		txtname = new JTextField(20);
		pnlname.add(txtname);
		
		JPanel pnlzahl = new JPanel();
		this.add(pnlzahl);
		lblzahl = new JLabel("Zahl zwischen 1 und 1000 eingeben");
		pnlzahl.add(lblzahl);
		txtzahl = new JTextField(5);
		pnlzahl.add(txtzahl);
		
		JPanel pnlbuttons = new JPanel();
		this.add(pnlbuttons);
		btnneu = new JButton("neu");
		pnlbuttons.add(btnneu);
		btnneu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				neuesspiel();
				JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Ein neues Spiel wurde gestartet");
			}
		});
		
		btnok = new JButton("ok");
		pnlbuttons.add(btnok);
		btnok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtname.getText().isEmpty() || txtzahl.getText().isEmpty()){
					JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Leeres Eingabefeld. "
							+ "Bitte gib deinen Namen und eine Zahl ein.");
				} else {
					try{
						int raten = Integer.parseInt(txtzahl.getText());
						if(raten < 1 || raten > 1000) throw new NumberFormatException();
						versuche++;
						if(raten == zahl) {
							txtanzeige.setText("Versuch Nr." + versuche + " " + raten + " ist die richtige Zahl! "
									+ "Gratuliere, du hast gewonnen!");
							gewonnen();
							btnok.setEnabled(false);
						}
						if(raten < zahl) txtanzeige.setText("Versuch Nr." + versuche + " " + raten + " ist zu niedrig");
						if(raten > zahl) txtanzeige.setText("Versuch Nr." + versuche + " " + raten + " ist zu hoch");
					} catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Ung�ltige Zahl. "
								+ "Bitte gib eine ganze Zahl zwischen 1 und 1000 ein");
					}
				}
			}
		});
		
		btnbester = new JButton("bester");
		pnlbuttons.add(btnbester);
		btnbester.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bestenAnzeigen();
			}
		});
		
		btnexit = new JButton("exit");
		pnlbuttons.add(btnexit);
		btnexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZahlenRatespiel.this.dispose();
			}
		});
		
		JPanel pnlanzeige = new JPanel();
		this.add(pnlanzeige);
		txtanzeige = new JTextField(40);
		pnlanzeige.add(txtanzeige);
		
		neuesspiel();
		
		this.pack();
		this.setVisible(true);
	}
	
	private void bestenAnzeigen(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("zahlenratenhighscore.txt"));
			String[] highscore = {"",""};
			while(br.ready()) highscore = br.readLine().split(";");
			br.close();
			JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Highscore: " + highscore[0] 
					+ " mit " + highscore[1] + " Versuchen");
		} catch(IOException e){
			JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Highscore konnte nicht gelesen werden.");
		}
	}
	
	private void gewonnen(){
		try{
			FileWriter fw = new FileWriter("zahlenratenhighscore.txt");
			fw.write(txtname.getText()+";"+versuche);
			fw.close();
		} catch(IOException e){
			JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Highscore konnte nicht gelesen werden.");
		}
	}
	
	private void neuesspiel(){
		versuche = 0;
		zahl = (int) (1 + (Math.random() * 1000));
		txtzahl.setText("");
		txtanzeige.setText("");
		btnok.setEnabled(true);
	}

	public static void main(String[] args) {
		new ZahlenRatespiel();
	}
}