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
    private JPanel eastPanel;
    private JButton submit;
    private String oldName;
    private ContactOverview mainPanel;

    public ContactChanges(ContactOverview main, ContactBook<Contact> program, Contact selectedContact) {
        mainPanel = main;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cb = program;
        //System.out.print(cb);
        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(10, 2));
        eastPanel.add(new JLabel("Contact information"));
        eastPanel.add(new JLabel());
        eastPanel.add(new JLabel("Name:"));
        oldName = selectedContact.getName();
        name = new JTextField(oldName);
        eastPanel.add(name);
        eastPanel.add(new JLabel("City:"));
        city = new JTextField(selectedContact.getLocation());
        eastPanel.add(city);
        eastPanel.add(new JLabel("Company:"));
        company = new JTextField(selectedContact.getCompanyOrSchool());
        eastPanel.add(company);
        eastPanel.add(new JLabel("Meeting Location:"));
        meetingLoc = new JTextField(selectedContact.getMeetingLoc());
        eastPanel.add(meetingLoc);
        eastPanel.add(new JLabel("Email:"));
        email = new JTextField(selectedContact.getEmail());
        eastPanel.add(email);
        eastPanel.add(new JLabel("Phone:"));
        phone = new JTextField(selectedContact.getOtherContact());
        eastPanel.add(phone);
        eastPanel.add(new JLabel("Notes:"));
        notes = new JTextField(selectedContact.getNotes());
        eastPanel.add(notes);
        eastPanel.add(new JLabel("Last Contacted:"));
        //convert Calendar to String
        SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
        String currentDate = formatter.format(selectedContact.getLastContacted().getTime());
        lastContacted = new JTextField(currentDate);
        eastPanel.add(lastContacted);
        add(eastPanel);

        submit = new JButton("Submit");
        eastPanel.add(submit);
        submit.addActionListener(this);

        getContentPane().add(eastPanel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            cb.editContact(oldName, name.getText(), meetingLoc.getText(), city.getText(), company.getText(), email.getText(), phone.getText(), notes.getText(), lastContacted.getText());
            mainPanel.searchResultData.removeElement(oldName);
            mainPanel.searchResultData.addElement(name.getText());

            mainPanel.name.setText(name.getText());
            mainPanel.city.setText(city.getText());
            mainPanel.company.setText(company.getText());
            mainPanel.meetingLoc.setText(meetingLoc.getText());
            mainPanel.email.setText(email.getText());
            mainPanel.phone.setText(phone.getText());
            mainPanel.notes.setText(notes.getText());

            this.dispose();
        }
    }
}
