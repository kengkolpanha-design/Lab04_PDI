import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Create ArrayList to store student data
        ArrayList<String> students = new ArrayList<>();

        // Open CSV file
        File file = new File("Ex3StudentData.csv");

        Scanner reader = new Scanner(file);

        // Read data from CSV file
        while (reader.hasNextLine()) {

            String data = reader.nextLine();

            students.add(data);
        }

        reader.close();

        // Display data from ArrayList
        System.out.println("Student Information");
        System.out.println("------------------------------");

        for (String student : students) {

            System.out.println(student);
        }

        System.out.println("------------------------------");
        System.out.println("Total records: " + (students.size() - 1));
    }
}
