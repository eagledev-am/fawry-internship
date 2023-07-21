import java.util.Scanner;

public class BankApplication {
    private static Bank bank;
    private static Scanner sc;
    public static void main(String[] args) {
        bank = Bank.getInstance();
        sc = new Scanner(System.in);
        startApp();
    }

    public static void mainMenu(){
        System.out.println("Main Menu");
        System.out.println("1- Open an Account");
        System.out.println("2- Account Details");
        System.out.println("3- Deposit");
        System.out.println("4- WithDraw");
        System.out.println("5- Balance");
        System.out.println("6- quit");
    }

    public static void startApp(){
        bank = Bank.getInstance();
        sc = new Scanner(System.in);
        mainMenu();
        boolean app = true;
        while(app == true){
            System.out.print("Enter operation number : ");
            int operation = sc.nextInt();
            switch (operation){
                case 1 :
                    openAccount();
                    break;
                case 2 :
                    accountDetails();
                    break;
                case 3 :
                    deposit();
                    break;
                case 4 :
                    withdraw();
                    break;
                case 5 :
                    showBalance();
                    break;
                default:
                    app = false;
            }
        }
    }

    private static void showBalance() {
        System.out.print("Enter Account number : ");
        int accountNumber = sc.nextInt();
        bank.displayBalance(accountNumber);
        System.out.println("*********************");
    }

    private static void withdraw() {
        System.out.print("Enter Account number : ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();
        bank.withdraw(accountNumber , amount);
        System.out.println("*********************");
    }

    private static void deposit() {
        System.out.print("Enter Account number : ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();
        bank.deposit(accountNumber , amount);
        System.out.println("*********************");
    }

    private static void accountDetails() {
        System.out.print("Enter Account number : ");
        int accountNumber = sc.nextInt();
        bank.accountDetails(accountNumber);
        System.out.println("*********************");
    }

    private static void openAccount() {
        System.out.print("Enter account number : ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter account name : " );
        String name = sc.next();
        System.out.print("Enter account Balance : ");
        double balance = sc.nextDouble();
        System.out.print("Enter interest rate : ");
        float interest = sc.nextFloat();

        Account account = new SavingsAccount(accountNumber , name , balance , interest);
        if(bank.addAccount(account)){
            System.out.println("account added successfully !");
            System.out.println("*********************");
        }else{
            System.out.println("invalid operation !");
            System.out.println("Account number is invalid !");
            System.out.println("*********************");
        }

    }
}