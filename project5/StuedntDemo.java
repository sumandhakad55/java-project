public class StuedntDemo {

    public static void main(String[] args) {

        Student s1 = new Student(
                "Ananya Sen",
                101,
                8.85,
                "Block-A"
        );

        Student s2 = new Student(
                "Rohan Verma",
                102,
                7.90,
                "Block-C"
        );

        s1.displayStudent();
        s2.displayStudent();

        /*
         * These will give compilation errors because:
         *
         * s1.hostelBlock;
         * -> hostelBlock has package-private access
         *
         * s1.cgpa;
         * -> cgpa has private access
         */
    }
}

class Student {

    public String name;
    protected int rollNumber;
    private double cgpa;
    String hostelBlock;   // package-private

    public Student(String name, int rollNumber,
                   double cgpa, String hostelBlock) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.cgpa = cgpa;
        this.hostelBlock = hostelBlock;
    }

    public void displayStudent() {

        System.out.println(
                "Roll No: " + rollNumber +
                " | Name: " + name +
                " | CGPA: " + cgpa +
                " | Hostel: " + hostelBlock
        );
    }
}