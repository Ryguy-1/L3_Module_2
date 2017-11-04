import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Encrypter {
public static void main(String[] args) {
	String word = "";
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test.txt"));
		
		String line = br.readLine();
		while(line != null){
			System.out.println(line);
			try {
				FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt", true);)
				*/
				for (int i = line.length()-1; i >= 0; i--) {
					word+=line.charAt(i);
				}
				fw.write(word+System.lineSeparator());
				
				word = "";
				
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			line = br.readLine();
			
		}
		
		br.close();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}

//Copyright 2017 Ryland
//Copyright 2017 Ryland