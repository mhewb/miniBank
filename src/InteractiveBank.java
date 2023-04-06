import java.util.Scanner;

public class InteractiveBank {

    // s.useLocale(Locale.US);
    //TODO: move all displays to here

    Scanner scan = new Scanner(System.in);
    int userInput;

    //TODO: add interactive Bank generation
    Bank theBank = new Bank("The Bank");

    void interact() {

        System.out.println(
                "\n--------------------- MAIN MENU OF " + theBank.getName().toUpperCase() + "--------------------------" +
                "\n 1) Add client" +
                "\n 2) Perform an operation on a client" +
                "\n 3) Display general balance" +
                "\nEnter -1 to exit the program." +
                "\n-----------------------------------------------------------------------");

        userInput = scan.nextInt();

        switch (userInput) {
            case 1 -> {
                interactAddClient();
                interact();
            }
            case 2 -> {
                Client client = interactSelectClient();
                interactOperateOnClient(client);
            }
            case 3 -> {
                theBank.displayGeneralBalance();
                interact();
            }
            case -1 -> System.exit(1);
            default -> System.out.println("Please enter a valid option.");
        }

    }

    void interactAddClient() {

        System.out.print(
                "NEW CLIENT ----------------\n" +
                "Enter client name: ");
        String clientName = scan.next();
        theBank.addClient(clientName);

        System.out.println(
                "Client " + clientName + " have been created." +
                "\n---------------------------");
    }

    Client interactSelectClient(){
        int idClient;

        System.out.println("Select the client you want act on:");
        Client[] clientsList = theBank.getClients();

        for (int i = 0; i < clientsList.length; i++) {
            if (clientsList[i] == null) {
                break;
            }
            System.out.println(i + ") " + clientsList[i].getName());
        }

        idClient = scan.nextInt();
        return theBank.getClientById(idClient);

        // TODO: if Client not exists
    }

    void interactOperateOnClient(Client client) {

        // Assuming we always perform actions on the very first account...
        // System.out.println("Select the account you want to perform an action on:");
        theBank.displayClientBalance(client);

        System.out.println(
                "\n------------------ OPERATE ACTION MENU ------------------" +
                "\nWhich operation do you want to perform on client " + client.getName() + "?" +
                "\n 1) Display balance" +
                "\n 2) Add account" +
                "\n 3) Make a withdrawal" +
                "\n 4) Make a deposit" +
                "\n 5) Transfer money" +
                "\n 6) Bail out" +
                "\nTo go back to previous menu enter -1" +
                "\n----------------------------------------------------------");

        userInput = scan.nextInt();
        float amount = 0.0f;

        switch (userInput) {
            case 1 -> {
                theBank.displayClientBalance(client);
                interactOperateOnClient(client);
            }
            case 2 -> {
                client.addAccount();
                System.out.println(
                        "------- Account creation: --------" +
                        "\nClient Name: " + client.getName() +
                        "\nNew account: " + client.getAccountById(client.getNbOfAccounts()) +
                        "\n----------------------------------"
                );
                interactOperateOnClient(client);
            }
            case 3 -> {
                System.out.println(
                        "WITHDRAWAL ------------\n" +
                        "Please enter an amount:");
                amount = scan.nextFloat();
                interactMakeWithdrawal(client, amount);
                interactOperateOnClient(client);
            }
            case 4 -> {
                System.out.println(
                        "DEPOSIT ---------------\n" +
                        "Please enter an amount:");
                amount = scan.nextFloat();
                interactMakeDeposit(client, amount);
                interactOperateOnClient(client);
            }
            case 5 -> {
                //TODO: make another account selectable
                //TODO: verify if a second account exists
                int finalAccountId = 1;
                System.out.println(
                        "TRANSFER --------------\n" +
                        "Please enter an amount:");
                amount = scan.nextFloat();
                interactMakeTransfer(client, finalAccountId, amount);
                interactOperateOnClient(client);
            }

            case 6 -> {
                client.bailOut();
                interactOperateOnClient(client);
            }

            case -1 -> interact();

            default -> System.out.println("Please enter a valid option.");
        }

    }

    void interactMakeWithdrawal(Client client, float amount) {
            Account account = client.getAccountById(0);
            account.withdrawal(amount);
            /*System.out.println(
                    "Current money on account: " + account.getBalance() +
                    " eur.");*/
        }

    void interactMakeDeposit(Client client, float amount) {
        Account account = client.getAccountById(0);
        account.deposit(amount);
            /*System.out.println(
                    "Current money on account: " + account.getBalance() +
                    " eur.");*/
    }

    void interactMakeTransfer(Client client, int finalAccountId,  float amount) {
        Account initialAccount = client.getAccountById(0);
        Account finalAccount = client.getAccountById(finalAccountId);
        initialAccount.transfer(finalAccount, amount);
            /*System.out.println(
                    "Current money on account: " + account.getBalance() +
                    " eur.");*/
    }

}
