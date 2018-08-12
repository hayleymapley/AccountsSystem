
public class BusinessClient implements Contact {
	private String name;
	private int nbn;
	
	public BusinessClient(String n, int b) {
		name = n;
		nbn = b;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public int getNbn() {
		return nbn;
	}
	
	public void setId(int newNbn) {
		nbn = newNbn;
	}

	public String toString() {
		return "Name: " + this.getName() + "\n" +
				"Business Number: " + this.getNbn() + "\n";
	}
}
