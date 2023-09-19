import java.io.*;
import java.util.Scanner;

/**
 * Клас Lab1KhmilovskiyKI3062 створює квадратну матрицю з символами-заповнювачами та зберігає її у текстовому файлі.
 *
 * @author Khmilovskiy Stanislaw
 * @version 2.0
 * @since version 1.0
 */

public class Lab1KhmilovskiyKI3062 {
    /**
     * Головний метод програми.
     * @param args Аргументи командного рядка (не використовуються).
     * @throws FileNotFoundException Виникає, якщо файл виникає будь-яка помилка з файлом "MyFile2.txt".
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile2.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введіть розмір квадратної матриці: ");
        int size = in.nextInt();
        in.nextLine();

        System.out.print("\nВведіть символ-заповнювач: ");
        String filler = in.nextLine();

        char[][] matrix = new char[size][size];
        int mid = size / 2;
        int right = mid + 1;

        if (filler.length() == 1) {
            char fillerChar = filler.charAt(0);

            for (int i = 0; i < size; i++) {
                if (i < mid) {
                    // Заповнення та виведення верхнього трикутника матриці
                    for (int j = 0; j < i + 1; j++) {
                        matrix[i][j] = fillerChar;
                        System.out.print(matrix[i][j] + " ");
                        fout.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                    fout.println();
                } else {
                    // Виведення проміжного простору та заповнення нижнього трикутника матриці
                    for (int j = 0; j < mid; j++) {
                        System.out.print("  ");
                        fout.print("  ");
                    }

                    for (int j = mid; j < right; j++) {
                        matrix[i][j] = fillerChar;
                        System.out.print(matrix[i][j] + " ");
                        fout.print(matrix[i][j] + " ");
                    }
                    right++;
                    System.out.println();
                    fout.println();
                }
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
        System.out.println("Матрицю записано у файл 'MyFile2.txt'.");
    }
}
