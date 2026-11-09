import java.awt.*;
import java.awt.event.*;

public class TechFestRegistration2 extends Frame {

    TextField nameField;
    Choice eventChoice;
    Checkbox earlyBird;
    TextArea passArea;
    Button generateButton;

    public TechFestRegistration2() {

        setTitle("College Tech-Fest Registration");
        setSize(600, 400);
        setLayout(new BorderLayout(10, 10));

        // NORTH: Input panel
        Panel inputPanel = new Panel(new FlowLayout());

        inputPanel.add(new Label("Student Name:"));
        nameField = new TextField(15);
        inputPanel.add(nameField);

        inputPanel.add(new Label("Select Event:"));
        eventChoice = new Choice();
        eventChoice.add("HACKATHON");
        eventChoice.add("ROBOTICS");
        eventChoice.add("WEB_DESIGN");
        inputPanel.add(eventChoice);

        earlyBird = new Checkbox("Early Bird");
        inputPanel.add(earlyBird);

        add(inputPanel, BorderLayout.NORTH);

        // CENTER: Registration pass
        passArea = new TextArea();
        passArea.setEditable(false);
        add(passArea, BorderLayout.CENTER);

        // SOUTH: Generate button
        generateButton = new Button("Generate Pass");
        add(generateButton, BorderLayout.SOUTH);

        // Button click event
        generateButton.addActionListener(e -> {

            String name = nameField.getText().trim();
            String event = eventChoice.getSelectedItem();

            if (name.isEmpty()) {
                passArea.setText("Please enter student name.");
                return;
            }

            double fee = switch (event) {
                case "HACKATHON" -> 500.0;
                case "ROBOTICS" -> 600.0;
                case "WEB_DESIGN" -> 400.0;
                default -> 0.0;
            };

            double discount = 0.0;

            if (earlyBird.getState()) {
                discount = fee * 0.10;
            }

            double netFee = fee - discount;

            String pass = String.format(
                    "================ OFFICIAL TECH-FEST PASS ================\n"
                    + "Participant Name : %s\n"
                    + "Selected Event   : %s\n"
                    + "Standard Fee     : ₹%.2f\n"
                    + "Early Bird Disc. : %s\n"
                    + "Net Payable Fee  : ₹%.2f\n"
                    + "Status           : Registration Confirmed\n"
                    + "=========================================================",
                    name,
                    event,
                    fee,
                    earlyBird.getState()
                            ? String.format("10%% Applied (-₹%.2f)", discount)
                            : "Not Applied",
                    netFee
            );

            passArea.setText(pass);
        });

        // Close window using X button
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TechFestRegistration();
    }
}