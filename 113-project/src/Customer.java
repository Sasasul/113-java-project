public class Customer {

	private String name;
	private String id;

	// Constructor//
	public Customer(String name, String id) {
		this.name = name;
		this.id = id;
	}

	// methods
	public String toString() {
		return "Customer Name: " + name + " Customer ID: " + id + "\n";
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
