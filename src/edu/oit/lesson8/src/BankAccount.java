/**
 * Created by IT on 2017/5/14.
 */
public class BankAccount {
    private String id;
    private double balance = 0;
    private int transactions = 0;

    public BankAccount(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public double getBalance(){
        return this.balance;
    }
    public int getTransactions(){
        return this.transactions;
    }

    public void deposit(double amount){
        if(amount>=0 && amount<=500){
            this.balance += amount;
            this.transactions +=1;
        }
    }
    public void withdraw(double amount){
        if(this.balance !=0 && this.balance >= amount){
            this.balance -= amount;
            this.transactions +=1;
        }
    }

    public boolean transactionFee(double Fee){
        double fee = 0;
        boolean result = false;

        for(int i=0; i<this.transactions; i++){
            fee += i*Fee;
        }
        this.balance = this.balance - fee;

        if(this.transactions == 0 && this.balance>0){
            result = true;
        }else if(this.balance-fee > 0){
            result = true;
        }else{
            this.balance = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("custom: Allen");
        account1.deposit(10);
        account1.deposit(100);
        account1.deposit(40);
        account1.withdraw(56);
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Transcations: " + account1.getTransactions());
        account1.transactionFee(5);
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Transcations: " + account1.getTransactions());
        account1.transactionFee(15);
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Transcations: " + account1.getTransactions());

    }





}
