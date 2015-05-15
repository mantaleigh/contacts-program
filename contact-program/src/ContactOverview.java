import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by amitsuzawa on 5/14/15.
 */
public class ContactOverview extends JPanel{

    private ContactBook<Contact> cb;
    private JLabel searchBy;
    private JComboBox<String> searchCriteria;
    private String[] searchCriteriaData = {"Name", "School", "City"}; //yadda yadda - Use contactBook's?
    private JTextField searchDetail;
    private JButton findButton;
    private JTable contactTable;
    private DefaultTableModel model;
    private JPanel northPanel, westPanel, eastPanel, southPanel, centralPanel;
    private JLabel name, city, company, meetingLoc, email, phone, notes;
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
        northPanel.add(findButton);
        add(northPanel);

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

        westPanel = new JPanel();
        model = new DefaultTableModel();
        model.addColumn("Contacts", cb.getAllNames());
        contactTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(contactTable);
        contactTable.setFillsViewportHeight(true);
        contactTable.setPreferredScrollableViewportSize(new Dimension(120, 200));
        /*
        contactTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                String selectedContactName = (String) contactTable.getValueAt(contactTable.getSelectedRow(),contactTable.getSelectedColumn());
                Contact selectedContact = cb.getContactByName(selectedContactName);
                //name.setText(selectedContact.getName());
                System.out.println(selectedContact.getName());
            }
        });
        */

        westPanel.add(scrollPane);
        //add(westPanel);

        centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.X_AXIS));
        centralPanel.add(westPanel);
        centralPanel.add(eastPanel);
        add(centralPanel);
        
        southPanel = new JPanel();
        updateButton = new JButton("Update");
        southPanel.add(updateButton);
        newButton = new JButton("New");
        southPanel.add(newButton);
        editButton = new JButton("Edit");
        southPanel.add(editButton);
        deleteButton = new JButton("Delete");
        southPanel.add(deleteButton);
        add(southPanel);

        //getSelectedRow()
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==updateButton) {
                //don't know if this is the best way to do this...
                String selectedContactName = (String) contactTable.getValueAt(contactTable.getSelectedRow(), contactTable.getSelectedColumn());
                Contact selectedContact = cb.getContactByName(selectedContactName);
                name.setText(selectedContact.getName());
                city.setText(selectedContact.getLocation());
                company.setText(selectedContact.getCompanyOrSchool());
                meetingLoc.setText(selectedContact.getMeetingLoc());
                email.setText(selectedContact.getEmail());
                phone.setText(selectedContact.getOtherContact());
                notes.setText(selectedContact.getNotes());
            }
            if (e.getSource()==newButton) {
                //??
            }
        }
    }
}
