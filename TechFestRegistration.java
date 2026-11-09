import java.awt.*;
import java.awt.event.*;

public class TechFestRegistration extends Frame implements ActionListener {

    Label nameLabel, eventLabel, modeLabel;
    Label actionLabel, statusLabel, outputLabel;

    TextField nameField;
    Choice eventChoice;
    Checkbox individual, team;
    CheckboxGroup modeGroup;
    Button registerButton;

    public TechFestRegistration() {

        setTitle("TechnoMCA 2026 - Event Registration");
        setSize(600, 350);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Student name
        nameLabel = new Label("Participant Name:");
        nameField = new TextField();

        // Event selection
        eventLabel = new Label("Select Event:");
        eventChoice = new Choice();

        eventChoice.add("Coding Hackathon");
        eventChoice.add("Web Design Blitz");
        eventChoice.add("Tech Quiz");
        eventChoice.add("Gaming League");

        // Participation mode
        modeLabel = new Label("Participation Mode:");
        modeGroup = new CheckboxGroup();

        individual = new Checkbox(
            "Individual (Rs.150)", modeGroup, true);

        team = new Checkbox(
            "Team of 2 (Rs.250)", modeGroup, false);

        Panel modePanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        modePanel.add(individual);
        modePanel.add(team);

        // Register button
        actionLabel = new Label("Actions:");
        registerButton = new Button("Register Participant");
        registerButton.addActionListener(this);

        // Output message
        statusLabel = new Label("Status Output:");
        outputLabel = new Label("Registration details appear here.");

        // Add components to Frame
        add(nameLabel);
        add(nameField);

        add(eventLabel);
        add(eventChoice);

        add(modeLabel);
        add(modePanel);

        add(actionLabel);
        add(registerButton);

        add(statusLabel);
        add(outputLabel);

        // Close window safely
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText().trim();

        // Validate name
        if (name.isEmpty()) {
            outputLabel.setText("Please enter your name!");
            return;
        }

        String event = eventChoice.getSelectedItem();
        String mode;
        int fee;

        // Calculate registration fee
        if (individual.getState()) {
            mode = "Individual";
            fee = 150;
        } else {
            mode = "Team";
            fee = 250;
        }

        // Display confirmation
        outputLabel.setText(
            "[REGISTERED] " + name + " | " +
            event + " | " + mode + " | Fee: Rs." + fee
        );
    }

    public static void main(String[] args) {
        new TechFestRegistration();
    }
}