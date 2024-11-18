import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BSTProcessor amazonTest = new BSTProcessor();
        amazonTest.readCSVintoLLRB("amazon-product-data.csv");

        // menu - see insertion or search
        ConsoleColors.println("* * * Menu * * *","blue");
        ConsoleColors.println("I - Insertion","cyan");
        ConsoleColors.println("S - Search","violet");
        ConsoleColors.println("X - Exit","yellow");

        // input
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.print("Enter Choice: ");
        while (!(choice = scanner.nextLine()).equals("X")) {
            System.out.println();
            if (choice.equals("I")) {
                amazonTest.insertTestLLRBTree();
            } else if (choice.equals("S")) {
                System.out.print("Enter ID: ");
                String userID = scanner.nextLine(); // user inputs USERID
                amazonTest.searchTestLLRBTree(userID);
            }
            System.out.print("Enter Next Choice [I,S,X]: ");
        }
        System.out.println("\nExited Menu. Have a nice day :)");
    }
}
