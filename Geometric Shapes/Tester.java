package mexer2.prog2.edu.slu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tester {
    private JFrame frame;
    private JPanel dropdownPanel, inputsPanel, resultsPanel, buttonsPanel;
    private JComboBox dropdown;
    private JLabel nameOfShapeLabel, noShapeSelectedLabel, shapeDescription, areaLabel, perimeterLabel;
    private JTextField nameofShapeTextField, areaTextField, perimeterTextField;
    private JButton calculateButton, clearButton, exitButton;
    private DropdownHandler dropdownHandler;
    private ClearButtonHandler clearButtonHandler;
    private CalculateButtonHandler calculateButtonHandler;
    private ExitButtonHandler exitButtonHandler;

  public Tester() {
        frame = new JFrame();

        buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(300, 50));
        buttonsPanel.setMaximumSize(buttonsPanel.getPreferredSize());
        buttonsPanel.setLayout(new GridLayout(1, 3));

        calculateButton = new JButton("Calculate");
        calculateButtonHandler = new CalculateButtonHandler();
        calculateButton.addActionListener(calculateButtonHandler);

        clearButton = new JButton("Clear");
        clearButtonHandler = new ClearButtonHandler();
        clearButton.addActionListener(clearButtonHandler);

        exitButton = new JButton("Exit");
        exitButtonHandler = new ExitButtonHandler();
        exitButton.addActionListener(exitButtonHandler);

        buttonsPanel.add(calculateButton);
        buttonsPanel.add(clearButton);
        buttonsPanel.add(exitButton);

        frame.add(buttonsPanel);

        frame.setTitle("");
        frame.setSize(300, 440);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
  
  public class CalculateButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Shape shape = createShape((String) dropdown.getSelectedItem());

                if (shape.area() < 0 || shape.perimeter() < 0) {
                    shapeDescription.setText("<html><p style='width: 200px; text-align: center;'>The area or perimeter " +
                            "cannot be negative. Please input non-negative values only.</p></html>");
                    clearTextFieldsInPanel(resultsPanel);
                } else if (Double.isNaN(shape.area())) {
                    if (shape instanceof Triangle) {
                        shapeDescription.setText("<html><p p style='width: 200px; text-align: center;'>The sides do not " +
                                "form a valid triangle. The sum of the lengths of any two sides must not be less than or " +
                                "equal to the length of the third side.</p></html>");
                        clearTextFieldsInPanel(resultsPanel);
                    }
                } else {
                    shapeDescription.setText(shape.toString());
                    areaTextField.setText(Double.toString(shape.area()));
                    perimeterTextField.setText(Double.toString(shape.perimeter()));
                }
            } catch (NumberFormatException a) {
                shapeDescription.setText("Please enter numbers only.");
                clearTextFieldsInPanel(resultsPanel);
            }
        }

        private Shape createShape(String selectedItem) throws NumberFormatException {
            if (selectedItem.equals("Circle")) {
                double radius = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                return new Circle(nameofShapeTextField.getText(), radius);
            } else if (selectedItem.equals("Triangle")) {
                double side1 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                double side2 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 5));
                double side3 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 7));
                return new Triangle(nameofShapeTextField.getText(), side1, side2, side3);
            } else if (selectedItem.equals("Square")) {
                double side = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                return new Square(nameofShapeTextField.getText(), side);
            } else if (selectedItem.equals("Rectangle")) {
                double side1 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                double side2 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 5));
                return new Rectangle(nameofShapeTextField.getText(), side1, side2);
            } else {
                throw null;
            }
        }

        private String getTextFromTextFieldAt(JPanel panel, int index) {
            if (panel.getComponent(index) instanceof JTextField) {
                return ((JTextField) panel.getComponent(index)).getText();
            }
            return "";
        }
    }

    public class ClearButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            shapeDescription.setText("");

            clearTextFieldsInPanel(inputsPanel);
            clearTextFieldsInPanel(resultsPanel);
        }
    }

    public class ExitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public void clearTextFieldsInPanel(JPanel panel) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JPanel) {
                clearTextFieldsInPanel((JPanel) component);
            }
        }
    }
}
