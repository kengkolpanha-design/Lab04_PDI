import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) throws IOException {

        // Part 1: Generate 500 random numbers
        Random random = new Random();

        FileWriter writer = new FileWriter("LuckyNumber.csv");

        for (int i = 1; i <= 500; i++) {

            int number = random.nextInt(100) + 1;

            writer.write(number + "\n");
        }

        writer.close();

        System.out.println("500 random numbers generated successfully!");

        // Part 2: Read numbers from CSV file
        File file = new File("LuckyNumber.csv");

        Scanner reader = new Scanner(file);

        System.out.println("\nReading numbers from LuckyNumber.csv:");

        int count = 0;

        while (reader.hasNextInt()) {

            int number = reader.nextInt();

            System.out.print(number + " ");

            count++;
        }

        reader.close();

        System.out.println("\n\nTotal numbers read: " + count);
    }
}
