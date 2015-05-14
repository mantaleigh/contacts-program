import javax.swing.*;

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

    public ContactOverview(ContactBook program){
        cb = program;
        searchBy = new JLabel("Search by");
        add(searchBy);
        searchCriteria = new JComboBox<>(searchCriteriaData);
        add(searchCriteria);
        searchDetail = new JTextField("Search Details");
        add(searchDetail);
        findButton = new JButton("Find");
        add(findButton);
    }
}
