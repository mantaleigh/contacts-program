/* Samantha Voigt and Aline Mitsuzawa
 * 
 * 
 */

import java.util.*;
import java.io.*;
import java.lang.Integer;

public class ContactBook<T> {
	
	private Hashtable<String, Contact> searchTable;
	
	//empty constructor used first time using the program
	public ContactBook() {
		searchTable = new Hashtable<String, Contact>(); // create a blank hashtable
	}
	
	/* constructor that takes in a file of information
	 * makes contact objects
	 * should be called once the program is initialized to read previous user data
	 */
	public ContactBook(String srcFile) {
		try {
			Scanner scan = new Scanner(new File(srcFile));
			while(scan.hasNextLine()) { 
				String line = scan.nextLine(); // one line represents a single contact
				String[] fields = line.split("#"); // line is split up by # symbols
				
				// get the date in the proper Calendar format ----
				String[] listOfMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
				Calendar dateContacted = Calendar.getInstance();
				String[] dateArray = fields[7].split(" ");
				String monthStr = dateArray[0];
				int monthInt = 0;
				for (int i = 0; i < listOfMonths.length; i++) // find the int that the String month corresponds to
					if (monthStr.equals(listOfMonths[i])) monthInt = i; 
				int date = Integer.parseInt(dateArray[1].replace(",", "")); // get rid of the comma and change to int
				int year = Integer.parseInt(dateArray[2]);
				dateContacted.set(year, monthInt, date);
				System.out.println("year: " + dateContacted.get(Calendar.YEAR));
				System.out.println("month: " + dateContacted.get(Calendar.MONTH)); 
				System.out.println("date: " + dateContacted.get(Calendar.DATE));
				Contact newPerson = new Contact(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], dateContacted);
				System.out.println(newPerson); // testing
				
//				for (int i = 0; i < fields.length; i++)
//					System.out.println(fields[i]);
				
			}
			scan.close();
		} catch (IOException ex) { 
			System.out.println(ex);
		}
	}
	
	public LinkedList<T> contactBookSearch(String category,
			String specificCriteria) {
		return null;
	}

	public LinkedList<T> getAllNames() {
		return null;
	}
	
	public static void main (String[] args) { 
		ContactBook test = new ContactBook("testFile.txt");
	}
}
