import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class To_DoListTracker implements ActionListener{
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	ArrayList<String> list = new ArrayList<String>();
public static void main(String[] args) {
	To_DoListTracker tracker = new To_DoListTracker();
	
	tracker.setup();
	
	
}

void setup() {
	
	JFrame frame = new JFrame();
	frame.setVisible(true);
	JPanel panel = new JPanel();
	frame.add(panel);
	add.setVisible(true);
	add.addActionListener(this);
	add.setText("Add");
	panel.add(add);
	remove.setVisible(true);
	remove.addActionListener(this);
	remove.setText("Remove");
	panel.add(remove);
	save.setVisible(true);
	save.addActionListener(this);
	save.setText("Save");
	panel.add(save);
	load.setVisible(true);
	load.addActionListener(this);
	load.setText("Load");
	panel.add(load);
	frame.pack();
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==add) {
		System.out.println("add");
		String word = JOptionPane.showInputDialog("Add: ");
		list.add(word);
	}else if(e.getSource()==remove) {
		String number = JOptionPane.showInputDialog("Which number would you like to remove: ");
		int number1 = Integer.parseInt(number);
		number1-=1;
		list.remove(number1);
	}else if(e.getSource()==save) {
		String sentence = "";
		for (int i = 0; i < list.size(); i++) {
			sentence+=list.get(i);
			sentence+=System.lineSeparator();
		}
		System.out.println(sentence);
		FileWriter fw;
		try {
			fw = new FileWriter("src/intro_to_file_io/test2.txt");
			fw.write(sentence);
			fw.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		
	}else if(e.getSource()==load){
		String word = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test2.txt"));
			
			String line = br.readLine();
			list = new ArrayList<String>();
				while(line != null){
					list.add(line);
					word += line;
					word+=System.lineSeparator();
					line = br.readLine();
				}
				JOptionPane.showMessageDialog(null, word);
				
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	
}
}