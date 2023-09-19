import java.io.*;
import java.util.*;

/**
 * Клас Lab1KhmilovskiyKI306 створює квадратну матрицю з символами-заповнювачами та зберігає її у текстовому файлі.
 *
 * @author Khmilovskiy Stanislaw
 * @version 1.0
 * @since version 1.0
 */

public class Lab1KhmilovskiyKI306
{
    /**
     * Головний метод програми.
     * @param args Аргументи командного рядка (не використовуються).
     * @throws FileNotFoundException Виникає, якщо файл виникає будь-яка помилка з файлом "MyFile.txt".
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        nRows = in.nextInt();
        in.nextLine();
        arr = new char[nRows][];

        for (int i = 0; i < nRows; i++) {
            arr[i] = new char[i + 1];
        }

        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();

        if (filler.length() == 1) {
            // Запис верхнього трикутника у файл і виведення
            for (int i = 0; i < nRows; i++) {
                for (int j = 0; j < i + 1; j++) {

                    if (i == 0) {
                        // Заповнюємо всі символи в першому рядку верхнього трикутника символами "+"
                        arr[i][j] = '+';
                    } else {
                        // Заповнюємо всі інші рядки трикутника filler
                        arr[i][j] = filler.charAt(0);
                    }

                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }
                System.out.println();
                fout.println();
            }

            // Запис нижнього трикутника у файл і виведення
            for (int i = 1; i <= nRows; i++) {
                for (int j = 1; j <= nRows; j++) {
                    if (i == nRows) {
                        System.out.print("+");
                        fout.print("+");
                    } else {
                        // Перехід до останнього символу "великого трикутника":
                        System.out.print(" ");
                        fout.print(" ");
                    }
                }
                for (int k = 1; k <= i; k++) {
                    if (i == nRows) {
                        arr[i - 1][k - 1] = '+';
                    } else {
                        arr[i - 1][k - 1] = filler.charAt(0);
                    }
                    System.out.print(arr[i - 1][k - 1]);
                    fout.print(arr[i - 1][k - 1]);
                }
                System.out.println();
                fout.println();
            }
        }
        else {
            System.out.print("\nНекоректний символ-заповнювач!");
            fout.print("\nНекоректний символ-заповнювач!");
        }


        System.out.print("\n");
        fout.print("\n");
        fout.flush();
        fout.close();
        System.out.println("Матрицю записано у файл 'MyFile.txt'.");
    }
}
