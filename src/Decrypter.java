import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Decrypter {
public static void main(String[] args) {
	String word = "";
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test2.txt"));
		
		String line = br.readLine();
		while(line != null){
			for (int i = line.length()-1; i >= 0; i--) {
				word+=line.charAt(i);
			}
			System.out.println(word);
			word = "";
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