import java.util.UUID;

public class Account {

    //method to generates id based on key?

    private String id;
    private float balance;

    public Account() {
        this.id = UUID.randomUUID().toString();
        this.balance = 0.0f;
    }

    @Override
    public String toString() {
        return "Account(" + id +") balance: " + balance + " €";
    }

    String getId() {
        return this.id;
    }

    void deposit(float amount) {
        this.balance += amount;
    }

    void withdrawal(float amount) {
        this.balance -= amount;
    }

    float getBalance() {
        return this.balance;
    }

    void displayBalance() {
        System.out.println("Account(" + this.id + ") balance: " + this.balance + "€");
    }

    void transfer(Account otherAccount, float amount) {
        this.balance -= amount;
        otherAccount.balance += amount;
    }

}
