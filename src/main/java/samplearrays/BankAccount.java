package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transactions= new double[100];
    int transactionNumber =0;
    public BankAccount(String name, int startingBalance){
        this.name=name;
        this.currentBalance=startingBalance;
    }

    public void deposit(double amount){
    if(amount>0){
        transactions[transactionNumber]=amount;
        currentBalance+=amount;
        transactionNumber++;
        //i Cannot print the depositers name because we did not take it as an argument therefore I chose to omit it instead of changing the signature of the methods
        System.out.println("the amount deposited: "+amount+" the new balance: "+currentBalance);
    }
    else{
        System.out.println("the amount is invalid,must be positive");
    }
    }

    public void withdraw(double amount){
    if (amount>0 && amount<=currentBalance){
        currentBalance-=amount;
        transactions[transactionNumber]=-amount;
        transactionNumber++;
        System.out.println("the amount withdrawn "+amount+" the new balance: "+currentBalance);
    }
    else{
        System.out.println("unsuccessful withdrawal.");
    }
    }

    public void displayTransactions(){
    for(int i =0;i<transactionNumber;i++){
        if(transactions[i]>0) {
            System.out.println("the amount deposited: "+transactions[i]);
        }
        else{
            System.out.println("the amount withdrawn: "+transactions[i]);
        }
    }
    }

    public void displayBalance(){
    System.out.println("Your Current balance is : "+currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
