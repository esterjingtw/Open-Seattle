import java.util.*;
import java.text.SimpleDateFormat;

public class ShelterDonationManager {

    private List<Donation> donations = new ArrayList<>();

    public static void main(String[] args) {
        ShelterDonationManager manager = new ShelterDonationManager();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register a donation");
            System.out.println("2. Display Individual Donations");
            System.out.println("3. Display Inventory Report");
            System.out.println("4. Display Donator Report");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter donor name:");
                    String donor = sc.nextLine();

                    System.out.println("Enter type of donation (e.g., money, food):");
                    String type = sc.nextLine();

                    System.out.println("Enter donation amount or quantity:");
                    int amount = sc.nextInt();
                    sc.nextLine();  // Consume newline

                    System.out.println("Enter date of donation (YYYY-MM-DD):");
                    String date = sc.nextLine();

                    manager.registerDonation(donor, type, amount, date);
                    break;

                case 2:
                    manager.displayIndividualDonations();
                    break;

                case 3:
                    manager.generateInventoryReport();
                    break;

                case 4:
                    manager.generateDonatorReport();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public void registerDonation(String donorName, String type, int amount, String date) {
        donations.add(new Donation(donorName, type, amount, date));
    }

    public void displayIndividualDonations() {
        System.out.println("\n Individual Donations");
        for (Donation donation: donations) {
            System.out.println("Donor: " + donation.donorName + ", Type: " + donation.type + ", Amount: " + donation.amount + ", Date: " + donation.date);
        }
    }

    public void generateInventoryReport() {
        Map<String, Integer> inventory = new HashMap<>();

        for (Donation donation : donations) {
            inventory.put(donation.type, inventory.getOrDefault(donation.type, 0) + donation.amount);
        }

        System.out.println("\nInventory Report:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void generateDonatorReport() {
        Map<String, Integer> donatorSummary = new HashMap<>();

        for (Donation donation : donations) {
            donatorSummary.put(donation.donorName, donatorSummary.getOrDefault(donation.donorName, 0) + donation.amount);
        }

        System.out.println("\nDonator Report:");
        for (Map.Entry<String, Integer> entry : donatorSummary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class Donation {
    String donorName;
    String type;
    int amount;
    String date;

    public Donation(String donorName, String type, int amount, String date) {
        this.donorName = donorName;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }
}

class Distribution {
    String type;
    int amount;
    String date;

    public Distribution(String type, int amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }
}
