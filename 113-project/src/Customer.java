import javax.swing.JLabel;
import javax.swing.JTextField;

public class Customer {

	private String name;
	private String id;

	// Constructor//
	public Customer(String name, String id) {
		this.name = name;
		this.id = id;
	}

	
	public Customer(JTextField tfFirstName, JLabel lbId) {
        //TODO Auto-generated constructor stub
    }


    // methods
	public String toString() {
		return "-----------------------------------\nName: " + name + "        ID: " + id + "\n\n";
	}

	// setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
