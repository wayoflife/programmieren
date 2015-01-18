package laura.zumkopieren;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import laura.event.ZahlenRatespiel;

public class DateiLesenSchreiben {
	
	private void lesen(){
		String eingelesen = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader("dateiname.txt"));
			if(br.ready()){
				eingelesen = br.readLine();
			}
			br.close();
			JOptionPane.showMessageDialog(null, eingelesen);
		} catch(IOException e){
			JOptionPane.showMessageDialog(null, "Datei konnte nicht gelesen werden.");
		}
	}
	
	private void schreiben(String text){
		try{
			FileWriter fw = new FileWriter("dateiname.txt");
			fw.write(text);
			fw.close();
		} catch(IOException e){
			JOptionPane.showMessageDialog(null, "Datei konnte nicht gelesen werden.");
		}
	}
}
