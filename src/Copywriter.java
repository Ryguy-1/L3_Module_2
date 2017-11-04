import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Copywriter {
public static void main(String[] args) {
	File words = new File("src");
	for (int i = 0; i < words.listFiles().length; i++) {
		File child = words.listFiles()[i];
		if (child.isFile()) {
			try {
				FileWriter out = new FileWriter(child,true);
				out.write(System.lineSeparator()+"//Copyright 2017 Ryland");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
}

//Copyright 2017 Ryland