//package KI306.Khmilovskiy.Lab5;

import java.io.*;
import java.util.*;

/**
 * FioApp used for calculation and store results in both text and binary formats.
 * @author Khmilovskiy Stanislaw
 * @version 1.0
 * @since 1.0
 */
public class FioApp {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);

        System.out.print("Введіть значення \"x\" [double]: ");
        double x = s.nextDouble();

        obj.calculate(x);
        System.out.println("Результат обчислення виразу: " + obj.getResult());

        // Запис результату у текстовий файл
        obj.writeResTxt("TextResult.txt");
        System.out.println("\nРезультат був записаний у текстовий файл!");

        // Запис результату у бінарний файл
        obj.writeResBin("BinaryResult.bin");
        System.out.println("Результат був записаний у бінарний файл!");

        // Читання результату з бінарного файлу
        String binFileName = "BinaryResult.bin";
        obj.readResBin("BinaryResult.bin");
        System.out.println("\nРезультат був зчитаний з бінарного файлу: "+ binFileName);
        System.out.println("Зчитаний результат з бінарного файлу: " + obj.getResult());

        // Читання результату з текстового файлу
        String txtFileName = "TextResult.txt";
        obj.readResTxt("TextResult.txt");
        System.out.println("\nРезультат був зчитаний з текстового файлу: "+ txtFileName);
        System.out.println("Зчитаний результат з текстового файлу: " + obj.getResult());
    }
}

/**
 * A class for performing calculations and handling file I/O operations.
 */
class CalcWFio
{
    /**
     * Writes the result to a text file.
     *
     * @param fName The name of the text file to write to.
     * @throws FileNotFoundException If the file cannot be found.
     */
    public void writeResTxt(String fName) throws FileNotFoundException
    {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ",result);
        f.close();
    }

    /**
     * Reads the result from a text file.
     *
     * @param fName The name of the text file to read from.
     */
    public void readResTxt(String fName)
    {
        try
        {
            File f = new File (fName);
            if (f.exists())
            {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            }
            else
                throw new FileNotFoundException("File " + fName + "not found");
        }
        catch (FileNotFoundException ex)
        {
            System.out.print(ex.getMessage());
        }
    }

    /**
     * Writes the result to a binary file.
     *
     * @param fName The name of the binary file to write to.
     * @throws FileNotFoundException If the file cannot be found.
     * @throws IOException           If an I/O error occurs.
     */
    public void writeResBin(String fName) throws FileNotFoundException, IOException
    {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Reads the result from a binary file.
     *
     * @param fName The name of the binary file to read from.
     * @throws FileNotFoundException If the file cannot be found.
     * @throws IOException           If an I/O error occurs.
     */
    public void readResBin(String fName) throws FileNotFoundException, IOException
    {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    /**
     * Calculates a result based on the given input.
     *
     * @param x The input value for the calculation.
     */
    public void calculate(double x)
    {
        result = EquationSolver.calculateExpression(x);
    }

    /**
     * Gets the calculated result.
     *
     * @return The calculated result.
     */
    public double getResult()
    {
        return result;
    }

    private double result;
}