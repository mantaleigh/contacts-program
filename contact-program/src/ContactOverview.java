import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

/**
 * Created by amitsuzawa on 5/14/15.
 * ContactOverview.java populates the main GUI frame with the overall functionality of the program.
 */
public class ContactOverview extends JPanel{
    /**
     * Keeps an instance of the ContactBook generated earlier and passed as a parameter
     */
    private ContactBook<Contact> cb;
    private JLabel searchBy, searchResult;
    private JComboBox<String> searchCriteria, contactSearch;
    protected DefaultComboBoxModel<String> searchResultData;
    private String[] searchCriteriaData = {"All Contacts", "Name", "City", "Company/School", "Meeting Location", "Email", "Phone", "Notes"};
    private JButton findButton, newButton, editButton, deleteButton;
    private JPanel northPanel, resultPanel, infoPanel, southPanel;
    protected JLabel name, city, company, meetingLoc, email, phone, notes, lastContacted;
    private JTextField searchDetail;
    /**
     * Keeps an instance of itself to be passed to popup JFrame
     * @see #ContactOverview(ContactBook)
     */
    private ContactOverview mainPanel;

    /**
     * Constructor. Creates ContactOverview JPanel, which is used to populate the main JFrame.
     * Overall layout is vertical. Subpanels with the default flow layout keep relevant GUI elements on the same line.
     * @param program - references ContactBook created in the ContactBookGUI when the program was initialized
     *                 It is passed to this JPanel because we need to reference it to effect changes.
     * @return JPanel connecting basic functionality to all the visual elements.
     */
    public ContactOverview(ContactBook program){

        mainPanel = this;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        cb = program;
        northPanel = new JPanel();
        searchBy = new JLabel("Search by");
        northPanel.add(searchBy);
        searchCriteria = new JComboBox<>(searchCriteriaData);
        northPanel.add(searchCriteria);
        searchDetail = new JTextField("Search Details", 12);
        northPanel.add(searchDetail);
        findButton = new JButton("Find");
        findButton.addActionListener(new ButtonListener());
        northPanel.add(findButton);
        add(northPanel);

        resultPanel = new JPanel();
        searchResult = new JLabel("Search results");
        resultPanel.add(searchResult);
        searchResultData = new DefaultComboBoxModel<>();
        contactSearch = new JComboBox<>(searchResultData);
        contactSearch.setSelectedItem(null);
        contactSearch.addItemListener(new ComboBoxListener());
        resultPanel.add(contactSearch);
        add(resultPanel);
        add(new JSeparator());

        infoPanel = new JPanel();
        GridLayout grid = new GridLayout(8,2);
        grid.setVgap(10);
        infoPanel.setLayout(grid);
        infoPanel.add(new JLabel("Name:"));
        name = new JLabel("");
        infoPanel.add(name);
        infoPanel.add(new JLabel("City:"));
        city = new JLabel("");
        infoPanel.add(city);
        infoPanel.add(new JLabel("Company:"));
        company = new JLabel("");
        infoPanel.add(company);
        infoPanel.add(new JLabel("Meeting Location:"));
        meetingLoc = new JLabel("");
        infoPanel.add(meetingLoc);
        infoPanel.add(new JLabel("Email:"));
        email = new JLabel("");
        infoPanel.add(email);
        infoPanel.add(new JLabel("Phone:"));
        phone = new JLabel("");
        infoPanel.add(phone);
        infoPanel.add(new JLabel("Notes:"));
        notes = new JLabel("");
        infoPanel.add(notes);
        infoPanel.add(new JLabel("Last Contacted:"));
        lastContacted = new JLabel("");
        infoPanel.add(lastContacted);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(infoPanel);
        add(new JSeparator());
        add(Box.createVerticalStrut(15));

        southPanel = new JPanel();
        newButton = new JButton("New");
        southPanel.add(newButton);
        newButton.addActionListener(new ButtonListener());
        editButton = new JButton("Edit");
        southPanel.add(editButton);
        editButton.addActionListener(new ButtonListener());
        deleteButton = new JButton("Delete");
        southPanel.add(deleteButton);
        deleteButton.addActionListener(new ButtonListener());
        add(southPanel);
    }
    /**
     * Created by amitsuzawa on 5/14/15.
     * ComboBoxListener deals with listening and dealing with user selection from the ComboBoxes.
     * This class only affects the ComboBox that displays the Contacts, however.
     * @see #contactSearch
     */
    private class ComboBoxListener implements ItemListener {
        private String selectedContactName;

