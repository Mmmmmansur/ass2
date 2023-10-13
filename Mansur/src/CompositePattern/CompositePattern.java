package CompositePattern;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing an account
abstract class Account
{
    public abstract float getBalance(); // Abstract method to get the balance
}

// Concrete class representing a Deposit Account
class DepositAccount extends Account
{
    private String accountNo;
    private float accountBalance;

    // Constructor for DepositAccount
    public DepositAccount(String accountNo, float accountBalance)
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    // Implementation of getBalance for DepositAccount
    public float getBalance()
    {
        return accountBalance;
    }
}

// Concrete class representing a Saving Account
class SavingAccount extends Account
{
    private String accountNo;
    private float accountBalance;

    // Constructor for SavingAccount
    public SavingAccount(String accountNo, float accountBalance)
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    // Implementation of getBalance for SavingAccount
    public float getBalance()
    {
        return accountBalance;
    }
}

// Composite class representing a composite account that contains a list of accounts
class CompositeAccount extends Account
{
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    // Implementation of getBalance for CompositeAccount
    public float getBalance()
    {
        totalBalance = 0;
        for (Account account : accountList)
        {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    // Method to add an account to the composite account
    public void addAccount(Account acc)
    {
        accountList.add(acc);
    }

    // Method to remove an account from the composite account (Note: The implementation is incorrect, should be accountList.remove(acc))
    public void removeAccount(Account acc)
    {
        accountList.add(acc);
    }
}

// Main class to test the Composite Pattern
public class CompositePattern
{
    public static void main(String[] args)
    {
        CompositeAccount compositeAccount = new CompositeAccount();

        // Adding individual accounts to the composite account
        compositeAccount.addAccount(new DepositAccount("DA001", 100));
        compositeAccount.addAccount(new DepositAccount("DA002", 150));
        compositeAccount.addAccount(new SavingAccount("SA001", 200));

        // Calculating and displaying the total balance of the composite account
        float totalBalance = compositeAccount.getBalance();
        System.out.println("Total Balance : " + totalBalance);
    }
}
