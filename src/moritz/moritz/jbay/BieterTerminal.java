package moritz.jbay;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BieterTerminal extends JFrame {
	private Bieter bieter;
	private JLabel uhrzeit;
	private Auktionshaus ah;

	public BieterTerminal(Bieter bieter, Auktionshaus ah) {

		super(bieter.getFullName() + "'s Terminal");
		this.bieter = bieter;
		this.ah = ah;
		this.setLayout(new GridLayout(ah.getAuktionen().size() + 1, 1, 5, 5));
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ah.registerTerminal(this);
		update();

		this.setVisible(true);
	}

	public void update() {
		getContentPane().removeAll();
		// TODO Auto-generated method stub
		uhrzeit = new JLabel(Calendar.getInstance().getTime().toString());
		this.add(uhrzeit);

		for (final Auktion a : ah.getAuktionen()) {
			JPanel pnlAuktion = new JPanel();
			this.add(pnlAuktion);
			pnlAuktion.add(new JLabel(a.getWare().titel));
			pnlAuktion.add(new JLabel("" + a.getAktuellerPreis()));
			pnlAuktion.add(new JLabel(a.getFullName()));
			pnlAuktion.add(new JLabel(a.getEndeAuktion().getTime().toString()));
			JButton butgebot = new JButton("Gebot");
			pnlAuktion.add(butgebot);

			butgebot.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (Calendar.getInstance().after(a.getEndeAuktion())) {
						JOptionPane.showMessageDialog(null,
								"Zu spät! Hahahahahaha! Nerd!");
					}
					double abgegebenesGebot = 0.0;
					try {
						String blabla = JOptionPane

						.showInputDialog("Bitte geben SIe ein Gebot ein"
								+ "Vorschlag: "
								+ (a.getAktuellerPreis() + Auktion
										.getINCREMENT()));
						abgegebenesGebot = Double.parseDouble(blabla);
					} catch (NumberFormatException e1) {
						// nix bassiert
					}
					a.gebotAbgeben(new Gebot(abgegebenesGebot,
							BieterTerminal.this.bieter));
					if (a.gebotAbgeben(new Gebot(abgegebenesGebot,
							BieterTerminal.this.bieter))) {
						JOptionPane.showMessageDialog(null,
								"Sie sind Höchstbietender");

					} else {

						JOptionPane.showMessageDialog(null, "Zu wenig digga");
					}
					ah.updateTerminals();
				}
			});

		}
		this.setVisible(true);
	}
}
