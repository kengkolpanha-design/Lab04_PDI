import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Ask user for number of files
        System.out.print("Enter number of files: ");
        int n = input.nextInt();

        // Step 2: Create folder
        File folder = new File("Ex2LuckyNumber");
        folder.mkdir();

        // Step 3: Create n CSV files
        for (int i = 1; i <= n; i++) {

            File file = new File(folder, "file" + i + ".csv");

            FileWriter writer = new FileWriter(file);

            // Generate 10 random numbers per file
            for (int j = 1; j <= 10; j++) {

                int number = random.nextInt(100) + 1;

                writer.write(number + "\n");
            }

            writer.close();

            System.out.println(file.getName() + " created successfully!");
        }

        // Step 4: Create ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();

        // Step 5: Read all CSV files
        for (int i = 1; i <= n; i++) {

            File file = new File(folder, "file" + i + ".csv");

            Scanner reader = new Scanner(file);

            while (reader.hasNextInt()) {

                int number = reader.nextInt();

                numbers.add(number);
            }

            reader.close();
        }

        // Step 6: Find maximum and minimum
        int max = numbers.get(0);
        int min = numbers.get(0);

        for (int number : numbers) {

            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }
        }

        // Step 7: Display results
        System.out.println("\nAll numbers: " + numbers);

        System.out.println("Total numbers: " + numbers.size());

        System.out.println("Maximum number: " + max);

        System.out.println("Minimum number: " + min);

        input.close();
    }
}
