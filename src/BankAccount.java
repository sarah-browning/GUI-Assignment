import javax.swing.JFrame;

/*
 * Create a BankAccount class. Include fields for Name, Account Number, Current Amount in account.
 * Write accessor and mutator functions for each class. Include a default constructor and a constructor where you set all fields.
 * Design a GUI application called BankTeller.
 */
public class BankAccount extends JFrame {
	
	//declare attributes
	private String name;
	private String acctNumber;
	private double currentAmt;
	
	//declare getters/accessors
	public String getName() { return this.name; }
	public String getAcctNumber() { return this.acctNumber; }
	public double getCurrentAmt() { return this.currentAmt; }
	
	//declare setters/mutators
	public void setName(String temp) { this.name = temp; }
	public void setAcctNumber(String temp) { this.acctNumber = temp; }
	public void setCurrentAmt(double temp) { this.currentAmt = temp; }
	
	//default constructor
	public BankAccount() {
		this.name = "";		this.acctNumber = "";	this.currentAmt = 0.00;
	}
	
	//secondary constructor to set all string attributes when object declared
	public BankAccount(String s1, String s2, double d3) {
		this.name = s1;		this.acctNumber = s2;	this.currentAmt = d3;
	}
	
	//display current state
	public void Display() {
		System.out.println("Name: " + this.name + "\nAccount Number: " + this.acctNumber + "Current Amount: $" + String.format("%.2f", this.currentAmt));
	}
	
}