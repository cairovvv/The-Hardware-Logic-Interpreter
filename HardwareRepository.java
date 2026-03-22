import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HardwareRepository {

    private Scanner scanner = new Scanner(System.in);
    private List<Hardware> hardwareList = new ArrayList<>();

    public HardwareRepository() {
        hardwareList.add(new Laptop(1,  "Dell",    16));
        hardwareList.add(new Laptop(2,  "HP",      8));
        hardwareList.add(new Laptop(3,  "Lenovo",  32));
        hardwareList.add(new Laptop(4,  "Apple",   16));
        hardwareList.add(new Laptop(5,  "Asus",    32));
        hardwareList.add(new Phone(6,   "Samsung", 50));
        hardwareList.add(new Phone(7,   "Apple",   48));
        hardwareList.add(new Phone(8,   "Xiaomi",  50));
        hardwareList.add(new Phone(9,   "Oppo",    64));
        hardwareList.add(new Phone(10,  "Vivo",    50));
    }

    public List<Hardware> getHardwareList() {
        return hardwareList;
    }

    public void addHardware() {
        System.out.print("Enter number of records: ");
        int count = getValidInt();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter Hardware Data");

            System.out.print("ID: ");
            int id = getValidInt();

            System.out.print("Brand: ");
            String brand = scanner.nextLine().trim();

            System.out.print("Spec: ");
            int spec = getValidInt();

            System.out.print("Type (Laptop/Phone): ");
            String type = scanner.nextLine().trim();

            while (!type.equalsIgnoreCase("Laptop") && !type.equalsIgnoreCase("Phone")) {
                System.out.print("Invalid. Enter 'Laptop' or 'Phone': ");
                type = scanner.nextLine().trim();
            }

            if (type.equalsIgnoreCase("Laptop")) {
                hardwareList.add(new Laptop(id, brand, spec));
            } else {
                hardwareList.add(new Phone(id, brand, spec));
            }
        }
    }

    public void printMasterlist() {
        System.out.println("\n=== HARDWARE MASTERLIST ===");
        if (hardwareList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Hardware hw : hardwareList) {
            System.out.println(hw.getId() + " | " + hw.getBrand() + " | " + hw.getType() + " | " + hw.interpretSpec());
        }
    }

    public void printInventory() {
        System.out.println("\n=== INVENTORY REPORT ===");
        int count16GB = 0;
        int count32GB = 0;
        int count50MP = 0;

        for (Hardware hw : hardwareList) {
            if (hw instanceof Laptop && hw.getSpec() == 16) count16GB++;
            if (hw instanceof Laptop && hw.getSpec() == 32) count32GB++;
            if (hw instanceof Phone  && hw.getSpec() == 50) count50MP++;
        }

        System.out.println("16GB Laptops: " + count16GB);
        System.out.println("32GB Laptops: " + count32GB);
        System.out.println("50MP Phones: "  + count50MP);
    }

    private int getValidInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}
