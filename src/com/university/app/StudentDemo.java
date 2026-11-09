package com.university.app;

import com.university.model.Student;

public class StudentDemo {

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

        // These will give compilation errors:

        // System.out.println(s1.cgpa);
        // cgpa is private.

        // System.out.println(s1.hostelBlock);
        // hostelBlock is package-private.
    }
}