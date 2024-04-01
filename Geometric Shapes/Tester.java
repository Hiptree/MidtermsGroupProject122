public class Tester {
  private JButton calculateButton, clearButton, exitButton;
  private CalculateButtonHandler calculateButtonHandler;
  private ClearButtonHandler clearButtonHandler;
  private ExitButtonHandler exitButtonHandler;

  public class CalculateButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Shape shape = createShape((String) dropdown.getSelectedItem());

                shapeDescription.setText(shape.toString());
                areaTextField.setText(Double.toString(shape.area()));
                perimeterTextField.setText(Double.toString(shape.perimeter()));
            } catch (NumberFormatException nfe) {
                shapeDescription.setText("Please enter numbers only.");
                clearTextFieldsInPanel(resultsPanel);
            } catch (Exception exception) {
                shapeDescription.setText("");
            }
        }

        private Shape createShape(String selectedItem) throws NumberFormatException, Exception {
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
                throw new Exception();
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
