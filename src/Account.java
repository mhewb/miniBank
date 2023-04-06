public class Account {

    //method to generates id based on key?

    private String id;
    private float balance;

    public Account(String id) {
        this.id = id;
        this.balance = 0.0f;
    }

    void deposit(float amount) {
        this.balance += amount;
    }

    void withdrawal (float amount) {
        this.balance -= amount;
    }

    float getBalance() {
        return this.balance;
    }

    void displayBalance {
        System.out.println("Account(" + this.id + ") balance: " + this.balance);
    }

    void transfer(float amount, Account otherAccount) {
        this.balance -= amount;
        otherAccount.balance += amount;
    }

}
