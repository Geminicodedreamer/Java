
// For Java:
// Here is an example code for a simple GUI-based grade management system using Java Swing:

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeManagementSystem extends JFrame implements ActionListener {
    private JLabel nameLabel, gradeLabel;
    private JTextField nameField, gradeField;
    private JButton addButton, clearButton;
    private JTextArea displayArea;

    public GradeManagementSystem() {
        super("Grade Management System");

        nameLabel = new JLabel("Name:");
        gradeLabel = new JLabel("Grade:");
        nameField = new JTextField(10);
        gradeField = new JTextField(10);
        addButton = new JButton("Add");
        clearButton = new JButton("Clear");
        displayArea = new JTextArea(10, 20);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        addButton.addActionListener(this);
        clearButton.addActionListener(this);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText();
            String grade = gradeField.getText();
            displayArea.append(name + ": " + grade + "\n");
            nameField.setText("");
            gradeField.setText("");
        } else if (e.getSource() == clearButton) {
            displayArea.setText("");
        }
    }

    public static void main(String[] args) {
        new GradeManagementSystem();
    }
}
