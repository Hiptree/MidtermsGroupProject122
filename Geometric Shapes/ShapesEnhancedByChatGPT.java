package dummy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapesEnhancedByChatGPT extends JFrame implements ActionListener {
    private JPanel shapePanel;
    private JComboBox<String> selectionList;

    public ShapesEnhancedByChatGPT() {
        setTitle("Shape Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Combo box for shape selection
        JLabel nameL = new JLabel("Select Shape");
        String[] list = {"Circle", "Triangle", "Square", "Rectangle"};
        selectionList = new JComboBox<>(list);
        selectionList.addActionListener(this);

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(nameL);
        topPanel.add(selectionList);

        add(topPanel, BorderLayout.NORTH);

        // Panel to hold shape-specific components
        shapePanel = new JPanel();
        shapePanel.setLayout(new GridLayout(12, 2));
        add(shapePanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ShapesEnhancedByChatGPT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedShape = (String) selectionList.getSelectedItem();
        resetShapePanel();
        if (selectedShape.equals("Circle")) {
            addCircleComponents();
        } else if (selectedShape.equals("Triangle")) {
            addTriangleComponents();
        } else if (selectedShape.equals("Square")) {
            addSquareComponents();
        } else if (selectedShape.equals("Rectangle")) {
            addRectangleComponents();
        }
        pack();
    }

    private void resetShapePanel() {
        shapePanel.removeAll();
        shapePanel.revalidate();
        shapePanel.repaint();
    }

    private void addCircleComponents() {
        JLabel radiusL = new JLabel("Radius:", SwingConstants.RIGHT);
        JTextField radiusTF = new JTextField(10);
        JButton calculateB = new JButton("Calculate");

        shapePanel.add(radiusL);
        shapePanel.add(radiusTF);
        shapePanel.add(calculateB);

        // Action listener for the Calculate button
        calculateB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform circle calculations here
            }
        });
    }

    private void addTriangleComponents() {
        JLabel side1L = new JLabel("Side 1:", SwingConstants.RIGHT);
        JTextField side1TF = new JTextField(10);
        JLabel side2L = new JLabel("Side 2:", SwingConstants.RIGHT);
        JTextField side2TF = new JTextField(10);
        JLabel side3L = new JLabel("Side 3:", SwingConstants.RIGHT);
        JTextField side3TF = new JTextField(10);
        JButton calculateB = new JButton("Calculate");

        shapePanel.add(side1L);
        shapePanel.add(side1TF);
        shapePanel.add(side2L);
        shapePanel.add(side2TF);
        shapePanel.add(side3L);
        shapePanel.add(side3TF);
        shapePanel.add(calculateB);

        // Action listener for the Calculate button
        calculateB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform triangle calculations here
            }
        });
    }

    private void addSquareComponents() {
        JLabel sideL = new JLabel("Side:", SwingConstants.RIGHT);
        JTextField sideTF = new JTextField(10);
        JButton calculateB = new JButton("Calculate");

        shapePanel.add(sideL);
        shapePanel.add(sideTF);
        shapePanel.add(calculateB);

        // Action listener for the Calculate button
        calculateB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform square calculations here
            }
        });
    }

    private void addRectangleComponents() {
        JLabel lengthL = new JLabel("Length:", SwingConstants.RIGHT);
        JTextField lengthTF = new JTextField(10);
        JLabel widthL = new JLabel("Width:", SwingConstants.RIGHT);
        JTextField widthTF = new JTextField(10);
        JButton calculateB = new JButton("Calculate");

        shapePanel.add(lengthL);
        shapePanel.add(lengthTF);
        shapePanel.add(widthL);
        shapePanel.add(widthTF);
        shapePanel.add(calculateB);

        // Action listener for the Calculate button
        calculateB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform rectangle calculations here
            }
        });
    }
}
