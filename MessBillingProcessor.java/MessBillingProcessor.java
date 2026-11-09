import java.io.*;

public class MessBillingProcessor {

    public static void main(String[] args) {

        String inputFile = "raw_mess_data.txt";
        String outputFile = "final_mess_report.txt";

        int totalStudents = 0;
        double totalRevenue = 0;

        System.out.println("[MESS SYSTEM] Ingesting '" + inputFile + "'...");

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String rollNumber = data[0].trim();
                String studentName = data[1].trim();
                int regularMeals = Integer.parseInt(data[2].trim());
                int specialCoupons = Integer.parseInt(data[3].trim());//ye "48" ko 48 krta h 

                double mealCost = regularMeals * 40;
                double couponCost = specialCoupons * 75;
                double totalBill = mealCost + couponCost;

                totalStudents++;
                totalRevenue += totalBill;

                String invoice =
                    "Roll: " + rollNumber +
                    " | Name: " + studentName +
                    " | Meals: " + regularMeals +
                    " (₹" + mealCost + ")" +
                    " | Coupons: " + specialCoupons +
                    " (₹" + couponCost + ")" +
                    " | Net: ₹" + totalBill;

                bw.write(invoice);
                bw.newLine();

                System.out.println(
                    "[PROCESSED] " + rollNumber +
                    " | " + studentName +
                    " | Total: ₹" + totalBill
                );
            }

            System.out.println(
                "--- Audit File '" + outputFile +
                "' Generated Successfully ---"
            );

            System.out.println(
                "Total Students Ingested : " + totalStudents
            );

            System.out.println(
                "Cumulative Mess Revenue : ₹" + totalRevenue
            );

        } catch (FileNotFoundException e) {

            System.out.println(
                "[ERROR] File not found: " + e.getMessage()
            );

        } catch (IOException e) {

            System.out.println(
                "[ERROR] File I/O error: " + e.getMessage()
            );
        }
    }
}