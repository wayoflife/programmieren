package daniel.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BMIRechner extends JFrame {
	
	private JLabel lblgewicht, lblgroesse, lblbmi;
	private JButton btnrechne;
	private JTextField txtgewicht, txtgroesse, txtbmi, txtklassifikation;
	private JRadioButton rbtmann, rbtfrau;
	
	public BMIRechner() {
		super("BMI Rechner");
		this.setSize(400, 300);
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlgewicht = new JPanel();
		this.add(pnlgewicht);
		
		lblgewicht = new JLabel("Gewicht: ");
		pnlgewicht.add(lblgewicht);
		txtgewicht = new JTextField(20);
		pnlgewicht.add(txtgewicht);
		
		JPanel pnlgroesse = new JPanel();
		this.add(pnlgroesse);
		
		lblgroesse = new JLabel("Groesse: ");
		pnlgroesse.add(lblgroesse);
		txtgroesse = new JTextField(20);
		pnlgroesse.add(txtgroesse);
		
		JPanel pnlradiobuttons = new JPanel();
		this.add(pnlradiobuttons);
		
		rbtmann = new JRadioButton("m�nnlich");
		rbtmann.setSelected(true);
		pnlradiobuttons.add(rbtmann);
		rbtfrau = new JRadioButton("weiblich");
		pnlradiobuttons.add(rbtfrau);
		
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(rbtmann);
		buttongroup.add(rbtfrau);
		
		JPanel pnlrechne = new JPanel();
		this.add(pnlrechne);
		btnrechne = new JButton("berechne");
		pnlrechne.add(btnrechne);
		btnrechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double gewicht = Double.parseDouble(txtgewicht.getText());
					double groesse = Double.parseDouble(txtgroesse.getText());
					double bmi = gewicht / (groesse * groesse);
					txtbmi.setText("" + bmi);
					
					if(rbtmann.isSelected()){
						if(bmi < 20) txtklassifikation.setText("Untergewicht");
						if(bmi >=20 && bmi < 25) txtklassifikation.setText("Normalgewicht");
						if(bmi >=25 && bmi < 30) txtklassifikation.setText("�bergewicht");
						if(bmi >=30 && bmi < 40) txtklassifikation.setText("Adipositas");
						if(bmi > 40) txtklassifikation.setText("massive Adipositas");
					} else {
						if(bmi < 19) txtklassifikation.setText("Untergewicht");
						if(bmi >=19 && bmi < 24) txtklassifikation.setText("Normalgewicht");
						if(bmi >=24 && bmi < 30) txtklassifikation.setText("�bergewicht");
						if(bmi >=30 && bmi < 40) txtklassifikation.setText("Adipositas");
						if(bmi > 40) txtklassifikation.setText("massive Adipositas");
					}
				} catch (NumberFormatException nfe) {
					txtbmi.setText("");
					txtklassifikation.setText("");
					JOptionPane.showMessageDialog(BMIRechner.this, "Ung�ltige Eingabe, bitte Gr��e und Gewicht in Kommazahlen angeben");
				}
			}
		});
		
		JPanel pnlbmi = new JPanel();
		this.add(pnlbmi);
		
		lblbmi = new JLabel("BMI: ");
		pnlbmi.add(lblbmi);
		txtbmi = new JTextField(20);
		pnlbmi.add(txtbmi);
		
		JPanel pnlklassifikation = new JPanel();
		this.add(pnlklassifikation);
		txtklassifikation = new JTextField(30);
		pnlklassifikation.add(txtklassifikation);
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BMIRechner();
	}
}
