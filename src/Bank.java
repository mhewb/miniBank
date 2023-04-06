import java.util.Arrays;

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

    void addClient(String clientName) {
        this.bankClients[nbOfClients] = new Client(clientName);
        nbOfClients++;
    }

    String[] getClientsList() {
        String[] clientsNames = new String[nbOfClients];
        int i = 0;
        for (Client client : this.bankClients) {
            if (client == null) {
                break;
            }
            clientsNames[i] = client.getName();
            i++;
        }
        return clientsNames;
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
