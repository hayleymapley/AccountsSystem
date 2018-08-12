
public class Person implements Contact {
	private String name;
	private int age;
	private String birthDate;
	private boolean staff;
	private double hourlyRate;
	
	public Person(String n, int a, String bd, boolean b, double hr) {
		name = n;
		age = a;
		birthDate = bd;
		staff = b;
		hourlyRate = hr;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newAge) {
		name = newAge;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}

	public String getBirthDate() {
		return birthDate;
	}
	
	public boolean getIsStaff() {
		return staff;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	public String toString() {
		if (!getIsStaff()) {
			return "Name: " + this.getName() + "\n" +
					"Age: " + this.getAge() + "\n" + 
					"Birth Date: " + this.getBirthDate();
		} else {
			return "Name: " + this.getName() + "\n" +
					"Age: " + this.getAge() + "\n" + 
					"Birth Date: " + this.getBirthDate() + "\n" +
					"Staff: " + this.getIsStaff() + "\n" +
					"Hourly Rate" + this.getHourlyRate();
		}
	}
}
