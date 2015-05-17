import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by amitsuzawa on 5/17/15.
 */
public class ContactChanges extends JFrame implements ActionListener{

    private ContactBook<Contact> cb;
    private JTextField name, city, company, meetingLoc, email, phone, notes, lastContacted;
    private JPanel infoPanel;
    private JButton submit;
    private String oldName;
    private ContactOverview mainPanel;

    public ContactChanges(ContactOverview main, ContactBook<Contact> program, Contact selectedContact) {
        mainPanel = main;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cb = program;
        //System.out.print(cb);
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(10, 2));
        infoPanel.add(new JLabel("Contact information"));
        infoPanel.add(new JLabel());
        infoPanel.add(new JLabel("Name:"));
        oldName = selectedContact.getName();
        name = new JTextField(oldName);
        infoPanel.add(name);
        infoPanel.add(new JLabel("City:"));
        city = new JTextField(selectedContact.getLocation());
        infoPanel.add(city);
        infoPanel.add(new JLabel("Company:"));
        company = new JTextField(selectedContact.getCompanyOrSchool());
        infoPanel.add(company);
        infoPanel.add(new JLabel("Meeting Location:"));
        meetingLoc = new JTextField(selectedContact.getMeetingLoc());
        infoPanel.add(meetingLoc);
        infoPanel.add(new JLabel("Email:"));
        email = new JTextField(selectedContact.getEmail());
        infoPanel.add(email);
        infoPanel.add(new JLabel("Phone:"));
        phone = new JTextField(selectedContact.getOtherContact());
        infoPanel.add(phone);
        infoPanel.add(new JLabel("Notes:"));
        notes = new JTextField(selectedContact.getNotes());
        infoPanel.add(notes);
        infoPanel.add(new JLabel("Last Contacted:"));
        //convert Calendar to String
        SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = formatter.format(selectedContact.getLastContacted().getTime());
        lastContacted = new JTextField(currentDate);
        infoPanel.add(lastContacted);

        infoPanel.add(new JLabel(""));
        submit = new JButton("Submit");
        infoPanel.add(submit);
        submit.addActionListener(this);

        add(infoPanel);

        getContentPane().add(infoPanel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String currName = name.getText();
            String currMeetingLoc = meetingLoc.getText();
            String currCity = city.getText();
            String currCompany = company.getText();
            String currEmail = email.getText();
            String currPhone = phone.getText();
            String currNotes = notes.getText();
            String currLastContacted = lastContacted.getText();

            cb.editContact(oldName, currName, currMeetingLoc, currCity, currCompany, currEmail, currPhone, currNotes, currLastContacted);

            if (!oldName.equals(currName)) {
                mainPanel.searchResultData.removeElement(oldName);
                mainPanel.searchResultData.addElement(name.getText());
            }

            mainPanel.name.setText(currName);
            mainPanel.city.setText(currCity);
            mainPanel.company.setText(currCompany);
            mainPanel.meetingLoc.setText(currMeetingLoc);
            mainPanel.email.setText(currEmail);
            mainPanel.phone.setText(currPhone);
            mainPanel.notes.setText(currNotes);

            this.dispose();
        }
    }
}
