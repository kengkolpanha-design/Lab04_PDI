import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        // Create CSV file
        FileWriter writer = new FileWriter("Ex3StudentData.csv");

        // Write column headers
        writer.write("Name,ID,Gender\n");

        // Input 3 students
        for (int i = 1; i <= 3; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter name: ");
            String name = input.nextLine();

            System.out.print("Enter ID: ");
            String id = input.nextLine();

            System.out.print("Enter gender: ");
            String gender = input.nextLine();

            // Write student information to CSV
            writer.write(name + "," + id + "," + gender + "\n");
        }

        // Close file
        writer.close();
        input.close();

        System.out.println("\nStudent data saved successfully!");
    }
}
