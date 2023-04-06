public class Bank {

    private final String bankName;
    private Client[] bankClients;
    private int nbOfClients = 0;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.bankClients = new Client[100];
    }

    void addClient(String clientName) {
        this.bankClients[nbOfClients] = new Client(clientName);
        nbOfClients++;
    }

    float getClientBalance(int idClient) {
        return this.bankClients[idClient].getBalance();
    }

    void displayClientBalance(int idClient) {
        System.out.println("Client "
                + this.bankClients[idClient].getName()
                + ", balance: "
                + getClientBalance(idClient));
    }

    float getGeneralBalance() {
        float totalBalance = 0.0f;
        for (Client client: bankClients) {
            if (client == null) {
                break;
            }
            totalBalance += client.getBalance();
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
