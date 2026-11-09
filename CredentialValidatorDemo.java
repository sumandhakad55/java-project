import java.util.*;
public class CredentialValidatorDemo {
 
    public static String validateEmail(String email) {
        int atCount = 0;
        int atPosition = -1;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                atCount++;
                atPosition = i;
            }
        }
        if (atCount != 1) {
            return "Email must contain exactly one '@' symbol.";
        }
        String prefix = email.substring(0, atPosition);
        String domain = email.substring(atPosition + 1);

        if (prefix.length() < 4) {
            return "Email prefix must contain at least 4 characters.";
        }

    
        if (Character.isDigit(prefix.charAt(0))) {
            return "Email prefix cannot start with a numeric digit.";
        }

        if (!(domain.endsWith(".edu.in") || domain.endsWith(".ac.in"))) {
            return "Email domain must end with .edu.in or .ac.in.";
        }

        return "Valid Institutional Email.";
    }
    public static String validatePassword(String password) {

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        
        if (password.length() < 8) {
            return "Password must contain at least 8 characters.";
        }

        
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }

            if (Character.isLowerCase(ch)) {
                hasLower = true;
            }

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            if (ch == '@' || ch == '#' || ch == '$' || ch == '%') {
                hasSymbol = true;
            }
        }

       
        if (!hasUpper && !hasLower && !hasDigit && !hasSymbol) {
            return "Password must contain at least one uppercase letter, "
                    + "one lowercase letter, one digit and one special symbol "
                    + "(@, #, $, %).";
        }

        if (!hasUpper) {
            return "Password must contain at least one uppercase letter.";
        }

        if (!hasLower) {
            return "Password must contain at least one lowercase letter.";
        }

        if (!hasDigit && !hasSymbol) {
            return "Password must contain at least one digit and one special symbol (@, #, $, %).";
        }

        if (!hasDigit) {
            return "Password must contain at least one digit.";
        }

        if (!hasSymbol) {
            return "Password must contain at least one special symbol (@, #, $, %).";
        }

        return "Password meets all security requirements.";
    }


    
    public static void main(String[] args) {

        System.out.println("--- Evaluating Student Credentials ---");

        
        String email1 = "2026amit@mca.edu.in";

        System.out.println("Testing Email: \"" + email1 + "\"");
        String emailResult1 = validateEmail(email1);

        if (emailResult1.equals("Valid Institutional Email.")) {
            System.out.println("[APPROVED] " + emailResult1);
        } else {
            System.out.println("[REJECTED] " + emailResult1);
        }

      Scanner sc=new Scanner(System.in);
        
      //  String email2 = "amit.kumar@mca.edu.in";
      System.out.println("Enter email2:-");
      String email2 =sc.nextLine();

        System.out.println("Testing Email: \"" + email2 + "\"");
        String emailResult2 = validateEmail(email2);

        if (emailResult2.equals("Valid Institutional Email.")) {
            System.out.println("[APPROVED] " + emailResult2);
        } else {
            System.out.println("[REJECTED] " + emailResult2);
        }


        
        String password1 = "mcaPassword";

        System.out.println("Testing Password: \"" + password1 + "\"");
        String passwordResult1 = validatePassword(password1);

        if (passwordResult1.equals("Password meets all security requirements.")) {
            System.out.println("[APPROVED] " + passwordResult1);
        } else {
            System.out.println("[REJECTED] " + passwordResult1);
        }

        String password2 = "Mca@2026Secure";

        System.out.println("Testing Password: \"" + password2 + "\"");
        String passwordResult2 = validatePassword(password2);

        if (passwordResult2.equals("Password meets all security requirements.")) {
            System.out.println("[APPROVED] " + passwordResult2);
        } else {
            System.out.println("[REJECTED] " + passwordResult2);
        }
    }
}