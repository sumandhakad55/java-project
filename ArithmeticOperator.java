import java.util.Scanner;

public class ArithmeticOperator {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Please provide two numbers as command-line arguments.");
            return;
        }

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double result;

        switch (op) {

            case '+':
                result = num1 + num2;
                System.out.println("Result = " + result);
                break;

            case '-':
                result = num1 - num2;
                System.out.println("Result = " + result);
                break;

            case '*':
                result = num1 * num2;
                System.out.println("Result = " + result);
                break;

            case '/':
                if (num2 == 0) {
                    System.out.println("Division by zero is not allowed.");
                } else {
                    result = num1 / num2;
                    System.out.println("Result = " + result);
                }
                break;

            default:
                System.out.println("Invalid operator.");
        }

        sc.close();
    }
}