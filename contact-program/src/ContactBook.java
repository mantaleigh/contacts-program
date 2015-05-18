/********************************************************************
 *  ContactBook.java
 *
 *  Stores all Contact information into a HashTable and reads and writes
 *  to a file in order to save that information between program uses. 
 *
 *  @author Samantha Voigt
 *********************************************************************/

import java.util.*;
import java.io.*;
import java.lang.Integer;

public class ContactBook<T> {

 private Hashtable<String, Contact> searchTable;
 private final String FILENAME = "contactFile.txt";

 /******************************************************************
  * Creates an empty HashTable to hold Contact objects. 
  * Used on first run of the program.
  *****************************************************************/
 public ContactBook() {
  searchTable = new Hashtable<String, Contact>();
 }

 /******************************************************************
  * Creates an empty HashTable to hold Contact objects. 
  * Used on first run of the program.
  * 
  * @param srcFile: the file of Contact information to make a ContactBook from
  *****************************************************************/
 public ContactBook(String srcFile) {
  searchTable = new Hashtable<String, Contact>();
  try {
   Scanner scan = new Scanner(new File(srcFile));
   while(scan.hasNextLine()) { 
    String line = scan.nextLine(); // one line represents a single contact
    String[] fields = line.split("#"); // line is split up by # symbols
    Calendar dateContacted = Calendar.getInstance(); // sets up a calendar with default date/month/year (today)
    try {
     setCalFromString(fields[8], dateContacted); // if there is a date set, update the calendar using the helper method to the given date/month/year of last contact
    } catch (ArrayIndexOutOfBoundsException ex) { } // don't do anything -- keep the default date/month/year Calendar
    Contact newPerson = new Contact(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], dateContacted);
    searchTable.put(newPerson.getName(), newPerson); // add new contact to the hashtable
   }
   scan.close();
  } catch (IOException ex) { 
   System.out.println(ex);
  }
 }

 /******************************************************************
  * Changes a typical "mm/dd/yyyy" formatted String and saves that
  * information into a given Calendar object.
  * 
  * @param mmddyyyy: String representing a date formatted as "mm/dd/yyyy"
  * @param cal: Calendar object to store information from mmddyyyy into
  *****************************************************************/
 // helper method that takes a typical "mm/dd/yyyy" formatted String and saves that information into a given Calendar object
 public void setCalFromString(String mmddyyyy, Calendar cal) { 
  String[] dateArray = mmddyyyy.split("/");
  int month = Integer.parseInt(dateArray[0])-1;
  int date = Integer.parseInt(dateArray[1]);
  int year = Integer.parseInt(dateArray[2]);
  cal.set(year, month, date);
 }


 //**********************************************************************
 //*********************** SEARCHING METHODS ****************************
 //**********************************************************************

 /******************************************************************
  * Searches through the names of all Contacts in the HashTable 
  * looking for Contacts who have names that include the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 public LinkedList<Contact> searchByName(String criteria) { 
  LinkedList<Contact> results = new LinkedList<Contact>();
  Enumeration<Contact> vals = searchTable.elements(); 
  while (vals.hasMoreElements()) { // loop through each contact
   Contact elt = vals.nextElement();
   String name = elt.getName().toLowerCase().replace(" ", "");
   if (name.contains(criteria.toLowerCase().replace(" ", ""))) results.add(elt);
  }
  return results;
 }

 /******************************************************************
  * Searches through the meeting location of all Contacts in the HashTable 
  * looking for Contacts who have meeting locations that include the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 public LinkedList<Contact> searchByMeetingLoc(String criteria) { 
  LinkedList<Contact> results = new LinkedList<Contact>(); 
  Enumeration<Contact> vals = searchTable.elements();
  while (vals.hasMoreElements()) { 
   Contact elt = vals.nextElement(); 
   String meetingLoc = elt.getMeetingLoc().toLowerCase().replace(" ", "");
   if (meetingLoc.contains(criteria.toLowerCase().replace(" ", ""))) results.add(elt);
  }
  return results;
 }

 /******************************************************************
  * Searches through the locations of all Contacts in the HashTable 
  * looking for Contacts who have locations that include the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 public LinkedList<Contact> searchByLocation(String criteria) { 
  LinkedList<Contact> results = new LinkedList<Contact>(); 
  Enumeration<Contact> vals = searchTable.elements();
  while (vals.hasMoreElements()) { 
   Contact elt = vals.nextElement(); 
   String location = elt.getLocation().toLowerCase().replace(" ", "");
   if (location.contains(criteria.toLowerCase().replace(" ", ""))) results.add(elt);
  }
  return results;
 }

 /******************************************************************
  * Searches through the companies/schools of all Contacts in the HashTable 
  * looking for Contacts who have companies/schools that include the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 public LinkedList<Contact> searchByCompanyOrSchool(String criteria) { 
  LinkedList<Contact> results = new LinkedList<Contact>(); 
  Enumeration<Contact> vals = searchTable.elements();
  while (vals.hasMoreElements()) { 
   Contact elt = vals.nextElement(); 
   String companyOrSchool = elt.getCompanyOrSchool().toLowerCase().replace(" ", "");
   if (companyOrSchool.contains(criteria.toLowerCase().replace(" ", ""))) results.add(elt);
  }
  return results;
 }

 /******************************************************************
  * Searches through the phones of all Contacts in the HashTable 
  * looking for Contacts who have phones that include the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 // public LinkedList<Contact> searchByPhone(String criteria) { 
 //  LinkedList<Contact> results = new LinkedList<Contact>(); 
 //  Enumeration<Contact> vals = searchTable.elements();
 //  while (vals.hasMoreElements()) { 
 //   Contact elt = vals.nextElement(); 
 //   String phone = elt.getPhone().toLowerCase().replace(" ", "").replace("-", "");
 //   if (phone.contains(criteria.toLowerCase().replace(" ", "").replace("-", ""))) results.add(elt);
 //  }
 //  return results;
 // }

 /******************************************************************
  * Searches through the emails of all Contacts in the HashTable 
  * looking for Contacts who have emails that include the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 public LinkedList<Contact> searchByEmail(String criteria) { 
  LinkedList<Contact> results = new LinkedList<Contact>(); 
  Enumeration<Contact> vals = searchTable.elements();
  while (vals.hasMoreElements()) { 
   Contact elt = vals.nextElement(); 
   String email = elt.getEmail().toLowerCase().replace(" ", "");
   if (email.contains(criteria.toLowerCase().replace(" ", ""))) results.add(elt);
  }
  return results;
 }

 /******************************************************************
  * Searches through the other contact info of all Contacts in the HashTable 
  * looking for Contacts who have other contact info that includes the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 public LinkedList<Contact> searchByOtherContact(String criteria) { 
  LinkedList<Contact> results = new LinkedList<Contact>(); 
  Enumeration<Contact> vals = searchTable.elements();
  while (vals.hasMoreElements()) { 
   Contact elt = vals.nextElement(); 
   String otherContact = elt.getOtherContact().toLowerCase().replace(" ", "");
   if (otherContact.contains(criteria.toLowerCase().replace(" ", ""))) results.add(elt);
  }
  return results;
 }

 /******************************************************************
  * Searches through the notes of all Contacts in the HashTable 
  * looking for Contacts who have notes that include the criteria String.
  * Not case sensitive and spaces don't matter.
  * 
  * @param criteria: Specific string to search for
  * @return all Contacts that fit the search in a linkedlist
  *****************************************************************/
 public LinkedList<Contact> searchByNotes(String criteria) { 
  LinkedList<Contact> results = new LinkedList<Contact>(); 
  Enumeration<Contact> vals = searchTable.elements();
  while (vals.hasMoreElements()) { 
   Contact elt = vals.nextElement(); 
   String notes = elt.getNotes().toLowerCase().replace(" ", "");
   if (notes.contains(criteria.toLowerCase().replace(" ", ""))) results.add(elt);
  }
  return results;
 }

 //**************************************************************************************

 /******************************************************************
  * Gives the entire Contact object associated with a given name.
  * 
  * @param name: Specific string to search for
  * @return Contact that is associated with the given name
  *****************************************************************/
 public Contact getContactByName(String name) {
  return searchTable.get(name);
 }

 /******************************************************************
  * Gives all Contacts in the Hash Table
  * 
  * @return All Contacts in the HashTable in a linked list
  *****************************************************************/
 public LinkedList<Contact> getAllContacts() {
  LinkedList<Contact> names = new LinkedList<Contact>();
  Enumeration<Contact> values = searchTable.elements();
  while (values.hasMoreElements()) {
   names.add(values.nextElement());
  }
  return names;
 }

 /******************************************************************
  * Adds a new Contact into the ContactBook
  * 
  * @param person: A Contact object to add to the ContactBook
  *****************************************************************/
 public void addContact(Contact person) { 
  searchTable.put(person.getName(), person);
  writeSearchTableToFile();
  System.out.println(searchTable);
 }

 /******************************************************************
  * Edits an existing Contact by replacing all it's values.
  * 
  * @param oldName: the name of the Contact before it was edited
  * @param newName: the name of the Contact after it was edited
  * @param meetingLoc: the edited meeting location of the Contact
  * @param location: the edited location of the Contact
  * @param companyOrSchool: the edited companyOrSchool of the Contact
  * @param email: the edited email of the Contact
  * @param otherContact: the edited otherContact info of the Contact
  * @param notes: the edited notes of the Contact
  * @param lastContacted: the edited lastContacted String of the Contact
  *****************************************************************/
 public void editContact(String oldName, String newName, String meetingLoc, String location, String companyOrSchool, String email, String otherContact, String notes, String lastContacted) {
  if (!oldName.equals(newName)) { // if the user changed the contact's name
   searchTable.remove(oldName);  // have to delete and re-add to change the key
   Calendar cal = Calendar.getInstance(); 
   setCalFromString(lastContacted, cal);
   Contact newContact = new Contact(newName, meetingLoc, location, companyOrSchool, email, otherContact, notes, cal); 
   searchTable.put(newName, newContact); // update the hashtable with the new contact -- and new key
  } else { // if the user did not change the contact's name
   Contact c = searchTable.get(oldName); 
   c.setName(newName); //not necessary!
   c.setMeetingLoc(meetingLoc);
   c.setLocation(location); 
   c.setCompanyOrSchool(companyOrSchool);
   //c.setPhone(phone); 
   c.setEmail(email); 
   c.setOtherContact(otherContact);
   c.setNotes(notes); 
   Calendar cal = Calendar.getInstance();
   setCalFromString(lastContacted,cal);
   c.setLastContacted(cal);
  } 
  writeSearchTableToFile(); // save the changes
 }

 /******************************************************************
  * Helper method that writes the entire search table to a file.
  * Will either write a new file or overwrite the existing one.
  *****************************************************************/
 private void writeSearchTableToFile() { 
  try {
   PrintWriter writer = new PrintWriter(FILENAME);
   Enumeration<Contact> vals = searchTable.elements();
   while (vals.hasMoreElements()) { 
    Contact c = vals.nextElement();
    Calendar lastContacted = c.getLastContacted();
    String s = (c.getName() + "#" + c.getMeetingLoc() + "#" + c.getLocation() + 
      "#" + c.getCompanyOrSchool() + "#" + c.getEmail() + "#" + c.getOtherContact() + 
      "#" + c.getNotes() + "#" + (lastContacted.get(Calendar.MONTH)+1) + "/" + 
      lastContacted.get(Calendar.DATE) + "/" + lastContacted.get(Calendar.YEAR));
    writer.println(s);
   }
   writer.close();
  } catch (IOException ex) { 
   System.out.println(ex);
  }
 }

 /******************************************************************
  * Deletes a Contact from the ContactBook by the Contact's name
  * 
  * @param name: the full name associated with the Contact
  *****************************************************************/
 public void deleteContactByName(String name) { 
  searchTable.remove(name);
  writeSearchTableToFile();
 }

 /******************************************************************
  * Deletes all the Contacts from the ContactBook
  *****************************************************************/
 public void clearAllContacts() {
  searchTable.clear();
 }

 /******************************************************************
  * Creates a String representation of the ContactBook
  * 
  * @return String: a String representation of the ContactBook
  *****************************************************************/
 public String toString() { 
  return searchTable.toString();
 }
}
