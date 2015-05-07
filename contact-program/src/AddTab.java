import javax.swing.*;
import java.awt.*;

public class AddTab<T> extends JPanel{
	public AddTab(ContactBook<T> cb) {
		add(new JLabel("Add a new contact..."));
		add(new TextField("Name"));
		add(new TextField("Where you met"));
		add(new TextField("Company/School"));
		add(new TextField("Location"));
		add(new TextField("Email address"));
		add(new TextField("Phone number"));
		add(new TextField("Last contacted"));
		add(new TextField("Notes"));
	}
}
