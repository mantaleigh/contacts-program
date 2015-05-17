import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by amitsuzawa on 5/17/15.
 */
public class ContactChanges extends JPanel {

    private ContactBook<Contact> cb;
    private JTextField name, city, company, meetingLoc, email, phone, notes, lastContacted;
    private JPanel eastPanel;
    private JButton submit;
    private String oldName;

    public ContactChanges(ContactBook<Contact> program, Contact selectedContact) {
        cb = program;
        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(8, 2));
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
        lastContacted = new JTextField("");
        eastPanel.add(lastContacted);
        submit = new JButton("Submit");
        eastPanel.add(submit);
        add(eastPanel);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                cb.editContact(oldName, name.getText(), meetingLoc.getText(), city.getText() ,company.getText(), email.getText(), phone.getText(),notes.getText(), lastContacted.getText());
            }

        }
    }
}
