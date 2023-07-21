public class SavingsAccount extends Account{
    private float interestRate;

    public SavingsAccount(int accountNumber , String accountName , double balance , float interestRate){
        super(accountNumber , accountName , balance);
        this.interestRate = interestRate;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public double clacBalance(){
        return getBalance() * interestRate;
    }
}
