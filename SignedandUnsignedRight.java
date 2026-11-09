import java.util.*;
public class SignedandUnsignedRight{
    public static void main(String[] args) {
        System.out.println("Enter any negative number:-");
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
       System.out.println(n>>2);
       System.out.println(n>>>2);
    }
}