import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
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
	HashMap<Integer, String> list = new HashMap<Integer,String>();
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
		System.out.println("ADD");
		String place = JOptionPane.showInputDialog("What place on the list is this: ");
		int number = Integer.parseInt(place);
		if(list.containsKey(number)) {
			JOptionPane.showMessageDialog(null, "This is already: "+list.get(number));
		}else {
			String word = JOptionPane.showInputDialog("Add: ");
		list.put(number, word);
		}	
	}else if(e.getSource()==remove) {
		String number = JOptionPane.showInputDialog("Which number would you like to remove: ");
		int number1 = Integer.parseInt(number);
		if(list.containsKey(number1)) {
			list.remove(number1);
		}else {
			JOptionPane.showMessageDialog(null, "There is no task under the number "+number1);
		}
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
		
		
	}
	
}
}