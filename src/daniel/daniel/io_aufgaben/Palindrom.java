package daniel.io_aufgaben;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Palindrom {
	
	private String s;
	
	public static void main(String[] args) {
		Palindrom p = new Palindrom("otto");
		File palindrom = new File("palindrom.txt");
		try {
			PrintWriter pw = new PrintWriter(palindrom);
			pw.println(p.getInverse());
			pw.println(p.isPalindrom());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(palindrom));
			while(br.ready()) System.out.println(br.readLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Palindrom(String palindrom) {
		this.s = palindrom;
	}
	
	public String getInverse(){
		char[] chars = s.toCharArray();
		StringBuffer inverse = new StringBuffer();
		for(int i=chars.length-1; i>=0; i--){
			inverse.append(chars[i]);
		}
		return inverse.toString();
	}
	
	public boolean isPalindrom(){
		if(s.equals(getInverse())) return true;
		return false;				
	}
}
