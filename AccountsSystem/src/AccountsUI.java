import java.util.ArrayList;
import java.util.List;

import ecs100.UI;

public class AccountsUI {

	private List<Contact> contacts = new ArrayList<>();
	private List<Transaction> purchases = new ArrayList<>();
	private List<Transaction> sales = new ArrayList<>();


	public AccountsUI() {
		UI.initialise();
		UI.addButton("Add individual contact", this::addPerson);
		UI.addButton("Add business supplier contact", this::addSupplier);
		UI.addButton("Add business client contact", this::addBusinessClient);
		UI.addButton("Add trading partner contact", this::addTradingPartner);
		UI.addButton("List contacts", this::listContacts);
		UI.addButton("Find contact by name", this::findContact);
		UI.addButton("Record staff hours worked (weekly)", this::recordStaffHours);
		UI.addButton("Record purchase from supplier", this::recordPurchase);
		UI.addButton("Record sale to client", this::recordSale);
		UI.addButton("Report sale/purchase balance for contact", this::reportBalance);
		UI.addButton("Report transactions for contact", this::reportContactTransactions);
		UI.addButton("Report transactions for all contacts", this::reportAllTransactions);
		UI.addButton("Compute total profit", this::computeProfit);
	}

	private void addPerson() {
		UI.clearText();
		double hourlyRate = 0;
		String name = UI.askString("Name: ");
		int age = UI.askInt("Age: ");
		String birthDate = UI.askString("Birth Date (dd/mm/yyyy)");
		boolean staff = false;
		UI.println("Staff?: (y/n)");
		String ans = UI.next();
		if (ans.equalsIgnoreCase("y")) {
			staff = true;
			hourlyRate = UI.askDouble("Hourly rate: ");
		}
		Person a = new Person(name, age, birthDate, staff, hourlyRate);
		contacts.add(a);
		UI.clearText();
		UI.println("----- Contact entry successful -----");
	}

	private void addSupplier() {
		UI.clearText();
		String name = UI.askString("Name: ");
		int nbn = UI.askInt("Business number: ");
		Supplier a = new Supplier(name, nbn);
		contacts.add(a);
		UI.clearText();
		UI.println("----- Contact entry successful -----");
	}

	private void addBusinessClient() {
		UI.clearText();
		String name = UI.askString("Name: ");
		int nbn = UI.askInt("Business number: ");
		BusinessClient a = new BusinessClient(name, nbn);
		contacts.add(a);
		UI.clearText();
		UI.println("----- Contact entry successful -----");
	}

	private void addTradingPartner() {
		UI.clearText();
		String name = UI.askString("Name: ");
		int nbn = UI.askInt("Business number: ");
		TradingPartner a = new TradingPartner(name, nbn);
		contacts.add(a);
		UI.clearText();
		UI.println("----- Contact entry successful -----");
	}

	private void listContacts() {
		UI.clearText();
		UI.println("----- CONTACTS -----\n");
		for (Contact c : contacts) {
			UI.println(c.toString());
		}
	}

	private void findContact() {
		boolean contactFound = false;
		UI.clearText();
		String name = UI.askString("Name: ");
		UI.clearText();
		for (Contact c : contacts) {
			if ((c.getName()).equals(name)) {
				UI.println(c.toString());
				contactFound = true;
			}
		}
		if (!contactFound) {
			UI.println("No such contact found.");
		}
	}

	private void recordStaffHours() {
		UI.clearText();
		String name = UI.askString("Employee name: ");
		double hours = UI.askDouble("Hours worked: ");
	}

	private void recordPurchase() {
		UI.clearText();
		String name = UI.askString("Supplier: ");
		String product = UI.askString("Purchased: ");
		double price = UI.askInt("Price: ");
		Purchase a = new Purchase(name, product, price);
		purchases.add(a);
		UI.clearText();
		UI.println("----- Purchase entry successful -----");
	}

	private void recordSale() {
		UI.clearText();
		String name = UI.askString("Customer: ");
		String product = UI.askString("Purchased: ");
		double price = UI.askInt("Price: ");
		Sale a = new Sale(name, product, price);
		sales.add(a);
		UI.clearText();
		UI.println("----- Sale entry successful -----");
	}

	private void reportBalance() {

		double purchasesBalance = 0;
		double salesBalance = 0;
		boolean purchase = false;
		boolean sale = false;

		UI.clearText();
		String name = UI.askString("Name: ");
		UI.clearText();
		UI.println("----- PURCHASES -----");
		for (Transaction p : purchases) {
			if ((p.getName()).equals(name)) {
				UI.println(p.toString());
				purchasesBalance = purchasesBalance + (p.getPrice());
				purchase = true;
			}
		}
		if (!purchase) {
			UI.println("No purchases by this contact.\n");
		}
		UI.println("----- SALES -----");
		for (Transaction s : sales) {
			if ((s.getName()).equals(name)) {
				UI.println(s.toString());
				salesBalance = salesBalance + (s.getPrice());
				sale = true;
			}
		}
		if (!sale) {
			UI.println("No sales by this contact.");
		}
		UI.println();
		UI.println("Purchase total: $" + purchasesBalance);
		UI.println("Sales total: $" + salesBalance);
	}

	private void reportContactTransactions() {

		boolean purchase = false;
		boolean sale = false;

		UI.clearText();
		String name = UI.askString("Name: ");
		UI.clearText();
		UI.println("----- PURCHASES -----");
		for (Transaction p : purchases) {
			if ((p.getName()).equals(name)) {
				UI.println(p.toString());
				purchase = true;
			}
		}
		if (!purchase) {
			UI.println("No purchases by this contact.\n");
		}
		UI.println("----- SALES -----");
		for (Transaction s : sales) {
			if ((s.getName()).equals(name)) {
				UI.println(s.toString());
				sale = true;
			}
		}
		if (!sale) {
			UI.println("No sales by this contact.\n");
		}
	}

	private void reportAllTransactions() {

		boolean purchase = false;
		boolean sale = false;

		UI.clearText();
		UI.println("----- PURCHASES -----");
		for (Transaction p : purchases) {
			UI.println(p.toString());
			purchase = true;
		}
		if (!purchase) {
			UI.println("No purchases found.\n");
		}
		UI.println("----- SALES -----");
		for (Transaction s : sales) {
			UI.println(s.toString());
			sale = true;
		}
		if (!sale) {
			UI.println("No sales by this contact.\n");
		}
	}

	private void computeProfit() {
		double totalPurchases = 0;
		double totalSales = 0;

		for (Transaction p : purchases) {
			totalPurchases = totalPurchases + (p.getPrice());
		}
		for (Transaction s : sales) {
			totalSales = totalSales + (s.getPrice());
		}
		UI.println("Total company purchases: $" + totalPurchases);
		UI.println("Total company sales: $" + totalSales);
		UI.println("");
		UI.println("Total profit: $" + (totalSales - totalPurchases));
	}

	public static void main(String[] args) {
		new AccountsUI();
	}

}
