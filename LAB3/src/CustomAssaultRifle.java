//package CustomAssaultRifle;

import java.io.IOException;
import java.util.Scanner;

/**
 * The CustomAssaultRifle class extends the abstract class AssaultRifle and implements the ShotEngine interface.
 * This class provides extended shooting methods and uses them to display shooting information.
 *
 * @author Khmilovskiy Stanislaw
 * @version 1.0
 * @since 1.0
 * @see AssaultRifle
 * @see ShotEngine
 */

public class CustomAssaultRifle extends AssaultRifle implements ShotEngine {
    /**
     * Constructor for the CustomAssaultRifle class.
     *
     * @param model           The model of the rifle
     * @param ammunition      The amount of ammunition
     * @param enlargedMagazine A flag for an enlarged magazine
     * @throws IOException Thrown in case of I/O errors
     */
    public CustomAssaultRifle(String model, int ammunition, boolean enlargedMagazine) throws IOException {
        super(model, ammunition, enlargedMagazine);
    }

    /**
     * Creates a new CustomAssaultRifle object with the specified parameters.
     *
     * @param model            the model of the assault rifle.
     * @param ammunition       the initial ammunition count.
     * @param caliber          the caliber of the assault rifle.
     * @param weight           the weight of the assault rifle in kilograms.
     * @param price            the price of the assault rifle in dollars.
     * @param scope            {@code true} if the assault rifle has a scope, {@code false} otherwise.
     * @param muffler          {@code true} if the assault rifle has a muffler, {@code false} otherwise.
     * @param enlargedMagazine {@code true} if the assault rifle has an enlarged magazine, {@code false} otherwise.
     * @throws IOException if an error occurs while opening the log file.
     */
    public CustomAssaultRifle(String model, int ammunition, double caliber, double weight, double price, boolean scope, boolean muffler, boolean enlargedMagazine) throws IOException {
        super(model, ammunition, caliber, weight, price, scope, muffler, enlargedMagazine);
    }
    /**
     * Extended automatic fire method with specified accuracy.
     *
     * @param bullets  The number of bullets to fire
     * @param accuracy The accuracy of the shots, ranging from 0.0 to 1.0
     */
    //Розширений метод automaticFire:
    public void automaticFire(int bullets, double accuracy) {
        int bulletsHit = (int) (bullets * accuracy);
        System.out.println("Number of bullets hit: " + bulletsHit);
        automaticFire(bullets);
        }

    /**
     * Extended burst fire method with a specified sound.
     *
     * @param bullets The number of bullets to fire
     * @param sound   The sound of the shots
     */
    //Розширений метод burstFire:
    public void burstFire(int bullets, String sound) {
        System.out.println("Shooting sound: ");
        for (int i = 0; i < bullets; i++) {
            System.out.println(sound+"!");
        }
        burstFire(bullets);
    }

    /**
     * Extended single shot method with a specified target.
     *
     * @param bullets The number of bullets to fire
     * @param target  The target being fired upon
     */
    //Розширений метод singleFire:
    public void singleFire(int bullets, String target) {
        System.out.println("Firing at " + target+ "!");
        singleFire(bullets);
    }

    /**
     * Method for testing the CustomAssaultRifle class.
     *
     * @param args Command-line arguments
     * @throws IOException Thrown in case of I/O errors
     */
    public static void main(String[] args) throws IOException {
        CustomAssaultRifle rifle = new CustomAssaultRifle("AK-47", 30, true);
        Scanner scanner = new Scanner(System.in);

        //Default TESTING:
        rifle.singleFire(10, "Enemy target");
        System.out.println();
        rifle.burstFire(3, "Boom");
        System.out.println();
        rifle.automaticFire(11, 0.2);

        //Input TESTING:
        /*System.out.print("Enter target: ");
        String target = scanner.nextLine();
        rifle.singleFire(10, target);

        System.out.print("Enter shot sound: ");
        String sound = scanner.nextLine();
        rifle.burstFire(10, sound);

        System.out.println("Enter the accuracy percentage: ");
        double accuracy = scanner.nextDouble();
        rifle.automaticFire(10, accuracy);
        */
    }
}