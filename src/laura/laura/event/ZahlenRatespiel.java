package laura.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
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

	private JTextField txtname, txtzahl, txtausgabe;
	private JLabel lblname, lblzahl;
	private JButton btnneu, btnok, btnbester, btnexit;
	private int anzahlVersuche, zahl;
	
	
	public ZahlenRatespiel(){
		super("Zahlen Ratespiel");
		this.setSize(400,300);
		this.setLayout(new GridLayout(4, 1, 5, 5));
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		JPanel pnlname = new JPanel();
		
		lblname = new JLabel("Spielername: ");
		txtname = new JTextField(22);
		
		pnlname.add(lblname);
		pnlname.add(txtname);
		
		JPanel pnlzahl = new JPanel();
		
		lblzahl = new JLabel("Zahl zwischen 1 und 1000 eingeben: ");
		txtzahl = new JTextField(10);
		
		pnlzahl.add(lblzahl);
		pnlzahl.add(txtzahl);
		
		JPanel pnlbutton = new JPanel();
		
		btnneu = new JButton("Neues Spiel");
		btnok = new JButton("ok");
		btnbester = new JButton("Bester");
		btnexit = new JButton("Exit");
		
		pnlbutton.add(btnneu);
		pnlbutton.add(btnok);
		pnlbutton.add(btnbester);
		pnlbutton.add(btnexit);
		
		JPanel pnlausgabe = new JPanel();
		
		txtausgabe = new JTextField(29);
		
		pnlausgabe.add(txtausgabe);
		
		this.add(pnlname);
		this.add(pnlzahl);
		this.add(pnlbutton);
		this.add(pnlausgabe);
		

		
		btnneu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				neuesSpiel();
			}
		});
		
		btnok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtzahl.getText().isEmpty()||txtname.getText().isEmpty()){
				 JOptionPane.showMessageDialog(null, "Keine Eingabe!");
				}
				else {
					anzahlVersuche ++;
					int geraten = Integer.parseInt(txtzahl.getText());
					if (geraten == zahl){
						txtausgabe.setText("Versuch " + anzahlVersuche + ": "+ geraten + " ist richtig!");
						btnok.setEnabled(false);
						gewonnen();
					}
					else if (geraten> zahl){
						txtausgabe.setText("Versuch " + anzahlVersuche + ": "+ geraten + " ist zu hoch!");
					}
					else if (geraten< zahl){
						txtausgabe.setText("Versuch " + anzahlVersuche + ": "+ geraten + " ist zu niedrig!");
					}
				}
			}

			
		});
		
		btnbester.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bestenAnzeigen();
			}
		});
		
		btnexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ZahlenRatespiel.this.dispose();
			}
		});
		
		neuesSpiel();
		setVisible(true);
		
		
		
	}
	
	private void neuesSpiel(){
		anzahlVersuche = 0;
		zahl =(int) ((Math.random() * 1000) + 1);
		txtname.setText("");
		txtzahl.setText("");
		txtausgabe.setText("");
	}
	
	private void bestenAnzeigen(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("zahlenratenhighscore.txt"));
			String[] highscore = {"",""};
			while(br.ready()) highscore = br.readLine().split(": ");
			br.close();
			JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Highscore: " + highscore[0] 
					+ " mit " + highscore[1] + " Versuchen");
		} catch(IOException e){
			JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Highscore konnte nicht gelesen werden.");
		}
	}
	
	private void gewonnen(){
		try{
			FileWriter highscore = new FileWriter("zahlenratenhighscore.txt");
			highscore.write(txtname.getText()+": "+anzahlVersuche);
			highscore.close();
		} catch(IOException e){
			JOptionPane.showMessageDialog(ZahlenRatespiel.this, "Highscore konnte nicht gelesen werden.");
		}
	}
	

	public static void main(String[] args) {
		new ZahlenRatespiel();

	}
	
	

}
