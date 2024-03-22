// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Triangle extends Shape{
    //instantiates the 
    private double side1;
    private double side2;
    private double side3;
    
    public Triangle (String name, double s1, double s2, double s3){
        super(name);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }


    public double area(){
        double s = (side1 + side2 + side3)/2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
        
      
    
    public double perimeter(){
        return side1 + side2 + side3;
    }
    
}//end of class
