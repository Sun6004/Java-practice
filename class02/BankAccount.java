package class02;

public abstract class BankAccount {
	  protected int balance;
	   
	   public BankAccount(int balance){
	      this.balance=balance;
	   }

	   public abstract String getAccountType();

	   public int getBalance() { 
	      return this.balance;
	   }
	   public void deposit(int amount) {   
	   }
	    public boolean withdraw(int amount) {
	       if(amount >= balance) {
	          return false;
	       }
	       balance -= amount;
	       return true;
	    }
	    

	    public boolean transfer(int amount,BankAccount otherAccount) //throws IllegalArgumentException : 굳이 할 필요없음
	    { 
	       if(amount < 0||amount > balance){   
	          throw new IllegalArgumentException();
	       }if(otherAccount == null){
		  throw new NullPointException();
	       }if(withdraw(amount){
		   otherAccount.deposit(amount);
		   return true;
	       }
	    }

	    public String toString() {
	       return String.format("%,d ",balance);
	    }
	}
