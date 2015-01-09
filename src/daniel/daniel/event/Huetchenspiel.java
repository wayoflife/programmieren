package daniel.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Huetchenspiel extends JFrame{
	
	private JLabel lblname;
	private JTextField txtname, txtstatus;
	private JButton btn1, btn2, btn3, btnstatistik, btnexit;
	
	private int versuche;
	
	public Huetchenspiel() {
		super("Das Huetchenspiel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 1, 5, 5));
		
		init();
		startgame();
		
		this.pack();
		this.setVisible(true);
	}
	
	private void startgame() {
		// setzten der variablen
		versuche = 0;
		if(txtstatus.getText().isEmpty()) txtstatus.setText("Bitte klick auf ein Huetchen");
	}
	
	private void evaluiereButton(int tipp){
		versuche++;
		int zahl = ((int) (Math.random()*3)) + 1;
		if(zahl == tipp){
			//gewonnen
			txtstatus.setText("Versuch "+versuche+": Gewonnen, die Kugel war unter H�tchen "+zahl);
			//eintrag in ergebnisfile
			try {
				PrintWriter pw = new PrintWriter(new FileWriter("huetchenspiel.txt", true));
				pw.println(txtname.getText()+";"+versuche);
				pw.close();
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(Huetchenspiel.this, "Ergebnisdatei konnte nicht gelesen werden.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			startgame();
		} else {
			//weiter
			txtstatus.setText("Versuch "+versuche+": Daneben, die Kugel war unter H�tchen "+zahl);
		}
		
	}

	private void init(){
		
		JPanel pnlname = new JPanel();
		this.add(pnlname);
		lblname = new JLabel("Spielername");
		pnlname.add(lblname);
		
		txtname = new JTextField(20);
		pnlname.add(txtname);
		
		JPanel pnlhuetchen = new JPanel();
		this.add(pnlhuetchen);
		btn1 = new JButton("Huetchen 1");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				evaluiereButton(1);
			}
		});
		pnlhuetchen.add(btn1);
		btn2 = new JButton("Huetchen 2");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				evaluiereButton(2);
			}
		});
		pnlhuetchen.add(btn2);
		btn3 = new JButton("Huetchen 3");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				evaluiereButton(3);
			}
		});
		pnlhuetchen.add(btn3);
		
		JPanel pnlbuttons = new JPanel();
		this.add(pnlbuttons);
		btnstatistik = new JButton("Statistik");
		btnstatistik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String bla = new String(Files.readAllBytes(Paths.get("huetchenspiel.txt")));
					StringTokenizer st = new StringTokenizer(bla);
					double average = 0;
					while(st.hasMoreTokens()){
						st.nextToken();
						average += 0;
						//keine lust mehr 
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		pnlbuttons.add(btnstatistik);
		btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Huetchenspiel.this.dispose();
			}
		});
		pnlbuttons.add(btnexit);
		
		JPanel status = new JPanel();
		this.add(status);
		txtstatus = new JTextField(30);
		txtstatus.setEditable(false);
		status.add(txtstatus);
	}

	public static void main(String[] args) {
		new Huetchenspiel();
	}
}