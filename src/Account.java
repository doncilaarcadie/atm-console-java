public class Account {

    private double balance;


    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("£"+ amount + " transferred to your balance");
        //historyList.add("+" + amount);
    }


    public void withdraw(double amount) {
        if(this.balance - amount >= 0){
            this.balance -= amount;
            System.out.println("\nWithdraw £" + amount + " success, please take your cash!");
            //historyList.add("-" + amount);
        }else{
            System.out.println("\nLow balance!");
        }
    }
}
