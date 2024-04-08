package mexer2.prog2.edu.slu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The Tester class is a GUI application that allows the user to calculate the area and
 * perimeter of different shapes.
 *
 * @author Gerard Bernados
 * @author Mike Fajardo
 */
public class Tester {
    private JFrame frame;
    private JPanel dropdownPanel, inputsPanel, resultsPanel, buttonsPanel;
    private JComboBox dropdown;
    private JLabel nameOfShapeLabel, noShapeSelectedLabel, shapeDescription, areaLabel, perimeterLabel;
    private JTextField nameOfShapeTextField, areaTextField, perimeterTextField;
    private JButton calculateButton, clearButton, exitButton;
    private DropdownHandler dropdownHandler;
    private ClearButtonHandler clearButtonHandler;
    private CalculateButtonHandler calculateButtonHandler;
    private ExitButtonHandler exitButtonHandler;

    /**
     * Constructor for the Tester class.
     * Initializes the GUI components and sets up the layout of the GUI.
     *
     * @author Gerard Bernados
     * @author Mike Fajardo
     */
    public Tester() {
        frame = new JFrame();

        dropdownPanel = new JPanel();
        dropdownPanel.setPreferredSize(new Dimension(300, 40));
        dropdownPanel.setMaximumSize(dropdownPanel.getPreferredSize());

        String[] choices = {"Select a shape", "Circle", "Triangle", "Square", "Rectangle"};
        dropdown = new JComboBox<>(choices);
        dropdownPanel.add(dropdown);
        dropdownHandler = new DropdownHandler();
        dropdown.addActionListener(dropdownHandler);

        inputsPanel = new JPanel();
        inputsPanel.setPreferredSize(new Dimension(300, 150));
        inputsPanel.setLayout(new GridLayout(4, 2));

        noShapeSelectedLabel = new JLabel("Please select a shape.");
        noShapeSelectedLabel.setHorizontalAlignment(JLabel.CENTER);
        inputsPanel.add(noShapeSelectedLabel);

        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.PAGE_AXIS));

        JPanel nameOfShapeAndNumOfSidesPanel = new JPanel();
        nameOfShapeAndNumOfSidesPanel.setPreferredSize(new Dimension(300, 95));
        nameOfShapeAndNumOfSidesPanel.setBorder(BorderFactory.createEmptyBorder(15, 5, 5, 15));

        shapeDescription = new JLabel("");
        nameOfShapeAndNumOfSidesPanel.add(shapeDescription);

        JPanel resultsWithLabelAndTextFieldPanel = new JPanel();
        resultsWithLabelAndTextFieldPanel.setPreferredSize(new Dimension(300, 100));
        resultsWithLabelAndTextFieldPanel.setLayout(new GridLayout(2, 2));

        areaLabel = new JLabel("Area:");
        areaLabel.setHorizontalAlignment(JLabel.RIGHT);
        areaTextField = new JTextField(10);
        areaTextField.setEditable(false);

        perimeterLabel = new JLabel("Perimeter:");
        perimeterLabel.setHorizontalAlignment(JLabel.RIGHT);
        perimeterTextField = new JTextField(10);
        perimeterTextField.setEditable(false);

        resultsWithLabelAndTextFieldPanel.add(areaLabel);
        resultsWithLabelAndTextFieldPanel.add(areaTextField);
        resultsWithLabelAndTextFieldPanel.add(perimeterLabel);
        resultsWithLabelAndTextFieldPanel.add(perimeterTextField);

        resultsPanel.add(nameOfShapeAndNumOfSidesPanel);
        resultsPanel.add(resultsWithLabelAndTextFieldPanel);

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

        frame.add(dropdownPanel);
        frame.add(inputsPanel);
        frame.add(resultsPanel);
        frame.add(buttonsPanel);

        frame.setTitle("Shape Calculator");
        frame.setSize(300, 440);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     *
     *
     * @author Gerard Bernados
     */
    private class DropdownHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedShape = (String) dropdown.getSelectedItem();

            resetInputsPanel();
            shapeDescription.setText("");
            perimeterLabel.setText("Perimeter:");
            clearTextFieldsInPanel(resultsPanel);

            if (selectedShape != "Please select a shape.") {
                if (selectedShape.equals("Circle")) {
                    addCircleComponents();
                    perimeterLabel.setText("Circumference:");
                } else if (selectedShape.equals("Triangle")) {
                    addTriangleComponents();
                } else if (selectedShape.equals("Square")) {
                    addSquareComponents();
                } else if (selectedShape.equals("Rectangle")) {
                    addRectangleComponents();
                } else {
                    inputsPanel.removeAll();
                    inputsPanel.add(noShapeSelectedLabel);
                }
            }
        }

        /**
         *
         *
         * @author Gerard Bernados
         */
        private void resetInputsPanel() {
            inputsPanel.removeAll();
            inputsPanel.revalidate();
            inputsPanel.repaint();
        }

        /**
         *
         *
         * @author Gerard Bernados
         */
        private void addCircleComponents() {
            inputsPanel.setLayout(new GridLayout(1 + 1, 2));

            nameOfShapeLabel = new JLabel("Enter name:", SwingConstants.RIGHT);
            nameOfShapeTextField = new JTextField(10);
            JLabel radiusLabel = new JLabel("Enter radius:", SwingConstants.RIGHT);
            JTextField radiusTextField = new JTextField(10);

            inputsPanel.add(nameOfShapeLabel);
            inputsPanel.add(nameOfShapeTextField);
            inputsPanel.add(radiusLabel);
            inputsPanel.add(radiusTextField);
        }

        /**
         *
         *
         * @author Gerard Bernados
         */
        private void addTriangleComponents() {
            inputsPanel.setLayout(new GridLayout(3 + 1, 2));

            nameOfShapeLabel = new JLabel("Enter name:", SwingConstants.RIGHT);
            nameOfShapeTextField = new JTextField(10);

            inputsPanel.add(nameOfShapeLabel);
            inputsPanel.add(nameOfShapeTextField);

            for (int i = 0; i < 3; i++) {
                JLabel sideLabel = new JLabel("Enter side " + (i + 1) + ":", SwingConstants.RIGHT);
                JTextField sideTextField = new JTextField(10);

                inputsPanel.add(sideLabel);
                inputsPanel.add(sideTextField);
            }
        }

        /**
         *
         *
         * @author Gerard Bernados
         */
        private void addSquareComponents() {
            inputsPanel.setLayout(new GridLayout(1 + 1, 2));

            nameOfShapeLabel = new JLabel("Enter name:", SwingConstants.RIGHT);
            nameOfShapeTextField = new JTextField(10);
            JLabel sideLabel = new JLabel("Enter side:", SwingConstants.RIGHT);
            JTextField sideTextField = new JTextField(10);

            inputsPanel.add(nameOfShapeLabel);
            inputsPanel.add(nameOfShapeTextField);
            inputsPanel.add(sideLabel);
            inputsPanel.add(sideTextField);
        }

        /**
         *
         *
         * @author Gerard Bernados
         */
        private void addRectangleComponents() {
            inputsPanel.setLayout(new GridLayout(2 + 1, 2));

            nameOfShapeLabel = new JLabel("Enter name:", SwingConstants.RIGHT);
            nameOfShapeTextField = new JTextField(10);

            inputsPanel.add(nameOfShapeLabel);
            inputsPanel.add(nameOfShapeTextField);

            for (int i = 0; i < 2; i++) {
                JLabel sideLabel = new JLabel("Enter side " + (i + 1) + ":", SwingConstants.RIGHT);
                JTextField sideTextField = new JTextField(10);

                inputsPanel.add(sideLabel);
                inputsPanel.add(sideTextField);
            }
        }
    }

    /**
     * Handles the action event of the Calculate button.
     *
     * @author Mike Fajardo
     */
    public class CalculateButtonHandler implements ActionListener {
        /**
         * Creates the selected shape and calculates its area and perimeter.
         * If the area or perimeter is negative, it displays an error message and clears the results.
         * If the shape is a triangle and its sides do not form a valid triangle, it displays an error message and clears the results.
         * Otherwise, it displays the shape's description, area, and perimeter.
         */
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

        /**
         * Creates a shape based on the selected item in the dropdown.
         * It parses the text fields in the inputs panel to get the parameters for the shape.
         * If the selected item is "Circle", it creates a Circle with the entered radius.
         * If the selected item is "Triangle", it creates a Triangle with the entered sides.
         * If the selected item is "Square", it creates a Square with the entered side.
         * If the selected item is "Rectangle", it creates a Rectangle with the entered sides.
         *
         * @author Mike Fajardo
         */
        private Shape createShape(String selectedItem) throws NumberFormatException {
            if (selectedItem.equals("Circle")) {
                double radius = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                return new Circle(nameOfShapeTextField.getText(), radius);
            } else if (selectedItem.equals("Triangle")) {
                double side1 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                double side2 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 5));
                double side3 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 7));
                return new Triangle(nameOfShapeTextField.getText(), side1, side2, side3);
            } else if (selectedItem.equals("Square")) {
                double side = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                return new Square(nameOfShapeTextField.getText(), side);
            } else if (selectedItem.equals("Rectangle")) {
                double side1 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 3));
                double side2 = Double.parseDouble(getTextFromTextFieldAt(inputsPanel, 5));
                return new Rectangle(nameOfShapeTextField.getText(), side1, side2);
            } else {
                throw null;
            }
        }

        /**
         * This method gets the text from the text field at the specified index in the given panel.
         * If the component at the index is a JTextField, it returns its text.
         * Otherwise, it returns an empty string.
         *
         * @author Mike Fajardo
         */
        private String getTextFromTextFieldAt(JPanel panel, int index) {
            if (panel.getComponent(index) instanceof JTextField) {
                return ((JTextField) panel.getComponent(index)).getText();
            }
            return "";
        }
    }

    /**
     * Handles the action event of the Clear button.
     *
     * @author Mike Fajardo
     */
    public class ClearButtonHandler implements ActionListener {
        /**
         * Sets the text of the shape description to an empty string and
         * clears the text fields in the inputs and results panels.
         */
        public void actionPerformed(ActionEvent e) {
            shapeDescription.setText("");

            clearTextFieldsInPanel(inputsPanel);
            clearTextFieldsInPanel(resultsPanel);
        }
    }

    /**
     * Handles the action event of the Exit button.
     *
     * @author Mike Fajardo
     */
    public class ExitButtonHandler implements ActionListener {
        /**
         * Terminates the program when the exit button is clicked.
         */
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * This method is used to clear the text fields in a given JPanel.
     * It iterates over each component in the panel. If the component is a JTextField,
     * it sets the text of the field to an empty string. If the component is a JPanel,
     * it recursively calls itself to clear the text fields in the nested panel.
     *
     * @author Mike Fajardo
     */
    public void clearTextFieldsInPanel(JPanel panel) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof JPanel) {
                clearTextFieldsInPanel((JPanel) component);
            }
        }
    }

    public static void main(String[] args) {
        new Tester();
    }
}
