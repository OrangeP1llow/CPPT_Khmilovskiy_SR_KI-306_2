//package KI306.Khmilovskiy.Lab4;

import java.io.IOException;
import java.util.Scanner;

/**
 * The {@code EquationSolverApp} class is a program that allows users to input a value for the variable 'x',
 * calculate the result of the expression y = tan(4x) / x using the {@link EquationSolver} class, and save the result to a file.
 *
 * Users are prompted to enter a double value for 'x', and the program calculates the result of the expression
 * and saves it to a file named "result.txt". Error handling is provided for input validation and file operations.
 *
 * @author Khmilovskiy Stanislaw
 * @version 1.0
 * @since 1.0
 */
public class EquationSolverApp {
    /**
     * The main method of the application.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            //4 test:
            //double x = 2.0;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть значення \"x\" [double]: ");

            double x = scanner.nextDouble();
            double result = EquationSolver.calculateExpression(x);
            System.out.println("Результат обчислення виразу: " + result);

            EquationSolver.saveResultToFile(result, x, "result.txt");
            System.out.println("Результат записано у файл \"result.txt\"");

        } catch (java.util.InputMismatchException e) {
            System.err.println("Помилка: Ви ввели нечислове значення.");
        } catch (ArithmeticException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка під час запису до файлу: " + e.getMessage());
        }
    }
}