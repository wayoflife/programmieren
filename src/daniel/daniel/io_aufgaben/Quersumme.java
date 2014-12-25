package daniel.io_aufgaben;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Quersumme {
	
	public static void main(String[] args) {
		Quersumme q = new Quersumme();
		File quersumme = new File("quersumme.txt");
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(quersumme)) ;
			pw.println(q.getQuersumme());
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		System.out.println(q.getQuersumme());
	}
	
	public double getQuersumme(){
		Scanner s = new Scanner(System.in);
		String zahlen = s.nextLine();
		String[] allezahlen = zahlen.split(" ");
		int summe = 0;
		for(String t : allezahlen) summe += new Integer(t);
		return (double) summe/allezahlen.length;
	}
}
