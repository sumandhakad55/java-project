import java.util.*;
        public class SwitchCase{
            public static void main(String args[]){

            Scanner sc=new Scanner(System.in);

            double amt=sc.nextDouble();
             String code=sc.next().toUpperCase();
            double shippingFee=switch(code){
            case "STANDARD","REGIONAL" ->{ System.out.println("Dispatching via Ground Freight...");
            if(amt>100.0){
            yield 2.50;
            }
            else{
                yield 5.00;
            }
            }
            case "EXPRESS","PRIORITY" ->{
                System.out.println("Assigning Air Cargo space...");
                System.out.println("Generating real-time tracking ID...");
                 yield 15.00;
            }
            case "OVERNIGHT" ->{
                System.out.println("Alerting local courier for immediate rush dispatch...");
                 yield 30.00;
            }
            case "INTERNATIONAL" ->{
                System.out.println("Filing customs declaration forms...");
                System.out.println("Applying international surcharge...");
                
                 yield 50.00;
            }
            default ->{
                System.out.println("Invalid shipping code entered!");
                yield -1.0;
            }
        };
       
       if(shippingFee ==-1.0){
        System.out.println("error");
       }
       else{
       System.out.println("SHIPPING FEE IS: "+shippingFee);
       }
    }
}
