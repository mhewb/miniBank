import java.util.Arrays;

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

    // TODO: cut the number of displayed account when null
    @Override
    public String toString() {
        return "Client{\n" +
                "clientName='" + clientName + '\'' +
                ",\nclientAccounts=" + Arrays.toString(clientAccounts) +
                ",\nnbOfAccounts=" + nbOfAccounts +
                "\n}";
    }

    String getName() {
        return this.clientName;
    }

    float getBalance() {
        float totalBalance = 0.0f;
        for (Account account: clientAccounts) {
            if (account == null) {
                break;
            }
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    void displayBalance(int index) {
        this.clientAccounts[index].displayBalance();
    }

    void addAccount() {
        clientAccounts[nbOfAccounts] = new Account(nbOfAccounts);
    }

    // void bailOut()









}
