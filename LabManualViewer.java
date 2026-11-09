import javax.swing.*;
import java.awt.*;

public class LabManualViewer{

    public static void main(String[] args) {

        JFrame frame = new JFrame("MCA Lab Manual");

        frame.setSize(520, 320);
    
        JTabbedPane tabs = new JTabbedPane();

        tabs.setTabPlacement(JTabbedPane.TOP);
        tabs.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // ---------------- TAB 1 ----------------

        JTextArea code = new JTextArea();

        code.setEditable(false);

        code.setText(
            "1. import java.util.*;\n" +
            "2. class Main {\n" +
            "3. public static void main(String[] args) {\n" +
            "4. int a = 10;\n" +
            "5. int b = 20;\n" +
            "6. int sum = a + b;\n" +
            "7. System.out.println(sum);\n" +
            "8. }\n" +
            "9. }\n" +
            "10. // Java Program\n" +
            "11. // Variables\n" +
            "12. // Operators\n" +
            "13. // Main Method\n" +
            "14. // Output\n" +
            "15. // End"
        );

        JScrollPane scroll1 = new JScrollPane(
            code,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
            // sets scrolling amount to 16 pixels for each unit of scrolling
        scroll1.getVerticalScrollBar().setUnitIncrement(16);

        tabs.addTab("Exercise 1", scroll1);

        // ---------------- TAB 2 ----------------

        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(4, 1, 5, 5));

        String[] inputs = {
            "Name: Student",
            "Roll Number: 101",
            "Course: MCA",
            "Semester: 3"
        };

        for (String value : inputs) {

            JTextField field = new JTextField(value);

            field.setEditable(false);

            inputPanel.add(field);
        }

        tabs.addTab("Input Specifications", inputPanel);

        // ---------------- TAB 3 ----------------

        JTextArea grading = new JTextArea();

        grading.setEditable(false);

        grading.setText(
            "5-MARK DISTRIBUTION\n\n" +
            "1. Aim - 1 Mark\n" +
            "2. Algorithm - 1 Mark\n" +
            "3. Program - 1 Mark\n" +
            "4. Output - 1 Mark\n" +
            "5. Result - 1 Mark\n\n" +
            "Total = 5 Marks"
        );

        JScrollPane scroll3 = new JScrollPane(grading);

        tabs.addTab("Grading Scheme", scroll3);

        // Add Tabbed Pane to JFrame
        frame.getContentPane().add(tabs);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}