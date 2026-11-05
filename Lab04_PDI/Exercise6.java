import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise6 {

    static ArrayList<String[]> candidates = new ArrayList<>();

    // Read CSV file
    public static void readFile() throws IOException {

        BufferedReader br = new BufferedReader(
            new FileReader("CandidatePerformanceTest.csv")
        );

        // Skip the first 3 lines
        br.readLine();
        br.readLine();
        br.readLine();

        String line;

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            if (data.length == 10) {
                candidates.add(data);
            }
        }

        br.close();
    }

    // Question 1: Total candidates and gender percentages
    public static void question1() {

        int male = 0;
        int female = 0;

        for (String[] c : candidates) {

            if (c[1].equalsIgnoreCase("male")) {
                male++;
            } else if (c[1].equalsIgnoreCase("female")) {
                female++;
            }
        }

        int total = candidates.size();

        System.out.println("\nQUESTION 1");
        System.out.println("Total candidates: " + total);

        System.out.printf("Male: %.2f%%\n",
            male * 100.0 / total);

        System.out.printf("Female: %.2f%%\n",
            female * 100.0 / total);
    }

    // Question 2: Average score >= 90
    public static void question2() {

        int male = 0;
        int female = 0;

        for (String[] c : candidates) {

            double average = Double.parseDouble(c[9]);

            if (average >= 90) {

                if (c[1].equalsIgnoreCase("male")) {
                    male++;
                } else if (c[1].equalsIgnoreCase("female")) {
                    female++;
                }
            }
        }

        int total = male + female;

        System.out.println("\nQUESTION 2");
        System.out.println("Candidates with average >= 90: " + total);

        if (total > 0) {
            System.out.printf("Male: %.2f%%\n",
                male * 100.0 / total);

            System.out.printf("Female: %.2f%%\n",
                female * 100.0 / total);
        }
    }

    // Question 3: Subject scores >= 85
    public static void question3() {

        int math = 0;
        int english = 0;
        int computer = 0;

        for (String[] c : candidates) {

            if (Integer.parseInt(c[5]) >= 85) {
                math++;
            }

            if (Integer.parseInt(c[6]) >= 85) {
                english++;
            }

            if (Integer.parseInt(c[7]) >= 85) {
                computer++;
            }
        }

        System.out.println("\nQUESTION 3");
        System.out.println("Math >= 85: " + math);
        System.out.println("English >= 85: " + english);
        System.out.println("Computer >= 85: " + computer);
    }

    // Question 4: Candidates in each group
    public static void question4() {

        String[] groups = {
            "group A", "group B", "group C",
            "group D", "group E"
        };

        System.out.println("\nQUESTION 4");

        for (String group : groups) {

            int male = 0;
            int female = 0;

            for (String[] c : candidates) {

                if (c[2].equalsIgnoreCase(group)) {

                    if (c[1].equalsIgnoreCase("male")) {
                        male++;
                    } else if (c[1].equalsIgnoreCase("female")) {
                        female++;
                    }
                }
            }

            int total = male + female;

            System.out.println("\n" + group);
            System.out.println("Total: " + total);

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

        question1();
        question2();
        question3();
        question4();
    }
}
