import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

/**
 * Created by amitsuzawa on 5/14/15.
 */
public class ContactOverview extends JPanel{

    private ContactBook<Contact> cb;
    private JLabel searchBy, searchResult;
    private JComboBox<String> searchCriteria;
    private DefaultComboBoxModel<String> searchResultData;
    private String[] searchCriteriaData = {"Name", "City", "Company/School", "Meeting Location", "Email", "Phone", "Notes"}; 
    private JButton findButton;
    private JComboBox<String> contactSearch;
    private JPanel northPanel, westPanel, eastPanel, southPanel;
    private JLabel name, city, company, meetingLoc, email, phone, notes, lastContacted;
    private JTextField searchDetail;
    private JButton newButton, editButton, deleteButton, updateButton;
    private JFrame popup; //????

    public ContactOverview(ContactBook program){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        cb = program;
        northPanel = new JPanel();
        searchBy = new JLabel("Search by");
        northPanel.add(searchBy);
        searchCriteria = new JComboBox<>(searchCriteriaData);
        northPanel.add(searchCriteria);
        searchDetail = new JTextField("Search Details");
        northPanel.add(searchDetail);
        findButton = new JButton("Find");
        findButton.addActionListener(new ButtonListener());
        northPanel.add(findButton);
        add(northPanel);

        westPanel = new JPanel();
        searchResult = new JLabel("Search results");
        westPanel.add(searchResult);
        searchResultData = new DefaultComboBoxModel<>(cb.getAllNames());
        contactSearch = new JComboBox<>(searchResultData);
        contactSearch.addItemListener(new ComboBoxListener());
        westPanel.add(contactSearch);
        add(westPanel);

        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(9,2));
        eastPanel.add(new JLabel("Contact information"));
        eastPanel.add(new JLabel());
        eastPanel.add(new JLabel("Name:"));
        name = new JLabel("");
        eastPanel.add(name);
        eastPanel.add(new JLabel("City:"));
        city = new JLabel("");
        eastPanel.add(city);
        eastPanel.add(new JLabel("Company:"));
        company = new JLabel("");
        eastPanel.add(company);
        eastPanel.add(new JLabel("Meeting Location:"));
        meetingLoc = new JLabel("");
        eastPanel.add(meetingLoc);
        eastPanel.add(new JLabel("Email:"));
        email = new JLabel("");
        eastPanel.add(email);
        eastPanel.add(new JLabel("Phone:"));
        phone = new JLabel("");
        eastPanel.add(phone);
        eastPanel.add(new JLabel("Notes:"));
        notes = new JLabel("");
        eastPanel.add(notes);
        eastPanel.add(new JLabel("Last Contacted:"));
        lastContacted = new JLabel("");
        eastPanel.add(lastContacted);
        add(eastPanel);
        
        southPanel = new JPanel();
        updateButton = new JButton("Update");
        updateButton.addActionListener(new ButtonListener());
        southPanel.add(updateButton);
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
    private class ComboBoxListener implements ItemListener {
        private String selectedContactName;

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
                // converts Calendar to String
                SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
                String currentDate = formatter.format(selectedContact.getLastContacted().getTime());
                lastContacted.setText(currentDate);
            }
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==updateButton) {
                //don't know if this is the best way to do this...
                /*
                String selectedContactName = (String) contactTable.getValueAt(contactTable.getSelectedRow(), contactTable.getSelectedColumn());
                Contact selectedContact = cb.getContactByName(selectedContactName);
                name.setText(selectedContact.getName());
                city.setText(selectedContact.getLocation());
                company.setText(selectedContact.getCompanyOrSchool());
                meetingLoc.setText(selectedContact.getMeetingLoc());
                email.setText(selectedContact.getEmail());
                phone.setText(selectedContact.getOtherContact());
                notes.setText(selectedContact.getNotes());
                */
            }
            if (e.getSource()==newButton) {
            	Contact stub = new Contact("Stub");
                cb.addContact(stub); // ????
                popup = new ContactChanges(cb, stub);
            }
            if (e.getSource()==deleteButton) {
                cb.deleteContactByName(name.getText());
                searchResultData.removeElement(name.getText());
            }
            if (e.getSource()==findButton) {
            	String detail = searchDetail.getText();
            	String category = searchCriteria.getSelectedItem().toString();
                searchResultData.removeAllElements();
                LinkedList<Contact> results = new LinkedList<Contact>();
                if (category.equals("Name")) { 
                	results = cb.searchByName(detail);
                } else if (category.equals("City")) { 
                	results = cb.searchByLocation(detail);
                } else if (category.equals("Company/School")) { 
                	results = cb.searchByCompanyOrSchool(detail);
                } else if (category.equals("Meeting Location")) { 
                	results = cb.searchByCompanyOrSchool(detail);
                } else if (category.equals("Email")) { 
                	results = cb.searchByEmail(detail);
                } else if (category.equals("Phone")) { 
                	results = cb.searchByOtherContact(detail);
                } else if (category.equals("Notes")) { 
                	results = cb.searchByCompanyOrSchool(detail);
                }
                
                for (int i = 0; i < results.size(); i++) { 
                	searchResultData.addElement(results.get(i).getName());
                }
            }
            if (e.getSource()==editButton) {
                String selectedContactName = (String) contactSearch.getSelectedItem();
                Contact selectedContact = cb.getContactByName(selectedContactName);
                popup = new ContactChanges(cb, selectedContact);
            }
        }
    }
}
