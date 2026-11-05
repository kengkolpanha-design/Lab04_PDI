import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise7 {

    static String[] groups = {
        "group A", "group B", "group C",
        "group D", "group E"
    };

    static Map<String, ArrayList<String[]>> groupData =
        new LinkedHashMap<>();

    // Step 1: Read CSV file
    public static void readFile() throws IOException {

        // Create an ArrayList for each group
        for (String group : groups) {
            groupData.put(group, new ArrayList<>());
        }

        BufferedReader reader = new BufferedReader(
            new FileReader("CandidatePerformanceTest.csv")
        );

        // Skip the first 3 lines
        reader.readLine();
        reader.readLine();
        reader.readLine();

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",", -1);

            if (data.length == 10) {

                String group = data[2].trim();

                if (groupData.containsKey(group)) {
                    groupData.get(group).add(data);
                }
            }
        }

        reader.close();
    }

    // Step 2: Write students into separate CSV files
    public static void writeGroupFiles() throws IOException {

        for (String group : groups) {

            ArrayList<String[]> students = groupData.get(group);

            String fileName = group.replace(" ", "") + ".csv";

            BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName)
            );

            // Write column headers
            writer.write(
                "ID,Gender,Group,Education,Test Preparation Course," +
                "Math,English,Computer,Total,Average"
            );

            writer.newLine();

            int male = 0;
            int female = 0;

            // Write student records
            for (String[] student : students) {

                writer.write(String.join(",", student));
                writer.newLine();

                if (student[1].equalsIgnoreCase("male")) {
                    male++;
                } else if (student[1].equalsIgnoreCase("female")) {
                    female++;
                }
            }

            int total = students.size();

            double malePercent = total > 0
                ? male * 100.0 / total : 0;

            double femalePercent = total > 0
                ? female * 100.0 / total : 0;

            // Write summary at the bottom
            writer.newLine();
            writer.write("SUMMARY");
            writer.newLine();

            writer.write("Total students," + total);
            writer.newLine();

            writer.write("Male," + male);
            writer.newLine();

            writer.write("Female," + female);
            writer.newLine();

            writer.write(
                String.format("Male percentage,%.2f%%", malePercent)
            );
            writer.newLine();

            writer.write(
                String.format("Female percentage,%.2f%%", femalePercent)
            );
            writer.newLine();

            writer.close();

            System.out.println(fileName + " created successfully!");
        }
    }

    // Step 3: Display group summaries
    public static void displaySummary() {

        System.out.println("\n===== GROUP SUMMARY =====");

        for (String group : groups) {

            ArrayList<String[]> students = groupData.get(group);

            int male = 0;
            int female = 0;

            for (String[] student : students) {

                if (student[1].equalsIgnoreCase("male")) {
                    male++;
                } else if (student[1].equalsIgnoreCase("female")) {
                    female++;
                }
            }

            int total = students.size();

            System.out.println("\n" + group);
            System.out.println("Total students: " + total);

            if (total > 0) {

                System.out.printf("Male: %.2f%%\n",
                    male * 100.0 / total);

                System.out.printf("Female: %.2f%%\n",
                    female * 100.0 / total);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        readFile();

        writeGroupFiles();

        displaySummary();

        System.out.println("\nAll group CSV files created successfully!");
    }
}
