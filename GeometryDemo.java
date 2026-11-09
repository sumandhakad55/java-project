class GeometryEngine {

    double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    double calculateArea(int side) {
        return side * side;
    }

    double calculateArea(int length, int breadth) {
        return length * breadth;
    }

    double calculateVolume(int baseLength, double height) {
        return baseLength * baseLength * height;
    }

    // Volume method 2
    double calculateVolume(double baseLength, int height) {
        return baseLength * baseLength * height;
    }
}


public class GeometryDemo {

    public static void main(String[] args) {

        GeometryEngine g = new GeometryEngine();


       
        short s = 5;
        char c = 'A';
        float f = 5.5f;

        System.out.println(
            "Area using short = " +
            g.calculateArea(s)
        );

        System.out.println(
            "Area using char = " +
            g.calculateArea(c)
        );

        System.out.println(
            "Area using float = " +
            g.calculateArea(f)
        );


        

        /*
           This statement gives compile-time error:

           g.calculateVolume(5, 10);

           Because both methods are possible:

           calculateVolume(int, double)
           calculateVolume(double, int)

           5  -> int
           10 -> int

           For first method:
           second int -> double

           For second method:
           first int -> double

           Therefore compiler cannot choose one.
        */


        // --------------------------------
        // SOLUTION USING CASTING
        // --------------------------------

        double volume1 =
            g.calculateVolume(5, (double) 10);

        System.out.println(
            "Volume = " + volume1
        );


        double volume2 =
            g.calculateVolume((double) 5, 10);

        System.out.println(
            "Volume = " + volume2
        );
    }
}