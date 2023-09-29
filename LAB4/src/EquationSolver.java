//package KI306.Khmilovskiy.Lab4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

/**
 * The {@code EquationSolver} class provides methods for solving the equation and saving the result to a file.
 *
 * The equation is defined as: y = tan(4x) / x
 *
 * @author Khmilovskiy Stanislaw
 * @version 1.0
 * @since 1.0
 */
public class EquationSolver {
    /**
     * Calculates the value of the expression y = tan(4x) / x.
     *
     * @param x The value of the variable x.
     * @return The result of the expression.
     * @throws ArithmeticException If x is equal to 0, division by zero is not allowed.
     */
    public static double calculateExpression(double x) throws ArithmeticException {
        if (x == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе!");
        }
        // Обчислення виразу:
        double result = Math.tan(4 * x) / x;
        return result;
    }

    /**
     * Saves the result of the expression calculation to a file.
     *
     * @param result   The result of the expression calculation.
     * @param x        The value of the variable x.
     * @param fileName The name of the file to save the result.
     * @throws IOException If an error occurs while writing to the file.
     * @throws IllegalArgumentException If the fileName is null or empty.
     */
    public static void saveResultToFile(double result, double x, String fileName) throws IOException {
        // Перевірка аргументів на коректність:
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Неправильне ім'я файлу!");
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Вираз: y=tg(4x)/x\n");
            writer.write("Значення зміної \"x\": " + x +"\n");
            writer.write("\nРезультат обчислення виразу: " + result);

        } catch (IOException e) {
            // Обробка помилки запису до файлу:
            System.err.println("Помилка під час запису до файлу: " + e.getMessage());
            throw e; // Прокидання винятку далі для обробки на вищому рівні
        }
    }
}