import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
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
    private JPanel northPanel, westPanel, eastPanel, southPanel;
    private JLabel name, city, company;
    private JButton newButton, editButton, deleteButton;
    
    public ContactOverview(ContactBook program){
        setLayout(new BorderLayout());
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
        add(northPanel, BorderLayout.NORTH);

        westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        model = new DefaultTableModel();
        model.addColumn("Contacts", cb.getAllNames());
        contactTable = new JTable(model);
        westPanel.add(contactTable.getTableHeader());
        westPanel.add(contactTable, BorderLayout.WEST);
        add(westPanel, BorderLayout.WEST);

        eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(6,2));
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
        add(eastPanel, BorderLayout.EAST);
        
        southPanel = new JPanel();
        newButton = new JButton("New");
        southPanel.add(newButton);
        editButton = new JButton("Edit");
        southPanel.add(editButton);
        deleteButton = new JButton("Delete");
        southPanel.add(deleteButton);
        add(southPanel, BorderLayout.SOUTH);
    }
}
