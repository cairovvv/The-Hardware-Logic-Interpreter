
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HardwareRepository repo = new HardwareRepository();
        int choice;

        do {
            System.out.println("\n=== HARDWARE LOGIC INTERPRETER ===");
            System.out.println("[1] Add Hardware");
            System.out.println("[2] View Hardware Masterlist");
            System.out.println("[3] View Inventory Report");
            System.out.println("[4] Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    repo.addHardware();
                    break;
                case 2:
                    repo.printMasterlist();
                    break;
                case 3:
                    repo.printInventory();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}

