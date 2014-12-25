package daniel.io_aufgaben;

import java.io.File;
import java.io.IOException;

public class MyDir {
	
	public static void main(String[] args) {
		
		File testdir = new File("myDir");
		testdir.mkdir();
		
		for(int i=0; i<3; i++){
			File temp = new File(testdir.getAbsolutePath(), "foo" + i);
			try {
				temp.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(temp.getAbsolutePath());
			temp.deleteOnExit();
		}
	}

}