        /**
         * Upon choosing a different Contact from the ComboBox, the info fields change to match with the Contact selected.
         * Method gets the name selected and finds the respective Contact.
         * Then, it sets the info JLabels to the instance variables from that Contact.
         * @param e - accounts for event that the selection in the ComboBox has changed.
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selectedContactName = (String) e.getItem();
                Contact selectedContact = cb.getContactByName(selectedContactName);
                name.setText(selectedContact.getName());
                city.setText(selectedContact.getLocation());
                company.setText(selectedContact.getCompanyOrSchool());
                meetingLoc.setText(selectedContact.getMeetingLoc());
                email.setText(selectedContact.getEmail());
                phone.setText(selectedContact.getOtherContact());
                notes.setText(selectedContact.getNotes());
                SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy"); // converts Calendar to String
                String currentDate = formatter.format(selectedContact.getLastContacted().getTime());
                lastContacted.setText(currentDate);
            }
        }
    }
    /**
     * Created by amitsuzawa on 5/14/15.
     * ButtonListener deals with the technical side of things when user clicks on add, edit or delete.
     */
    private class ButtonListener implements ActionListener {
        /**
         * Proceeds in different ways depending on which button was clicked.
         * @param e - accounts for event that a button has been clicked.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * When source in the New button, creates a new stub Contact, adds it to the ContactBook and Contacts ComboBox.
             * Calls new popup window so that user can provide details (stub is eventually replaced).
             */
            if (e.getSource()==newButton) {
            	Contact stub = new Contact("New Contact");
                cb.addContact(stub);
                JFrame popup = new ContactChanges(mainPanel, cb, stub);
                searchResultData.addElement(stub.getName());
            }
            /**
             * When source is the Delete button, takes selected Contact's name and deletes it from the ContactBook.
             * Then since the Contact was just deleted, it clears out the info fields and resets the Contacts ComboBox.
             */
            if (e.getSource()==deleteButton) {
                cb.deleteContactByName(name.getText());
                searchResultData.removeElement(name.getText());
                contactSearch.setSelectedItem(null);
                name.setText("");
                city.setText("");
                company.setText("");
                meetingLoc.setText("");
                email.setText("");
                phone.setText("");
                notes.setText("");
                lastContacted.setText("");
            }
            /**
             * When source is the Find button, gets user provided general criteria and detail to use in one of the find methods.
             * Find methods return LinkedLists that are parsed into the searchResultData String[] to be displayed as options in the search result ComboBox.
             * If nothing is found, then the Linkedlist is empty, there are no displayed Contacts in the ComboBox and the info fields should be empty.
             */
            if (e.getSource()==findButton) {
            	String detail = searchDetail.getText();
            	String category = searchCriteria.getSelectedItem().toString();
                searchResultData.removeAllElements();
                LinkedList<Contact> results = new LinkedList<Contact>();
                if (category.equals("All Contacts")) {
                    results = cb.getAllContacts();
                } else if (category.equals("Name")) {
                	results = cb.searchByName(detail);
                } else if (category.equals("City")) { 
                	results = cb.searchByLocation(detail);
                } else if (category.equals("Company/School")) { 
                	results = cb.searchByCompanyOrSchool(detail);
                } else if (category.equals("Meeting Location")) { 
                	results = cb.searchByMeetingLoc(detail);
                } else if (category.equals("Email")) { 
                	results = cb.searchByEmail(detail);
                } else if (category.equals("Phone")) { 
                	results = cb.searchByOtherContact(detail);
                } else if (category.equals("Notes")) { 
                	results = cb.searchByNotes(detail);
                }

                if(results.isEmpty()) {
                    name.setText("");
                    city.setText("");
                    company.setText("");
                    meetingLoc.setText("");
                    email.setText("");
                    phone.setText("");
                    notes.setText("");
                    lastContacted.setText("");
                } else {
                    for (int i = 0; i < results.size(); i++) {
                        searchResultData.addElement(results.get(i).getName());
                    }
                }
            }
            /**
             * When source is the Edit button, takes selected contact's name and find corresponding Contact object.
             * Calls new popup window to deal with editing.
             */
            if (e.getSource()==editButton) {
                Contact selectedContact = cb.getContactByName(name.getText());
                JFrame popup = new ContactChanges(mainPanel, cb, selectedContact);
            }
        }
    }
}
