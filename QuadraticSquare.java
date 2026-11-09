
import java.util.*;

public class QuadraticSquare {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d > 0) {
            double r1 = (-b + Math.sqrt(d)) / (2 * a);
            double r2 = (-b - Math.sqrt(d)) / (2 * a);

            System.out.printf("Roots are real and different: %.9f %.9f", r1, r2);
        }
        else if (d == 0) {
            double r = -b / (2 * a);

            System.out.printf("Roots are real and equal: %.9f", r);
        }
        else {
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-d) / (2 * a);

            System.out.printf("Roots are imaginary: %.9f + %.9fi and %.9f - %.9fi",
                    real, imaginary, real, imaginary);
        }

        sc.close();
    }
}