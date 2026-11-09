
import java.util.Scanner;

public class BinaryToDecimal{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter a binary String:-");
    String binary =sc.nextLine();
    boolean valid=true;

    for (int i = 0; i <  binary.length(); i++) {
      char ch=binary.charAt(i);
      if(ch!='0' && ch!='1'){
        valid=false;
        break;
      }
    }
    if(valid && binary.length()>0){
        int decimal=Integer.parseInt(binary,2);
        System.out.println("Decimal="+decimal);

    }
    else{
        System.out.println("Input is not in proper format");
    }
    sc.close();
}
}