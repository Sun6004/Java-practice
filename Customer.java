package class02_2;

public class Customer {
	private String firstName;
	private String lastName;
	private BankAccount[] accounts;
	private int numberOfAccounts; //계좌의 수


	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accounts = new BankAccount[5];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public BankAccount getAccount(int index) {
		return accounts[index];
	}

	public void addAccount(BankAccount account) {
		accounts[numberOfAccounts] = account;
		numberOfAccounts++;
		//accounts[numberOfAccounts++] = account;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public String toString() {
		return String.format("이름: %s %s, 계좌의 갯수: %d원", firstName, lastName, numberOfAccounts);
	}
}
