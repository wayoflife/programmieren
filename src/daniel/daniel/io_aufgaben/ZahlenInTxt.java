package daniel.io_aufgaben;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZahlenInTxt {
	public static void main(String[] args) {
		File zahlen = new File("zahlen.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(zahlen));
			int i=0;
			int sum = 0;
			while(br.ready()){
				String s = br.readLine();
				if(i>1 && i < 6) {
					System.out.println(s);
					sum += Integer.parseInt(s);
				}
				i++;
			}
			System.out.println("die summe ist: " + sum);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
