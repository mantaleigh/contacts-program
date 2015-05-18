import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by amitsuzawa on 5/7/15.
 */

public class ContactBookGUI {

 private ContactBook<Contact> program;

 public ContactBookGUI() {
  
  // creates and shows a Frame
  JFrame frame = new JFrame("Contact Manager");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  // get the screen size as a java dimension
  // code from http://alvinalexander.com/java/jframe-size-example-screen
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  // get 2/3 of the height, and 2/3 of the width
  int height = screenSize.height * 2 / 3;
  int width = screenSize.width * 2 / 3;

  // set the jframe height and width
  frame.setPreferredSize(new Dimension(width, height));

  String fileName = "contactFile.txt";
  // creates an instance of a ContactBook

  program = new ContactBook<Contact>();
  if (new File(fileName).isFile()) program = new ContactBook<Contact>(fileName); // if the file does exist, read in from it

  JPanel mainPanel = new JPanel();

  BufferedImage logoImage;
  System.out.println("Working Directory = " + System.getProperty("user.dir"));
  try {
   logoImage = ImageIO.read(new File("ContactManager.png"));
   JLabel picLabel = new JLabel(new ImageIcon(logoImage));
   mainPanel.add(picLabel);
  } catch (IOException e) {
   e.printStackTrace();
  }

  mainPanel.add(new ContactOverview(program));

  frame.getContentPane().add(mainPanel);
  frame.pack();
  frame.setVisible(true);
 }
}
