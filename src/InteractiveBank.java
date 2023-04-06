import java.util.Scanner;

public class InteractiveBank {

    Scanner scan = new Scanner(System.in);
    String userInput;

    //TODO: add interactive Bank generation
    Bank theBank = new Bank("Free Money for All");

    void interact() {

        System.out.println(
                "Which kind of operation do you want to perform?" +
                "\n1) Add client" +
                "\n2) Perform an operation on a client" +
                "\n3) Display general balance");

        userInput = scan.next();

        switch (userInput) {
            case "1" -> interactAddClient();
            case "2" -> interactOperate();
//            case "3" -> ;
            default -> System.out.println("Please enter 1, 2 or 3");
        }

    }

    void interactAddClient() {

        System.out.println("Enter client name:");
        userInput = scan.next();
        theBank.addClient(userInput);

        System.out.println("Client " + userInput + " have been created.");
        interact();

    }

    void interactOperate() {
        System.out.println(
                "Select the client you want act on:");
        String[] clientsList = theBank.getClientsList();

        for (int i = 0; i < clientsList.length; i++) {
            System.out.println(i + ") " + clientsList[i]);
        }

    }




}
