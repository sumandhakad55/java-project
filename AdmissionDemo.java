class Student {

    private static int studentCount = 0;
    private static final String INSTITUTION_CODE = "UNI-IND-2026";

    private final int rollNo;
    private String name;
    private String department;
    protected double baseTuitionFee;

    public Student(String name, String department, double baseTuitionFee) {
        studentCount++;
        rollNo = 100 + studentCount;

        this.name = name;
        this.department = department;
        this.baseTuitionFee = baseTuitionFee;
    }

    public double calculateFee() {
        return baseTuitionFee;
    }

    public final void displayProfile() {
        System.out.println(
            "[" + INSTITUTION_CODE + "] " +
            "Roll No: " + rollNo +
            " | Name: " + name +
            " | Dept: " + department +
            " | Net Payable Fee: ₹" + calculateFee()
        );
    }

    public static int getStudentCount() {
        return studentCount;

    }

}


class ScholarshipStudent extends Student {

    private double scholarshipPercentage;

    public ScholarshipStudent(

            String name,
            String department,
            double baseTuitionFee,
            double scholarshipPercentage) {

        super(name, department, baseTuitionFee);
        this.scholarshipPercentage = scholarshipPercentage;

    }

    @Override
    public double calculateFee() {
        return baseTuitionFee -
                (baseTuitionFee * scholarshipPercentage / 100);
    }

   
}


public class AdmissionDemo {

    public static void main(String[] args) {

        Student[] students = {
            new Student("Dhakad",
                    "Computer Science",
                    75000.0),

            new ScholarshipStudent("Kajal",
                    "ME",
                    80000.0,
                    25),

            new ScholarshipStudent("NIKK",
                    "ME",
                    40000.0,
                    25)
        };

        for (Student student : students) {
            student.displayProfile();
        }

        System.out.println(
            "Total Registered Students: " +
            Student.getStudentCount()
        );
        
    }
}