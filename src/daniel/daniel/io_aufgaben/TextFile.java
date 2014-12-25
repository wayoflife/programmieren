package daniel.io_aufgaben;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFile {
	
	private File text;
	private String[] textinfile;
	
	public TextFile(File f) {
		this.text = f;
		read();
	}
	
	public TextFile(String pathname) {
		this(new File(pathname));
	}
	
	public void read(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(text));
			StringBuffer sb = new StringBuffer();
			while(br.ready()) sb.append(br.readLine()+"$;");
			textinfile = sb.toString().split("$;");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(){
		try {
			PrintWriter pw = new PrintWriter(text);
			for(String s : textinfile) pw.println(s);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int availableLines(){
		return textinfile.length;
	}
	
	public String[] getLines(){
		return textinfile;
	}
	
	/**
	 * 
	 * @param i beginnt bei 1
	 * @return
	 * @throws LineNumberOutOfBoundsException 
	 */
	public String getLine(int i) throws LineNumberOutOfBoundsException{
		if(i < 1 || i > textinfile.length) {
			throw new LineNumberOutOfBoundsException();
		} else {
			return textinfile[i-1];
		}
	}

	/**
	 * 
	 * @param i beginnt bei 1
	 * @param s
	 * @throws LineNumberOutOfBoundsException 
	 */
	public void setLine(int i, String s) throws LineNumberOutOfBoundsException{
		if(i < 1 || i > textinfile.length) {
			throw new LineNumberOutOfBoundsException();
		} else {
			textinfile[i-1] = s;
		}
	}
	
	public void replaceAll(String regexp, String ersatz){
		for(int i=0; i<textinfile.length; i++){
			textinfile[i].replaceAll(regexp, ersatz);
		}
	}
	
	public void close(){
		
	}
}
