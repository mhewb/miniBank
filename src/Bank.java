public class Bank {

    private final String bankName;
    private Client[] bankClients;
    private int nbOfClients = 0;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankClients = new Client[100];
    }

    @Override
    public String toString() {
        return "Bank{" +
                "\nbankName='" + bankName + '\'' +
                "\nnbOfClients=" + nbOfClients +
                '}';
    }

    String getName() {
        return this.bankName;
    }

    void addClient(String clientName) {
        this.bankClients[nbOfClients] = new Client(clientName);
        nbOfClients++;
    }

    Client[] getClients() {
        return this.bankClients;
    }

    Client getClientById(int id) {
        return this.bankClients[id];
    }

    // TODO: move to Interactive Bank
    void displayClientBalance(Client client) {
        System.out.println(
                "\n----------------------" +
                "\nClient "
                + client.getName()
                + "\nTotal Balance: "
                + client.getTotalBalance() +
                "\nDetail:");
        for (Account account: client.getClientAccounts()) {
            if (account == null) {
                break;
            }
            System.out.println(account);
        }
        System.out.println("----------------------");
    }

    float getGeneralBalance() {
        float totalBalance = 0.0f;
        for (Client client: bankClients) {
            if (client == null) {
                break;
            }
            totalBalance += client.getTotalBalance();
        }
        return totalBalance;
    }

    void displayGeneralBalance() {
        System.out.println("Bank "
            + this.bankName
            + " general balance:"
            + getGeneralBalance());
    }

}
