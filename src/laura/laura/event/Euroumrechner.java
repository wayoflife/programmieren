package laura.event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Euroumrechner extends JFrame {
	
	private JButton euroZuDm, dmZuEuro, abbrechen;
	private JTextField eingabeBetrag;

	public Euroumrechner(){
		super("Umrechner");
		this.setSize(300,100);
		this.setLayout(new BorderLayout(5,5));
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		eingabeBetrag = new JTextField("Geben Sie einen Betrag ein!");
		euroZuDm = new JButton("In DM umrechnen");
		dmZuEuro = new JButton("In Euro Umrechnen");
		abbrechen = new JButton("ABBRECHEN");
		
		this.add (eingabeBetrag,BorderLayout.NORTH);
		this.add (euroZuDm, BorderLayout.WEST);
		this.add (dmZuEuro, BorderLayout.CENTER);
		this.add (abbrechen, BorderLayout.SOUTH);
		
		euroZuDm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String eingabe = eingabeBetrag.getText();
				Double betrag = Double.parseDouble (eingabe);
				eingabeBetrag.setText(""+ betrag*1.95583);
			}
			
		});
		
		dmZuEuro.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String eingabe = eingabeBetrag.getText();
				Double betrag = Double.parseDouble (eingabe);
				eingabeBetrag.setText(""+ betrag/1.95583);
			}
			
		});

		abbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Euroumrechner.this.dispose();
			}
		});
		
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Euroumrechner();

	}

}
