import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Step 1: Create ArrayList
        ArrayList<String[]> students = new ArrayList<>();

        // Step 2: Read existing CSV file
        File file = new File("Ex3StudentData.csv");

        Scanner reader = new Scanner(file);

        // Skip header
        if (reader.hasNextLine()) {
            reader.nextLine();
        }

        while (reader.hasNextLine()) {

            String line = reader.nextLine();

            String[] data = line.split(",");

            if (data.length == 3) {
                students.add(data);
            }
        }

        reader.close();

        // Step 3: Add 3 more students
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {

            System.out.println("\nNew Student " + i);

            System.out.print("Enter name: ");
            String name = input.nextLine();

            System.out.print("Enter ID: ");
            String id = input.nextLine();

            System.out.print("Enter gender: ");
            String gender = input.nextLine();

            students.add(new String[]{name, id, gender});
        }

        // Step 4: Sort students by name (A-Z)
        Collections.sort(students,
            Comparator.comparing(
                student -> student[0],
                String.CASE_INSENSITIVE_ORDER
            )
        );

        // Step 5: Write updated data into CSV
        FileWriter writer = new FileWriter(file);

        writer.write("Name,ID,Gender\n");

        for (String[] student : students) {

            writer.write(
                student[0] + "," +
                student[1] + "," +
                student[2] + "\n"
            );
        }

        writer.close();
        input.close();

        // Step 6: Display sorted data
        System.out.println("\nUpdated Student List (A-Z)");
        System.out.println("--------------------------------");

        for (String[] student : students) {

            System.out.println(
                student[0] + " | " +
                student[1] + " | " +
                student[2]
            );
        }

        System.out.println("--------------------------------");
        System.out.println("Total students: " + students.size());
        System.out.println("CSV file updated successfully!");
    }
}
