package daniel.jbay;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BieterTerminal extends JFrame {
	
	private JLabel uhrzeit;
	private Auktionshaus ah;
	private Bieter bieter;

	public BieterTerminal(Bieter bieter, Auktionshaus ah) {
		super(bieter.getFullName() + "'s Terminal");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.ah = ah;
		this.bieter = bieter;
		ah.register(this);
		update();
		
		new Thread(){
			public void run() {
				try {
					while(true){
						uhrzeit.setText(Calendar.getInstance().getTime().toString());
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		
	}
	
	public void update(){
		getContentPane().removeAll();
		List<Auktion> auktionen = ah.getAuktionen();
		int rows = auktionen.size();
		this.setLayout(new GridLayout(rows+1, 1, 5, 5));
		uhrzeit = new JLabel();
		this.add(uhrzeit);
		
		for (final Auktion ak : auktionen) {
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(1, 5, 5, 5));
			this.add(p);
			
			p.add(new JLabel(ak.getTitel()));
			p.add(new JLabel(ak.getPreis()+""));
			p.add(new JLabel(ak.getFullName()));
			p.add(new JLabel(ak.getEnde().getTime().toString()));
			JButton button = new JButton("Gebot");
			p.add(button);
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(ak.beendet()){
						JOptionPane.showMessageDialog(null, "Die Auktion ist leider schon vorbei...");
					} else {
						String input = JOptionPane.showInputDialog("Bitte neues Gebot eingeben.\n Mindestens " 
										+ ak.getMindestgebot() + " Euro");
						double gebot = 0.0;
						try {
							gebot = Double.parseDouble(input);
						} catch (NumberFormatException | NullPointerException e3) {
							//gebot �ndert sich nicht
						}
						
						if(ak.gebotAbgeben(new Gebot(gebot, bieter))){
							JOptionPane.showMessageDialog(null, "Sie sind H�chstbietender!");
						} else {
							JOptionPane.showMessageDialog(null, "Gebot zu gering!");
						}
						ah.updateTerminals();
					}
				}
			});
		}
		
		this.pack();
		this.setVisible(true);
	}
}
