import java.util.Arrays;

public class Client {

    private final String clientName;
    private Account[] clientAccounts;
    private int nbOfAccounts;

    public Client(String clientName) {
        this.clientName = clientName;
        this.clientAccounts = new Account[5];
        this.clientAccounts[0] = new Account();
        this.nbOfAccounts++;
    }

    // TODO: cut the number of displayed account when null
    @Override
    public String toString() {
        return "Client{\n" +
                "clientName='" + clientName + '\'' +
                "\nclientAccounts=" + Arrays.toString(clientAccounts) +
                "\nnbOfAccounts=" + nbOfAccounts +
                "\n}";
    }

    void bailOut() {
        for (int i = 0; i < this.clientAccounts.length; i++) {
            if (clientAccounts[i] == null) {
                break;
            }
            if (clientAccounts[i].getBalance() < 0) {
                System.out.println("Account with negative balance found:");
                System.out.println(clientAccounts[i]);
                float amountToRecover = clientAccounts[i].getBalance();
                for (Account account: clientAccounts) {
                    if (account == null) {
                        break;
                    }

                    if (account.getBalance() >= amountToRecover * -1) {
                        System.out.println("Found an account to process bail out.");
                        account.displayBalance();
                        account.transfer(clientAccounts[i], amountToRecover);
                    } else {
                        System.out.println("No account found to bail out this account.");
                    }
                }

            }
        }
    }

    String getName() {
        return this.clientName;
    }

    public Account[] getClientAccounts() {
        return this.clientAccounts;
    }

    int getNbOfAccounts() {
            return this.nbOfAccounts;
    }

    Account getAccountById(int id) {
        return this.clientAccounts[id];
    }

    float getTotalBalance() {
        float totalBalance = 0.0f;
        for (Account account : clientAccounts) {
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
        clientAccounts[nbOfAccounts] = new Account();
    }

}
