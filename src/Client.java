public class Client {

    private final String clientName;
    private Account[] clientAccounts;
    private int nbOfAccounts;

    public Client(String clientName) {
        this.clientName = clientName;
        this.clientAccounts = new Account[100];
        this.clientAccounts[0] = new Account(0);
        this.nbOfAccounts++;
    }

    String getName() {
        return this.clientName;
    }

    float getBalance(int index) {
        return this.clientAccounts[index].getBalance();
    }

    void displayBalance(int index) {
        this.clientAccounts[index].displayBalance();
    }

    void addAccount() {
        clientAccounts[nbOfAccounts] = new Account(nbOfAccounts);
    }

    // void bailOut()









}
