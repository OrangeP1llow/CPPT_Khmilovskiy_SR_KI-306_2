//package AssaultRifle;

import java.io.IOException;
import java.util.Scanner;

/**
 * The AssaultRifleApp class is a console application for simulating an assault rifle.
 */

public class AssaultRifleApp {
    /**
     * The main method for running the AssaultRifleApp.
     *
     * @param args the command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Assault Rifle Simulator!\n");

        // Введення даних для створення об'єкта AssaultRifle
        System.out.print("Enter the assault rifle model: ");
        String model = scanner.nextLine();

        System.out.print("Enter the initial ammunition count: ");
        int ammunition = scanner.nextInt();

        System.out.print("Enter the caliber (e.g., 7.62): ");
        double caliber = scanner.nextDouble();

        System.out.print("Enter the weight (in kilograms): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter the price (in dollars): ");
        double price = scanner.nextDouble();

        scanner.nextLine(); // Додатковий nextLine() для очищення буфера

        System.out.print("\nEnter the presence of a scope (true/false): ");
        String scopeInput = scanner.nextLine();
        boolean scope = Boolean.parseBoolean(scopeInput);

        System.out.print("Enter the presence of a muffler (true/false): ");
        String mufflerInput = scanner.nextLine();
        boolean muffler = Boolean.parseBoolean(mufflerInput);

        System.out.print("Enter the presence of a Enlarged Magazine (true/false): ");
        String enlargedMagazineInput = scanner.nextLine();
        boolean enlargedMagazine = Boolean.parseBoolean(enlargedMagazineInput);

        // Створення об'єкту класу AssaultRifle з введеними даними
        AssaultRifle rifle = null;
        try {
            rifle = new AssaultRifle(model, ammunition, caliber, weight, price, scope, muffler, enlargedMagazine);
        } catch (IOException e) {
            System.err.println("Error opening log file: " + e.getMessage());
            return;
        }

        // Основний цикл демонстрації
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nAssault Rifle Simulator Menu:");
            System.out.println("1. Reload");
            System.out.println("2. Automatic Fire");
            System.out.println("3. Burst Fire");
            System.out.println("4. Single Fire");
            System.out.println("5. Set Caliber");
            System.out.println("6. Install scope");
            System.out.println("7. Install muffler");
            System.out.println("8. Install Enlarged Magazine");
            System.out.println("9. Display Info");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of bullets to reload: ");
                    int reloadRounds = scanner.nextInt();
                    rifle.reload(reloadRounds);
                    break;
                case 2:
                    System.out.print("Enter the number of rounds to fire: ");
                    int bulletsToFire = scanner.nextInt();
                    rifle.automaticFire(bulletsToFire);
                    break;
                case 3:
                    System.out.print("Enter the number of bursts to fire: ");
                    int bursts = scanner.nextInt();
                    rifle.burstFire(bursts);
                    break;
                case 4:
                    System.out.print("Enter the number of single shots to fire: ");
                    int shots = scanner.nextInt();
                    rifle.singleFire(shots);
                    break;
                case 5:
                    System.out.print("Enter the new caliber: ");
                    double newCaliber = scanner.nextDouble();
                    rifle.setCaliber(newCaliber);
                    break;
                case 6:
                    if (scope) {
                        System.out.print("Enter the type of new scope: ");
                        scanner.nextLine(); // Додатковий nextLine() для очищення буфера
                        String newScope = scanner.nextLine();
                        rifle.weaponScope(true, newScope);
                    } else {
                        System.out.println("Cannot add a new scope because scope is not installed.");
                    }
                    break;
                case 7:
                    if (muffler) {
                        System.out.print("Enter the type of new muffler: ");
                        scanner.nextLine(); // Додатковий nextLine() для очищення буфера
                        String newMuffler = scanner.nextLine();
                        rifle.weaponMuffler(true, newMuffler);
                    } else {
                        System.out.println("Cannot add a new muffler because muffler is not installed.");
                    }
                    break;
                case 8:
                    if (enlargedMagazine) {
                        System.out.print("Enter the type of new Enlarged Magazine: ");
                        scanner.nextLine(); // Додатковий nextLine() для очищення буфера
                        String newEnlargedMagazine = scanner.nextLine();
                        rifle.weapoEnlargedMagazine(true, newEnlargedMagazine);
                    } else {
                        System.out.println("Cannot add a new Enlarged Magazine because Enlarged Magazine is not installed.");
                    }
                    break;
                case 9:
                    rifle.displayInfo();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        rifle.closeLogFile();
        scanner.close();
        System.out.println("Assault Rifle Simulator has exited.");
    }
}
