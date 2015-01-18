package laura.event;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;




public class BMI extends JFrame{

	private JTextField txtgewicht, txtgroesse, txtbmi, txtnormgewicht;
	private JButton btnberechne;
	private JLabel lblgewicht, lblgroesse, lblbmi;
	private JRadioButton maennl, weibl;
	
	public BMI(){
		super("BMI-Rechner");
		this.setSize(400,300);
		this.setLayout(new GridLayout(6, 1, 5, 5));
		this.setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		
		JPanel pnlgewicht = new JPanel();
		
		lblgewicht = new JLabel("Gewicht in kg: ");
		txtgewicht = new JTextField(20);
		
		JPanel pnlgroesse = new JPanel();
		
		lblgroesse = new JLabel("Größe in m: ");
		txtgroesse = new JTextField(20);
		
		JPanel pnlgeschlecht = new JPanel();
		
		maennl = new JRadioButton("männlich");
		weibl = new JRadioButton("weiblich");
		weibl.setSelected(true);
		
		JPanel pnlberechne = new JPanel();
		btnberechne = new JButton("Berechnen");
		
		JPanel pnlbmi = new JPanel();
		
		lblbmi = new JLabel("BMI: ");
		txtbmi = new JTextField(20);
		
		JPanel pnlnormgewicht = new JPanel();
		
		txtnormgewicht = new JTextField(30);
		
		this.add(pnlgewicht);
		pnlgewicht.add(lblgewicht);
		pnlgewicht.add(txtgewicht);
		
		this.add(pnlgroesse);
		pnlgroesse.add(lblgroesse);
		pnlgroesse.add(txtgroesse);
		
		this.add (pnlgeschlecht);
		pnlgeschlecht.add(maennl);
		pnlgeschlecht.add(weibl);
		
		ButtonGroup buttonGruppe = new ButtonGroup();
		buttonGruppe.add(weibl);
		buttonGruppe.add(maennl);
		
		this.add(pnlberechne);
		pnlberechne.add(btnberechne);
		
		this.add(pnlbmi);
		pnlbmi.add(lblbmi);
		pnlbmi.add(txtbmi);
		
		this.add(pnlnormgewicht);
		pnlnormgewicht.add(txtnormgewicht);
		
		btnberechne.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				double gewicht = Double.parseDouble (txtgewicht.getText());
				double groesse = Double.parseDouble (txtgroesse.getText());
				double bmi = gewicht/(groesse*groesse);
				txtbmi.setText(""+ bmi);
				
				if(maennl.isSelected()){
					if (bmi<20)txtnormgewicht.setText("Untergewicht");
					if (bmi>=20 && bmi<=25)txtnormgewicht.setText("Normalgewicht");
					if (bmi>=25 && bmi<=30)txtnormgewicht.setText("Übergewicht");
					if (bmi>=30 && bmi<=40)txtnormgewicht.setText("Adipositas");
					if (bmi>40)txtnormgewicht.setText("massive Adipositas");
				}
				else {
					if (bmi<19)txtnormgewicht.setText("Untergewicht");
					if (bmi>=19 && bmi<=24)txtnormgewicht.setText("Normalgewicht");
					if (bmi>=24 && bmi<=30)txtnormgewicht.setText("Übergewicht");
					if (bmi>=30 && bmi<=40)txtnormgewicht.setText("Adipositas");
					if (bmi>40)txtnormgewicht.setText("massive Adipositas");
				}
				
			}
		});
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new BMI();

	}

}
