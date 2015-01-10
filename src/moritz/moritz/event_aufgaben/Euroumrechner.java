package moritz.event_aufgaben;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Euroumrechner extends JFrame{
	
	private JTextField betrag;
	private JButton eur_dm, dm_eur, abort;
	
	public Euroumrechner() {
		// TODO Auto-generated constructor stub
		super("Euroumrechner");
		this.setSize(300,100);
		this.setLayout(new BorderLayout(5,5));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		betrag = new JTextField("Bitte geben sie..");
		eur_dm = new JButton("EUR > DM");
		dm_eur = new JButton("DM > EUR");
		abort = new JButton("Abbrechen");
		
		this.add(betrag, BorderLayout.NORTH);
		this.add(eur_dm, BorderLayout.WEST);
		this.add(dm_eur, BorderLayout.CENTER);
		this.add(abort, BorderLayout.EAST);
		
		eur_dm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String betragWert =betrag.getText();
				Double wert = Double.parseDouble(betragWert);
				betrag.setText(""+ wert*1.955); 
				
			}
		});
		
		dm_eur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String betragWert =betrag.getText();
				Double wert = Double.parseDouble(betragWert);
				betrag.setText(""+ wert/1.955);
			}
		});
		
		abort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Euroumrechner.this.dispose();
			}
		});
		
		
		this.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new Euroumrechner();
	}
}
