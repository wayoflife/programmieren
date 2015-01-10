package daniel.qup;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueueDisplay extends JFrame implements QueueObserver{
	
	private JLabel lastCall, waiting;
	private JTextArea calls;
	private JButton getNumber;
	
	private WaitingQueue qu;

	public QueueDisplay(final WaitingQueue qu) {
		this.qu = qu;
		qu.addQueueObeserver(this);
		init();
		
		new Thread(){
			public void run() {
				try {
					int i = 0;
					while(true){
						Call[] calls = qu.getCurrentCalls();
						if(calls.length > 0){
							i = i%calls.length;
							lastCall.setText(calls[i].toString());
							i++;
						} else {
							i = 0;
							lastCall.setText("---");
						}
						Thread.sleep(5 * 1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	private void init() {
		this.setSize(500, 300);
		this.setLayout(new BorderLayout(5, 5));
		
		JPanel head = new JPanel(new GridLayout(2,1));
		lastCall = new JLabel();
		lastCall.setFont(new Font(lastCall.getFont().getName(), Font.PLAIN, 24));
		head.add(lastCall);
		waiting = new JLabel();
		head.add(waiting);
		this.add(head, BorderLayout.NORTH);
		
		calls = new JTextArea();
		JScrollPane scp = new JScrollPane(calls);
		scp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scp, BorderLayout.CENTER);
		
		JPanel button = new JPanel();
		getNumber = new JButton("Nummer ziehen");
		getNumber.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int number = qu.getNextQueueNumber();
				JOptionPane.showMessageDialog(QueueDisplay.this, "Sie haben die Nummer " + number);
			}
		});
		button.add(getNumber);
		this.add(button, BorderLayout.SOUTH);
		
		updateView();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void updateView() {
		if(qu.getLastCall() != null){
			lastCall.setText(qu.getLastCall().toString());
		} else {
			lastCall.setText("---");
		}
		waiting.setText("Noch " + qu.getWaitingClients() + " Kunden im Wartebereich");
		calls.setText("");
		for(Call c : qu.getCurrentCalls()){
			calls.append(c.toString()+"\n");
		}
	}
}