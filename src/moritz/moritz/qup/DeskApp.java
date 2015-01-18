package moritz.qup;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeskApp extends JFrame implements QueueObserver {
	private String mitarbeiter;
	private String arbeitsplatz;
	private String raum;
	private JLabel lblkundewartebereich, lblakutellerkunde;
	private JButton btbearbeitung, btnächsterkunde;
	private WaitingQueue queue;
	private Call currentCall;
	private boolean bearbeitungAktiv = false;

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		this.setTitle(this.arbeitsplatz);
		lblkundewartebereich.setText(this.queue.getWaitingClients()
				+ " Kunden im Wartebereich");
		if (currentCall == null) {
			lblakutellerkunde.setText("---");
		} else {
			lblakutellerkunde.setText("Kunde Nummer "
					+ currentCall.getIdkunde());
		}

	}

	public void erstelleGUI() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1, 5, 5));
		this.setSize(400, 200);

		lblkundewartebereich = new JLabel();
		this.add(lblkundewartebereich);

		lblakutellerkunde = new JLabel();
		this.add(lblakutellerkunde);

		JPanel pnlbottom = new JPanel();
		this.add(pnlbottom);
		btbearbeitung = new JButton("Bearbeitung beginnen");
		btnächsterkunde = new JButton("Nächster Kunde");
		btbearbeitung.setEnabled(false);
		pnlbottom.add(btbearbeitung);
		pnlbottom.add(btnächsterkunde);

	}

	public DeskApp(final WaitingQueue wq, String mitarbeiter,
			String arbeitsplatz, String raum) {
		// TODO Auto-generated constructor stub
		super();
		wq.addQueueObserver(this);
		this.queue = wq;
		this.mitarbeiter = mitarbeiter;
		this.arbeitsplatz = arbeitsplatz;
		this.raum = raum;

		erstelleGUI();
		updateView();

		btnächsterkunde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentCall = wq.getNextCall(DeskApp.this);
				if (currentCall == null) {
					JOptionPane.showMessageDialog(null,
							"Keine wartenden Kunden!");
				} else {
					btbearbeitung.setEnabled(true);
					btnächsterkunde.setEnabled(false);
				}

			}
		});

		btbearbeitung.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (bearbeitungAktiv) {
					currentCall = null;
					bearbeitungAktiv = false;
					btbearbeitung.setText("Bearbeitung beginnen");
					btbearbeitung.setEnabled(false);
					btnächsterkunde.setEnabled(true);
				} else {
					bearbeitungAktiv = true;
					btbearbeitung.setText("Bearbeitung abgeschlossen");
					queue.confirmCall(currentCall);

				}
			}
		});

		this.setVisible(true);
	}

	public String toString() {
		return this.arbeitsplatz + " (" + this.raum + ")";
	}

}
