// Tester.java
package tester;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    private final ArrayList<BMI> personList;

    public Tester() {
        personList = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("1. Create a record");
        System.out.println("2. Show BMI data for all users");
        System.out.println("3. Show BMI data for a selected user");
        System.out.println("4. Delete all");
        System.out.println("5. Exit application");
        System.out.println("Enter your choice: ");
    }

    public void index() {
        System.out.println("BMI Data for All Users:");
        for (BMI person : personList) {
            person.display();
        }
    }

    public void view(int id) {
        BMI selectedPerson = findPersonById(id);
        if (selectedPerson != null) {
            System.out.println("BMI Data for User ID " + id + ":");
            selectedPerson.display();
        } else {
            System.out.println("User with ID " + id + " not found.");
        }
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter year of birth: ");
        int yob = scanner.nextInt();
        System.out.println("Enter height in cm: ");
        int height = scanner.nextInt();
        System.out.println("Enter weight in kg: ");
        int weight = scanner.nextInt();

        BMI newUser = new BMI(id, name, yob, height, weight);
        personList.add(newUser);
        System.out.println("Record created for user with ID " + id);
    }

    public void delete() {
        personList.clear();
        System.out.println("All records deleted.");
    }

    public void exit() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String choice = scanner.next().toLowerCase();

            switch (choice) {
                case "1" -> create();
                case "2" -> index();
                case "3" -> {
                    System.out.println("Enter user ID to view: ");
                    int viewId = scanner.nextInt();
                    view(viewId);
                }
                case "4" -> delete();
                case "5" -> exit();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private BMI findPersonById(int id) {
        for (BMI person : personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.run();
    }
}
