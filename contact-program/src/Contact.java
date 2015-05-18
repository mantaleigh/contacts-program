/********************************************************************
 *  Contact.java
 *
 *	Stores all information associated with a Contact. Mostly 
 *  consists entirely of getters and setters. Serves as a template
 *  for new Contacts.
 *
 *  @author Samantha Voigt
 *********************************************************************/

import java.util.Calendar;


public class Contact {

	private String name, meetingLoc, location, companyOrSchool, email, otherContact, notes; 
	private Calendar lastContacted;

	/******************************************************************
	 * Creates an instance of Contact using all possible fields. 
	 * 
	 * @param name: the name of the Contact
	 * @param meetingLoc: the meeting location of the Contact
	 * @param location: the location of the Contact
	 * @param companyOrSchool: the company or school of the Contact
	 * @param email: the email of the Contact
	 * @param otherContact: the other contact information of the Contact
	 * @param notes: the notes of the Contact
	 * @param lastContacted: the Calendar object that represents the last time the Contact was contacted
	 *****************************************************************/
	// first constructor that takes every possible instance variable in as a parameter
	public Contact (String name, String meetingLoc, String location, String companyOrSchool, String email, String otherContact, String notes, Calendar lastContacted) { 
		this.name = name; 
		this.meetingLoc = meetingLoc; 
		this.location = location; 
		this.companyOrSchool = companyOrSchool; 
		//this.phone = phone;
		this.email = email; 
		this.otherContact = otherContact; 
		this.notes = notes;
		this.lastContacted = lastContacted;
	}

	/********************************************************************
	 *	Second constructor that only takes the name of the Contact. 
	 *  The rest of the contact's properties can be set using the provided setters. 
	 *  LastContacted is initially set to the day when the Contact is created. 
	 *  All other properties are initially set to blank strings. 
	 *
	 *  @param newName: name of the Contact
	 *********************************************************************/
	// second constructor that only takes the name of the contact. The rest of the contact's properties can be set using the provided setters
	public Contact (String newName) { 
		name = newName;
		meetingLoc = location = companyOrSchool = email = otherContact = notes = ""; // set all other instance vars to be empty
		lastContacted = Calendar.getInstance(); // set the date last contacted to be the day that the contact is made (now)
		//phone = "0000000000"; // default phone number is 000-000-0000
	}

	// ---------- GETTERS -----------
	
	
	/******************************************************************
	 * Gets the name of the Contact
	 * 
	 * @return name: the name of the Contact
	 *****************************************************************/
	public String getName() { 
		return name;
	}

	/******************************************************************
	 * Gets the meeting location of the Contact
	 * 
	 * @return meetingLoc: the meeting location of the Contact
	 *****************************************************************/
	public String getMeetingLoc() { 
		return meetingLoc;
	}

	/******************************************************************
	 * Gets the location of the Contact
	 * 
	 * @return location: the location of the Contact
	 *****************************************************************/
	public String getLocation() { 
		return location;
	}

	
	/******************************************************************
	 * Gets the company or school of the Contact
	 * 
	 * @return companyOrSchool: the company or school of the Contact
	 *****************************************************************/
	public String getCompanyOrSchool() { 
		return companyOrSchool;
	}

	/******************************************************************
	 * Gets the phone of the Contact
	 * 
	 * @return phone: the phone of the Contact
	 *****************************************************************/
	//	public String getPhone() { 
	//		return phone;
	//	}

	/******************************************************************
	 * Gets the email of the Contact
	 * 
	 * @return email: the email of the Contact
	 *****************************************************************/
	public String getEmail() { 
		return email;
	}
	
	/******************************************************************
	 * Gets the other contact info of the Contact
	 * 
	 * @return otherContact: the other contact info of the Contact
	 *****************************************************************/
	public String getOtherContact() { 
		return otherContact;
	}

	/******************************************************************
	 * Gets the notes of the Contact
	 * 
	 * @return notes: the notes of the Contact
	 *****************************************************************/
	public String getNotes() { 
		return notes;
	}

	
	/******************************************************************
	 * Gets the last contacted date of the Contact
	 * 
	 * @return lastContacted: the last contacted date of the Contact
	 *****************************************************************/
	// can use this to get the calendar object to compare to another using compareTo
	public Calendar getLastContacted() { 
		return lastContacted;
	}

	// ---------- SETTERS -----------

	/******************************************************************
	 * Sets the name of the Contact
	 * 
	 * @param newName: the new name of the Contact
	 *****************************************************************/
	public void setName(String newName) { 
		name = newName;
	}

	/******************************************************************
	 * Sets the meeting location of the Contact
	 * 
	 * @param newMeetingLoc: the new meeting location of the Contact
	 *****************************************************************/
	public void setMeetingLoc(String newMeetingLoc) { 
		meetingLoc = newMeetingLoc;
	}

	/******************************************************************
	 * Sets the location of the Contact
	 * 
	 * @param newLocation: the new location of the Contact
	 *****************************************************************/
	public void setLocation(String newLocation) { 
		location = newLocation;
	}

	/******************************************************************
	 * Sets the company or school of the Contact
	 * 
	 * @param newCompanyOrSchool: the new company or school of the Contact
	 *****************************************************************/
	public void setCompanyOrSchool(String newCompanyOrSchool) { 
		companyOrSchool = newCompanyOrSchool;
	}

	/******************************************************************
	 * Sets the phone of the Contact
	 * 
	 * @param newPhone: the new phone of the Contact
	 *****************************************************************/
	//	public void setPhone(String newPhone) { 
	//		phone = newPhone;
	//	}

	/******************************************************************
	 * Sets the email of the Contact
	 * 
	 * @param newEmail: the new email of the Contact
	 *****************************************************************/
	public void setEmail(String newEmail) { 
		email = newEmail;
	}

	/******************************************************************
	 * Sets the other contact info of the Contact
	 * 
	 * @param newOtherContact: the new other contact info of the Contact
	 *****************************************************************/
	public void setOtherContact(String newOtherContact) { 
		otherContact = newOtherContact;
	}

	/******************************************************************
	 * Sets the notes of the Contact
	 * 
	 * @param newNotes: the new notes of the Contact
	 *****************************************************************/
	public void setNotes(String newNotes) { 
		notes = newNotes;
	}

	/******************************************************************
	 * Sets the last contacted date of the Contact
	 * 
	 * @param newLastContacted: the new last contacted date of the Contact
	 *****************************************************************/
	public void setLastContacted(Calendar newLastContacted) { 
		lastContacted = newLastContacted;
	}

	/******************************************************************
	 * Provides a string representation of the Contact
	 * 
	 * @return String: a string representation of the Contact
	 *****************************************************************/
	public String toString() { 
		String s = "******* CONTACT *******\nName: " + getName() + "\nMeeting Location: " + getMeetingLoc() 
				+ "\nLocation: " + getLocation() + "\nCompany or School: " + getCompanyOrSchool() + "\nEmail: " 
				+ getEmail() + "\nOther Contact Info: " + getOtherContact() + "\nNotes: " + getNotes() + "\nLast Contacted: "
				+ (lastContacted.get(Calendar.MONTH)+1) + "/" + lastContacted.get(Calendar.DATE) + "/" + lastContacted.get(Calendar.YEAR);	
		return s;

	}


}
