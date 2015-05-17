import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.*;
import java.util.*;

/**
 * Created by amitsuzawa on 5/14/15.
 */
public class ContactOverview extends JPanel{

    private ContactBook<Contact> cb;
    private JLabel searchBy, searchResult;
    private JComboBox<String> searchCriteria;
<<<<<<< HEAD
    private DefaultComboBoxModel<String> searchResultData;
    private String[] searchCriteriaData = {"Name", "City", "Company/School", "Meeting Location", "Email", "Phone", "Notes"}; 
    private JButton findButton;
    private JComboBox<String> contactSearch;
    private JPanel northPanel, westPanel, eastPanel, southPanel;
    private JTextField name, city, company, meetingLoc, email, phone, notes, searchDetail;
=======
    private DefaultComboBoxModel<String> searchCriteriaData;
    //private String[] searchCriteriaData = {"Name", "School", "City"}; //yadda yadda - Use contactBook's?
    private JTextField searchDetail;
    private JButton findButton;
    private JComboBox<String> contactSearch;
    private JPanel northPanel, westPanel, eastPanel, southPanel;
    private JLabel name, city, company, meetingLoc, email, phone, notes;
>>>>>>> origin/master
    private JButton newButton, editButton, deleteButton, updateButton;

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
        searchCriteriaData = new DefaultComboBoxModel<String>(cb.getAllNames());
        contactSearch = new JComboBox<>(searchCriteriaData);
        contactSearch.addItemListener(new ComboBoxListener());
        westPanel.add(contactSearch);
        add(westPanel);

        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(8,2));
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
        deleteButton = new JButton("Delete");
        southPanel.add(deleteButton);
        add(southPanel);

        //getSelectedRow()
    }
    private class ComboBoxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedContactName = (String) e.getItem();
                Contact selectedContact = cb.getContactByName(selectedContactName);
                name.setText(selectedContact.getName());
                city.setText(selectedContact.getLocation());
                company.setText(selectedContact.getCompanyOrSchool());
                meetingLoc.setText(selectedContact.getMeetingLoc());
                email.setText(selectedContact.getEmail());
                phone.setText(selectedContact.getOtherContact());
                notes.setText(selectedContact.getNotes());
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
                Contact newContact = new Contact("New Contact");
                cb.addContact(newContact);
                searchResultData.addElement(name.getText());

            }
            if (e.getSource()==deleteButton) {
                cb.deleteContactByName(name.getText());
                
                searchResultData.removeElement(name.getText());
=======
                //model.fireTableDataChanged(); //
                //contactTable.setValueAt(newContact.getName(),5,0);
                //???
>>>>>>> Stashed changes
            }
            if (e.getSource()==findButton) {

                searchCriteriaData.removeAllElements();
                //searchCriteriaData.add
            }
            //if (e.getSource())
        }
    }
}
