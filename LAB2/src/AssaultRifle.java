//package AssaultRifle;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

/**
 * The AssaultRifle class represents an assault rifle with various properties, such as model, ammunition, caliber
 * weight, price, scope, muffler and enlargedMagazine.
 * It also provides methods for assault rifle operations like reloading,
 * shooting, changing caliber, installation of scope, installation of muffler, installation of enlarged magazine,
 * and displaying gun information.
 *
 * @author Khmilovskiy Stanislaw
 * @version 1.0
 * @since 1.0
 */

public class AssaultRifle {
    private String model;
    private int ammunition;
    private double caliber;
    private double weight;
    private double price;
    private boolean scope;
    private boolean muffler;
    private boolean enlargedMagazine;
    private PrintWriter fout;

    /**
     * Constructs an AssaultRifle object with default values.
     *
     * @throws IOException if there is an error creating the log file.
     */
    public AssaultRifle() throws IOException {
        model = "";
        ammunition = 0;
        caliber = 0.0;
        weight = 0.0;
        price = 0.0;
        scope = false;
        muffler = false;
        enlargedMagazine = false;
        fout = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Constructs an AssaultRifle object with the specified parameters.
     *
     * @param model              the model of the assault rifle.
     * @param ammunition         the initial ammunition count.
     * @param caliber            the caliber of the rifle.
     * @param weight             the weight of the rifle.
     * @param price              the price of the rifle.
     * @param scope              true if a scope is installed, false otherwise.
     * @param muffler            true if a muffler is installed, false otherwise.
     * @param enlargedMagazine   true if an enlarged magazine is installed, false otherwise.
     * @throws IOException if there is an error creating the log file.
     */
    public AssaultRifle(String model, int ammunition, double caliber, double weight, double price, boolean scope, boolean muffler, boolean enlargedMagazine) throws IOException {
        this.model = model;
        this.ammunition = ammunition;
        this.caliber = caliber;
        this.weight = weight;
        this.price = price;
        this.scope = scope;
        this.muffler = muffler;
        this.enlargedMagazine = enlargedMagazine;
        fout = new PrintWriter(new File("Log.txt"));
    }

    public void reload(int rounds) { //amount of bullets fired
        if (rounds > 0) {
            ammunition += rounds;
            System.out.println("Reloaded with " + rounds + " rounds.");
            logActivity("Reloaded with " + rounds + " rounds.");
        }
    }

    public void automaticFire(int bullets) {
        if (ammunition >= bullets) {
            ammunition -= bullets;
            for (int i = 0; i < bullets; i++) {
                System.out.println("Automatic Fire! (Bullet used: " + (i + 1) + ")");
            }
            System.out.println("Remaining ammunition: " + ammunition);
            logActivity("Fired " + bullets + " bullets in automatic mode.");
        } else {
            logActivity("Out of ammunition.");
        }
    }

    public void burstFire(int bursts) {
        int bulletsToFire = bursts * 3; // Кількість патронів для пострілу

        if (ammunition >= bulletsToFire) {
            ammunition -= bulletsToFire;

            for (int i = 0; i < bursts; i++) {
                System.out.println("Burst fire! (3 bullets used)");
            }
            System.out.println("Remaining ammunition: " + ammunition);
            logActivity("Fired " + bulletsToFire + " bullets in " + bursts + " bursts.");
        } else {
            logActivity("Out of ammunition.");
        }
    }

    public void singleFire(int shots) {
        if (shots <= 0) {
            System.out.println("Invalid number of shots to fire.");
            return;
        }

        int bulletsFired = 0; // Лічильник кількості вистріляних куль

        if (ammunition >= shots) {
            ammunition -= shots;

            for (int i = 0; i < shots; i++) {
                System.out.println("Single shot! (1 bullet used)");
                bulletsFired++; // Додати 1 вистріл
            }
            System.out.println("Remaining ammunition: " + ammunition);
            logActivity("Fired " + bulletsFired + " bullets in " + shots + " single shots.");
        } else {
            System.out.println("Not enough ammunition to fire " + shots + " shots.");
            logActivity("Tried to fire " + shots + " shots, but ran out of ammunition.");
        }
    }

    public void weaponScope(boolean scope, String scopeType) {
        if (scope) {
            System.out.println("Scope is installed: " + scopeType);
            logActivity("Scope is installed: " + scopeType);
        } else {
            System.out.println("No scope is installed.");
            logActivity("No scope is installed.");
        }
    }

    public void weaponMuffler(boolean muffler, String mufflerType) {
        if (muffler) {
            System.out.println("Muffler is installed: " + mufflerType);
            logActivity("Muffler is installed: " + mufflerType);
        } else {
            System.out.println("No muffler is installed.");
            logActivity("No muffler is installed.");
        }
    }

    public void weapoEnlargedMagazine(boolean enlargedMagazine, String enlargedMagazineType) {
        if (enlargedMagazine) {
            System.out.println("Enlarged magazine is installed: " + enlargedMagazineType);
            logActivity("Enlarged magazine is installed: " + enlargedMagazineType);
        } else {
            System.out.println("No enlarged magazine is installed.");
            logActivity("No enlarged magazine is installed.");
        }
    }

    public void displayInfo() {
        System.out.println("\nModel: " + model);
        System.out.println("Ammunition: " + ammunition);
        System.out.println("Caliber: " + caliber);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Price: " + price + " $");
        System.out.println("Scope: " + scope);
        System.out.println("Muffler: " + muffler);
        System.out.println("Enlarged Magazine: " + enlargedMagazine);
    }

    public void setCaliber(double caliber) {
        this.caliber = caliber;
        System.out.println("Caliber set to " + caliber + " mm.");
        logActivity("Caliber set to " + caliber + " mm.");
    }

    private void logActivity(String message) {
        fout.println(message);
        fout.flush();
    }

    /**
     * Closes the log file.
     */
    public void closeLogFile() {
        fout.close();
    }

    public static void main(String[] args) throws IOException {
        AssaultRifle rifle = new AssaultRifle("AK-47", 30, 5.45, 1.2, 1299, true, true, true);
        rifle.reload(10);
        rifle.automaticFire(10);
        System.out.println();
        rifle.burstFire(3);
        System.out.println();
        rifle.singleFire(21);
        System.out.println();
        rifle.setCaliber(7.62);
        rifle.weaponScope(true, "4x");
        rifle.weaponMuffler(true, "baffle");
        rifle.weapoEnlargedMagazine(true, "Default+10");
        rifle.closeLogFile();
    }
}
