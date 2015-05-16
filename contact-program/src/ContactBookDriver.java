
public class ContactBookDriver {
	public static void main(String[] args) {
	    ContactBookGUI test = new ContactBookGUI();
		ContactBook test2 = new ContactBook("testFile.txt");
		//System.out.println(test2);
		//System.out.println(test2.searchByName("Sa"));
		System.out.println(test2.searchByName("ami"));
	}
}
