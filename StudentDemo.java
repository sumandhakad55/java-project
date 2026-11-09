class Student {

    String studentName;
    int rollNumber;

    // Parameterized constructor
    Student(String studentName, int rollNumber) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
    }

    // Copy constructor
    Student(Student s) {
        this.studentName = s.studentName;
        this.rollNumber = s.rollNumber;
    }

    // Display details
    void displayDetails() {
        System.out.println(
            "Name: " + studentName +
            ", Roll Number: " + rollNumber
        );
    }
}


public class StudentDemo {

    public static void main(String[] args) {

        // Original object
        Student s1 = new Student("Suman", 101);

        // Direct assignment
        Student s2 = s1;

        // Copy constructor
        Student s3 = new Student(s1);

        System.out.println("Initial Details:");

        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();


        // Modify s2
        System.out.println("\nAfter modifying s2:");

        s2.studentName = "Rahul";
        s2.rollNumber = 102;

        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();


        // Modify s3
        System.out.println("\nAfter modifying s3:");

        s3.studentName = "Aman";
        s3.rollNumber = 103;

        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();


        // Reference equality
        System.out.println("\nReference Equality:");

        System.out.println("s1 == s2 : " + (s1 == s2));
        System.out.println("s1 == s3 : " + (s1 == s3));
        System.out.println("s2 == s3 : " + (s2 == s3));
    }
}