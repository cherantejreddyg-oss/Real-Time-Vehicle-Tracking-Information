package VehicleMonitoring;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    static HashMap<String, User> users = new HashMap<>();
    static Random rand = new Random();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            System.out.println("\n===== VEHICLE MONITORING SYSTEM =====");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    register(sc);
                    break;

                case 2:
                    login(sc);
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    // REGISTRATION
    public static void register(Scanner sc) {

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("User already exists!");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter vehicle registration number: ");
        String vehicleNumber = sc.nextLine();

        users.put(username, new User(username, password, vehicleNumber));

        System.out.println("Registration successful!");
    }

    // LOGIN
    public static void login(Scanner sc) {

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("User not found!");
            return;
        }

        User user = users.get(username);

        if (!user.password.equals(password)) {
            System.out.println("Incorrect password!");
            return;
        }

        System.out.println("Login successful!");

        generateLocation(user);

        System.out.println("\n=== Vehicle Location History ===");
        user.history.displayHistory();

        System.out.println("\n=== Sorted History (by date & time) ===");
        Sorter sorter = new Sorter();
        Node sorted = sorter.sortByDateTime(user.history.getHead());
        displayList(sorted);
    }

    // GENERATE RANDOM LOCATION
    public static void generateLocation(User user) {

        double lat = 10 + rand.nextDouble() * 80;
        double lon = 10 + rand.nextDouble() * 80;

        String date = LocalDate.now().toString();
        String time = LocalTime.now().withNano(0).toString();

        Vehicle v = new Vehicle(user.vehicleNumber, lat, lon, date, time);

        user.history.addUpdate(v);

        System.out.println("\nNew simulated vehicle location:");
        System.out.println(v);
    }

    public static void displayList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}