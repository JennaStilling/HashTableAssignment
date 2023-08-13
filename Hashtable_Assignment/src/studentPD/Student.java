package studentPD;

public class Student {
	private String name;
	private int id;
	private int hash100;
	private int hash200;
	
	public Student() {
		setName(null);
		setId(0);
	}
	
	public Student(String name, int id) {
		this.setName(name);
		this.setId(id);
		hash100 = (3 * id + 5) % 100;
		hash200 = (3 * id + 5) % 200;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getHash100() {
		return hash100;
	}
	
	public int getHash200() {
		return hash200;
	}
	
	public String toString() {
		return "Name: " + name + ", ID: " + id + "\n Hash Location (Size 100): " + hash100 + ", Hash Location (Size 200): " + hash200;
		
	}
}
