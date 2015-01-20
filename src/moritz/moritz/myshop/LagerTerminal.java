package moritz.myshop;

import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LagerTerminal extends JFrame{
	private JLabel lblbestellungen, lblbestellt, temp;
	private Lager lager;
	
	
	public void aeltesteBestellungAusgeliefert(){
		lager.getallBestellungen().remove(lager.getallBestellungen().size()-1);
		temp.validate();
	}
	
	public void schreiben(String text){
		try{
			FileWriter fw = new FileWriter("Auslieferungen.txt");
			fw.write(text);
			fw.close();
		} catch(IOException e){
			JOptionPane.showMessageDialog(null, "Datei konnte nicht gelesen werden.");
		}
	}
	
	public void updateTerminal(){
		
		this.getContentPane().removeAll();
		for (Bestellung b : lager.getallBestellungen()) {
			this.add(temp);
			temp.add(new JLabel(b.getKunde().toString()));
			temp.add(new JLabel(b.getProdukt().getName()));
				
		}
		
	}

	
	public LagerTerminal(final Lager lager) {
		// TODO Auto-generated constructor stub
		super(lager.getName());
		this.lager=lager;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(200, lager.getallBestellungen().size()*100);
		this.setLayout(new GridLayout(lager.getallBestellungen().size(), 1));
		this.setSize(300, 300);
		
		
		updateTerminal();
		
		new Thread(){
			public void run(){
				while(true){
					if(lager.getallBestellungen().size()>1){
						aeltesteBestellungAusgeliefert();
						try {
							Thread.sleep((long) (Math.random()*15 + 1));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		}.start();
		
		
		this.setVisible(true);
	}

}
