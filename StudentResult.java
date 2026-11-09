import java.io.*;

public class StudentResult {

    public static void main(String[] args) {

        int count = 0;

        System.out.println("[INFO] Reading from scores.txt...");

        try (
            BufferedReader br = new BufferedReader(
                    new FileReader("scores.txt"));
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("passed.txt"))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0].trim();
                int marks = Integer.parseInt(data[1].trim());

                if (marks >= 50) {

                    bw.write(name + "," + marks);
                    bw.newLine();

                    System.out.println(
                            "[INFO] Wrote qualified record: "
                            + name + " (" + marks + ")");

                    count++;
                }
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks format: "
                    + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid record format in scores.txt.");
        }

        System.out.println("========================================");
        System.out.println(
                "[SUMMARY] Processing complete. Total passed: " + count);
    }
}