public class Customer {

	private String name;
	private String id;

	// Constructor
	/*public Customer(String name, String id) {
		this.name = name;
		this.id = id;}*/
	

	// Constructor
	/*public Customer(JTextField tfFirstName, JLabel lbId) {
        tfFirstName = name;
		lbId = id;
    }*/


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
