import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

public class ContactBookGUI {
	public ContactBookGUI() {
		
		// creates and shows a Frame
		JFrame frame = new JFrame("Contact Book");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// get the screen size as a java dimension
		// code from http://alvinalexander.com/java/jframe-size-example-screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// get 2/3 of the height, and 2/3 of the width
		int height = screenSize.height * 2 / 3;
		int width = screenSize.width * 2 / 3;

		// set the jframe height and width
		frame.setPreferredSize(new Dimension(width, height));

		// creates an instance of a ContactBook
		ContactBook<Contact> program = new ContactBook<Contact>("testFile.txt"); // test file is temp
		// in the future, this should be a conditional that checks if a file of the correct name exists. 
		// if the file does exist, create a ContactBook out of that file. If the file does not exist, create an empty one.

		JPanel mainPanel = new JPanel();

		mainPanel.add(new ContactOverview(program));

		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		ContactBookGUI test = new ContactBookGUI();
	}
}
