import java.util.ArrayList;
import java.util.List;

public class Bank {
    
    private List<Account> accounts;
    private static Bank instance;
    private Bank(){
        accounts = new ArrayList<>();
    }
    
    public static Bank getInstance(){
        if(instance == null){
            instance = new Bank();
        }
        return instance;
    }
    
    public boolean addAccount(Account account){
        if(checkAccount(account.getAccountNumber()) == null) {
            accounts.add(account);
            return true;
        }
        return false;
    }

    public void deposit(int accountNumber , double amount){
        Account account = checkAccount(accountNumber);
        if(account != null){
            account.deposit(amount);
            System.out.println("Successful Operation !");
        }else{
            System.out.println("Account not found");
        }
    }

    public void withdraw(int accountNumber , double amount){
        Account account = checkAccount(accountNumber);
        if(account != null){
            account.withdraw(amount);
            System.out.println("Successful Operation!");
        }else{
            System.out.println("Account not found !");
        }
    }
    
    public void displayBalance(int accountNumber){
        Account account = checkAccount(accountNumber);
        if(account != null){
            System.out.println("Account Balance : " + account.getBalance());
        }else{
            System.out.println("Account not found !");
        }
    }

    public void accountDetails(int accountNumber){
        Account account = checkAccount(accountNumber);
        if(account != null){
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Account Name : " + account.getAccountName());
            System.out.println("Account Balance : " + account.getBalance());
            System.out.println("Interest Rate :" + ((SavingsAccount)account).getInterestRate());
        }else{
            System.out.println("Account number is not existed !");
        }
    }
    
    private Account checkAccount(int accountNumber) {
        for(Account account : accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null;
    }
}
