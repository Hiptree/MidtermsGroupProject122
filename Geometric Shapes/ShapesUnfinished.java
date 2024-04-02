package dummy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ShapesUnfinished extends JFrame {
    private JLabel sideL, side1L, side2L, side3L, radiusL, perimeterL, areaL, nameL, selectedShapeL;
    private JTextField sideTF, side1TF, side2TF, side3TF, radiusTF, perimeterTF, areaTF, nameTF;
    private JButton calculateCircleB,clearB,exitB, calculateTriangleB, calculateSquareB, calculateRectangleB;
    private JComboBox selectionList;
    private CalculateCircleButtonHandler calculateCircleHandler;
    private CalculateTriangleButtonHandler calculateTriangleHandler;
    private CalculateSquareButtonHandler calculateSquareHandler;
    private CalculateRectangleButtonHandler calculateRectangleHandler;


    public static void main(String[] args){
        ShapesUnfinished myProgram = new ShapesUnfinished();
        try{
            myProgram.run();
        }catch (Exception x){
            x.printStackTrace();
        }
    }

    public void run(){
        //insert here combo box
        nameL = new JLabel("Select Shape");
        selectedShapeL = new JLabel();
        String [] list = {"Circle" , "Triangle", "Square", "Rectangle"};
        selectionList = new JComboBox(list);
        Container selection = getContentPane();
        selection.setLayout(new GridLayout(12,4));
        selection.add(nameL);
        selection.add(selectionList);
        selection.add(selectedShapeL);
        if (selectedShapeL.equals("Circle ")){
            radiusL = new JLabel("Radius", SwingConstants.RIGHT);
            radiusTF = new JTextField(10);
            perimeterL = new JLabel("Perimeter", SwingConstants.RIGHT);
            perimeterTF = new JTextField(10);
            areaL = new JLabel("Area", SwingConstants.RIGHT);
            areaTF = new JTextField(10);
            calculateCircleB = new JButton("Calculate");
            calculateCircleHandler = new CalculateCircleButtonHandler();
            calculateCircleB.addActionListener(calculateCircleHandler);
            //insert here clear button
//            insert here exit button
            Container circle = getContentPane();
            circle.setLayout(new GridLayout(4, 2));

            selection.add(areaL);
            selection.add(areaTF);
            circle.add(calculateCircleB);
            //add clear button
            //add exit button
            setVisible(true);
        } else if (selectedShapeL.equals("Triangle")){
            calculateTriangle();
        } else if (selectedShapeL.equals("Square")){
            calculateSquare();
        } else if (selectedShapeL.equals("Rectangle")){
            calculateRectangle();
        }
        setSize(1000, 1000);
        setVisible(true);
    }
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == selectionList) {
           selectedShapeL.setText(selectionList.getSelectedItem()+"");
        }
    }

    public void calculateCircle(){
        radiusL = new JLabel("Radius", SwingConstants.RIGHT);
        radiusTF = new JTextField(10);
        perimeterL = new JLabel("Perimeter", SwingConstants.RIGHT);
        perimeterTF = new JTextField(10);
        areaL = new JLabel("Area", SwingConstants.RIGHT);
        areaTF = new JTextField(10);
        calculateCircleB = new JButton("Calculate");
        calculateCircleHandler = new CalculateCircleButtonHandler();
        calculateCircleB.addActionListener(calculateCircleHandler);
        //insert here clear button
        //insert here exit button
        Container circle = getContentPane();
        circle.setLayout(new GridLayout(4, 2));
        circle.add(radiusL);
        circle.add(radiusTF);
        circle.add(perimeterL);
        circle.add(perimeterTF);
        circle.add(areaL);
        circle.add(areaTF);
        circle.add(calculateCircleB);
        //add clear button
        //add exit button
        setVisible(true);
    }
    public void calculateTriangle() {
        side1L = new JLabel("Side 1", SwingConstants.RIGHT);
        side1TF = new JTextField(10);
        side2L = new JLabel("Side 2", SwingConstants.RIGHT);
        side2TF = new JTextField(10);
        side3L = new JLabel("Side 3", SwingConstants.RIGHT);
        side3TF = new JTextField(10);
        perimeterL = new JLabel("Perimeter", SwingConstants.RIGHT);
        perimeterTF = new JTextField(10);
        areaL = new JLabel("Area");
        areaTF = new JTextField(10);
        calculateTriangleB = new JButton("Calculate");
        calculateTriangleHandler = new CalculateTriangleButtonHandler();
        calculateCircleB.addActionListener(calculateTriangleHandler);
        //insert here clear button
        //insert here exit button
        Container triangle = getContentPane();
        triangle.setLayout(new GridLayout(7, 2));
        triangle.add(side1L);
        triangle.add(side1TF);
        triangle.add(side2L);
        triangle.add(side2TF);
        triangle.add(side3L);
        triangle.add(side3TF);
        triangle.add(perimeterL);
        triangle.add(perimeterTF);
        triangle.add(areaL);
        triangle.add(areaTF);
        triangle.add(calculateTriangleB);
        //add clear button
        //add exit button
    }
    public void calculateSquare(){
        sideL = new JLabel("Side", SwingConstants.RIGHT);
        sideTF = new JTextField(10);
        perimeterL = new JLabel("Perimeter", SwingConstants.RIGHT);
        perimeterTF = new JTextField(10);
        areaL = new JLabel("Area");
        areaTF = new JTextField(10);
        calculateSquareB = new JButton("Calculate");
        calculateSquareHandler = new CalculateSquareButtonHandler();
        calculateSquareB.addActionListener(calculateSquareHandler);
        //insert here clear button
        //insert here exit button
        Container circle = getContentPane();
        circle.setLayout(new GridLayout(4, 2));
        circle.add(radiusL);
        circle.add(radiusTF);
        circle.add(perimeterL);
        circle.add(perimeterTF);
        circle.add(areaL);
        circle.add(areaTF);
        circle.add(calculateCircleB);
        //add clear button
        //add exit button
    }

    public void calculateRectangle() {
        sideL = new JLabel("Side", SwingConstants.RIGHT);
        sideTF = new JTextField(10);
        perimeterL = new JLabel("Perimeter", SwingConstants.RIGHT);
        perimeterTF = new JTextField(10);
        areaL = new JLabel("Area");
        areaTF = new JTextField(10);
        calculateRectangleB = new JButton("Calculate");
        calculateRectangleHandler = new CalculateRectangleButtonHandler();
        calculateRectangleB.addActionListener(calculateRectangleHandler);
        //insert here clear button
        //insert here exit button
        Container circle = getContentPane();
        circle.setLayout(new GridLayout(4, 2));
        circle.add(radiusL);
        circle.add(radiusTF);
        circle.add(perimeterL);
        circle.add(perimeterTF);
        circle.add(areaL);
        circle.add(areaTF);
        circle.add(calculateCircleB);
        //add clear button
        //add exit button
        setSize(100, 100);
        setVisible(true);
    }
    private class CalculateCircleButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //perimeter calculation
            //area calculation
            perimeterTF.setText("");
            areaTF.setText("");
        }
    }
    private class CalculateTriangleButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //perimeter calculation
            //area calculation
            perimeterTF.setText("");
            areaTF.setText("");
        }
    }
    private class CalculateSquareButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //perimeter calculation
            //area calculation
            perimeterTF.setText("");
            areaTF.setText("");
        }
    }
    private class CalculateRectangleButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //perimeter calculation
            //area calculation
            perimeterTF.setText("");
            areaTF.setText("");
        }
    }
} // end of ArithmeticCalculatorG class
