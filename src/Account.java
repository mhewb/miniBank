import java.util.UUID;

public class Account {

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

    float getBalance() {
        return this.balance;
    }

    void deposit(float amount) {
        this.balance += amount;
    }

    void withdrawal(float amount) {
        this.balance -= amount;
    }

    void displayBalance() {
        System.out.println("Account(" + this.id + ") balance: " + this.balance + "€");
    }

    void transfer(Account otherAccount, float amount) {
        this.balance -= amount;
        otherAccount.balance += amount;
    }

}
