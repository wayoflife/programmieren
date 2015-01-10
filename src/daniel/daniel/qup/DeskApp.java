package daniel.qup;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeskApp extends JFrame implements QueueObserver{
	
	private String typ, raum, mitarbeiter;
	private JLabel waiting, current;
	private JButton bearbeiten, next;
	
	private WaitingQueue qu;
	private Call currentCall;
	private boolean bearbeitungAktiv;

	public DeskApp(String typ, String raum, String mitarbeiter, WaitingQueue qu) {
		qu.addQueueObeserver(this);
		this.qu = qu;
		this.typ = typ;
		this.raum = raum;
		this.mitarbeiter = mitarbeiter;
		bearbeitungAktiv = false;
		init();
	}

	private void init() {
		this.setSize(300, 200);
		this.setLayout(new GridLayout(3,1,5,5));
		this.setTitle(typ);
		
		waiting = new JLabel();
		this.add(waiting);
		
		current = new JLabel();
		this.add(current);
		
		JPanel buttons = new JPanel();
		bearbeiten = new JButton("Bearbeitung beginnen");
		bearbeiten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bearbeitungAktiv) {
					bearbeitungAktiv = false;
					currentCall = null;
					bearbeiten.setText("Bearbeitung beginnen");
					bearbeiten.setEnabled(false);
					next.setEnabled(true);
				} else {
					bearbeitungAktiv = true;
					qu.confirmCall(currentCall);
					bearbeiten.setText("Bearbeitung abgeschlossen"); 
					DeskApp.this.pack();
					//warum verschwindet der zweite button?
				}
			}
		});
		bearbeiten.setEnabled(false);
		buttons.add(bearbeiten);
		
		next = new JButton("N�chster Kunde");
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentCall = qu.getNextCall(DeskApp.this);
				if(currentCall == null){
					JOptionPane.showMessageDialog(DeskApp.this, "Keine wartenden Kunden!");
				} else {
					next.setEnabled(false);
					bearbeiten.setEnabled(true);
					updateView();
				}
			}
		});
		buttons.add(next);
		this.add(buttons);		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void updateView() {
		this.waiting.setText("Noch " + qu.getWaitingClients() + " Kunden im Wartebereich");
		if(currentCall == null) {
			current.setText("---");
		} else {
			current.setText("Kunde Nummer " + currentCall.getKundennummer());
		}		
	}
	
	@Override
	public String toString() {
		return typ + " (" + raum + ")";
	}

}
