// Online Java Compiler
// Use this editor to write, compile and run your Java code online
/*
Author: Cariaga Lance Kenneth G.
*/


public class Triangle extends Shape{
    //instantiates the sides
    private double side1;
    private double side2;
    private double side3;

    //parameterized constructor
    public Triangle (String name, double s1, double s2, double s3){
        super(name);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }


//method responsible for calculating the area
    public double area(){
        double s = (side1 + side2 + side3)/2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
        

 //method responsible for calculating the perimeter   
    public double perimeter(){
        return side1 + side2 + side3;
    }
    
}//end of class
