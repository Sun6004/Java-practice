package class02_2;

import class02.Customer;

	public class Bank {
		private Customer[] customers; 
		private int numberOfCustomers;

		public Bank() {
			this.customers = new Customer[10]; 
		}

		public void addCustomer(Customer customer) {
			this.customers[numberOfCustomers] = customer; 
			numberOfCustomers++; 
		}
		
		public int getNumberOfCustomers() {
			return numberOfCustomers;
		}


		public Customer[] getCustomers() {
			return customers;
		}

		
		public Customer getCustomer(int index) {
			return customers[index];
		}

		public void addCustomer(class02_2.Customer customer1) {
			
			
		}

	}

