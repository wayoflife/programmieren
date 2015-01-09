package daniel.event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Euroumrechner extends JFrame implements ActionListener{
	
	private JButton abbrechen;
	
	public Euroumrechner() {
		super("Euroumrechner");
		this.setSize(300, 100);
		this.setLayout(new BorderLayout(5, 5));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTextField textfield = new JTextField();
		this.add(textfield, BorderLayout.NORTH);
		
		JButton eurDM = new JButton("Eur->DM"); 
		this.add(eurDM, BorderLayout.WEST);
		eurDM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textfield.setText("" + (Double.parseDouble(textfield.getText())*1.95583));
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
				}
			}
		});
		
		JButton dmEUR = new JButton("DM->Eur"); 
		this.add(dmEUR, BorderLayout.CENTER);
		dmEUR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textfield.setText("" + (Double.parseDouble(textfield.getText())/1.95583));
				} catch (NumberFormatException nfe) {
					// TODO: handle exception
				}
			}
		});
		
		abbrechen = new JButton("Abbrechen"); 
		this.add(abbrechen, BorderLayout.EAST);
		abbrechen.addActionListener(this);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Euroumrechner();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == abbrechen) {
			this.dispose();
		}
	}
}
