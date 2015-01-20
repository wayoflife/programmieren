package moritz.myshop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class KundenTerminal extends JFrame {
	private JLabel lblvorname, lblnachname;
	private JTextField txtvorname, txtnachname;
	private JButton btbestellen, btausgeliefert;
	private JToggleButton btprodukt;

	public KundenTerminal(final List<Produkt> produkte) {
		// TODO Auto-generated constructor stub
		super("Kunden-Terminal");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setMinimumSize(new Dimension(400, 300));

		JPanel pnltop = new JPanel(new GridLayout(2, 1));
		this.add(pnltop, BorderLayout.NORTH);
		lblvorname = new JLabel("Vorname des Kunden");
		txtvorname = new JTextField(10);
		pnltop.add(lblvorname);
		pnltop.add(txtvorname);

		lblnachname = new JLabel("Nachname des Kunden");
		txtnachname = new JTextField(10);
		pnltop.add(lblnachname);
		pnltop.add(txtnachname);

		JPanel pnlmid = new JPanel();

		JPanel pnlbottom = new JPanel(new BorderLayout());
		this.add(pnlbottom, BorderLayout.SOUTH);
		btbestellen = new JButton("Bestellen");
		pnlbottom.add(btbestellen, BorderLayout.NORTH);
		btausgeliefert = new JButton("Bereits ausgelieferte Produkte");
		pnlbottom.add(btausgeliefert, BorderLayout.SOUTH);

		for (final Produkt p : produkte) {
			JPanel pnltemp = new JPanel();
			btprodukt = new JToggleButton(p.getName());
			btprodukt.setBackground(Color.WHITE);
			pnltemp.add(btprodukt);
			pnlmid.add(pnltemp);
			KundenTerminal.this.add(pnlmid, BorderLayout.CENTER);

			btprodukt.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (btprodukt.isSelected()) {
						btprodukt.setBackground(Color.RED);

					} else {
						btprodukt.setBackground(Color.WHITE);

					}
				}
			});

			btbestellen.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (txtvorname.getText().isEmpty()
							|| txtnachname.getText().isEmpty()) {
						JOptionPane
								.showMessageDialog(null,
										"Vor- und Nachname des Kunden müssen angegeben werden.");
					} else {
						Kunde kunde = new Kunde(txtvorname.getText(),
								txtnachname.getText());
						if (btprodukt.isSelected()) {
							Bestellung best = new Bestellung(kunde, p);
						
							btprodukt.setSelected(false);

						}
					}

				}
			});
		}

		this.setVisible(true);
	}

}
