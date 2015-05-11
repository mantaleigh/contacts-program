import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTab<T> extends JPanel{
	
	private ContactBook<T> cb;
	private JButton addPerson;
	private TextField name, whereYouMet, location, companySchool, email, otherContact, phone, lastContacted;
	private TextArea notes;
	
	public AddTab(ContactBook<T> cb) {
		this.cb = cb;
		setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));
		add(new JLabel("Add a new contact..."));
		name = new TextField("Name");
		add(name);
		whereYouMet = new TextField("Where you met");
		add(whereYouMet);
		location = new TextField("Location");
		add(location);
		companySchool = new TextField("Company/School");
		add(companySchool);
		email = new TextField("Email address");
		add(email);
		otherContact = new TextField("Other");
		add(otherContact);
		phone = new TextField("Phone number");
		add(phone);
		lastContacted = new TextField("Last contacted");
		add(lastContacted);
		notes = new TextArea("Notes");
		add(notes);
		addPerson = new JButton("Add to database");
		add(addPerson);
	}
	  private class ButtonListener implements ActionListener {
		    public void actionPerformed(ActionEvent event){
		      if (event.getSource() == addPerson){
		    	  //or add instance of?
		    	  Contact addedContact = new Contact(name.getSelectedText());
		    	  addedContact.setCompanyOrSchool(companySchool.getSelectedText());
		    	  addedContact.setEmail(email.getSelectedText());
		    	  addedContact.setLastContacted(null);
		    	  addedContact.setLocation(location.getSelectedText());
		    	  addedContact.setMeetingLoc(whereYouMet.getSelectedText());
		    	  //addedContact.setOtherContact(phone.getSelectedText();
		    	  addedContact.setNotes(notes.getSelectedText());   
		    	  
		      }
		    }
		  }
}
