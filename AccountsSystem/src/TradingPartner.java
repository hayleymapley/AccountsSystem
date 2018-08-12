
public class TradingPartner implements Contact {
	private String name;
	private int nbn;
	
	public TradingPartner(String n, int b) {
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
	
	public void setNbn(int newNbn) {
		nbn = newNbn;
	}
	
	public String toString() {
		return "Name: " + this.getName() + "\n" +
				"Business Number: " + this.getNbn() + "\n";
	}
}
