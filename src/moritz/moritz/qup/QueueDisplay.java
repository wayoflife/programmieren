package moritz.qup;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueueDisplay extends JFrame implements QueueObserver {
	private JButton btnummer;
	private JTextArea txtaufrufe;
	private JLabel lblletzteraufruf, lblkundenwartebereich;
	private WaitingQueue queue;

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		if (this.queue.getLastCall() == null) {
			lblletzteraufruf.setText("---");
		} else {
			lblletzteraufruf.setText(this.queue.getLastCall().toString());
		}

		lblkundenwartebereich.setText(this.queue.getWaitingClients()
				+ " Kunden im Wartebereich.");

		txtaufrufe.setText("");
		for (Call c : this.queue.getcurrentCalls()) {
			txtaufrufe.append(c.toString() + "\n");

		}

	}

	public void erstelleGUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(5, 5));
		this.setSize(500, 200);

		JPanel pnltop = new JPanel(new GridLayout(2, 1));
		this.add(pnltop, BorderLayout.NORTH);

		lblletzteraufruf = new JLabel();

		lblkundenwartebereich = new JLabel();
		lblletzteraufruf.setFont(new Font(lblletzteraufruf.getFont().getName(),
				Font.PLAIN, 24));
		pnltop.add(lblletzteraufruf);
		pnltop.add(lblkundenwartebereich);

		txtaufrufe = new JTextArea();
		txtaufrufe.setEditable(false);
		JScrollPane scroll = new JScrollPane(txtaufrufe);
		this.add(scroll, BorderLayout.CENTER);

		btnummer = new JButton("Nummer ziehen");
		this.add(btnummer, BorderLayout.SOUTH);
	}

	public QueueDisplay(final WaitingQueue wq) {
		super();
		wq.addQueueObserver(this);
		this.queue = wq;
		

		erstelleGUI();
		updateView();

		btnummer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "" + wq.getNummer());
				queue.updateObservers();

			}
		});

		this.setVisible(true);

	}

	public static void main(String[] args) {
		WaitingQueue wq = new WaitingQueue();

		new QueueDisplay(wq);
	}

}
