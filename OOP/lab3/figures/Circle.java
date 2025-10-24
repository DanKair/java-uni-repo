package figures;

public class Circle extends Figure{
    private int radius;

    public Circle(String name, String color, int radius){
        super(name, color);
        setRadius(radius);
    }

    // Setter method with validation
    public void setRadius(int radius){
        if (radius > 0){
            this.radius = radius;
        }
        else{
            throw new IllegalArgumentException("Radius can't be negative or zero number");
        }
    }

    // Getter method
    public int getRadius(){
        return this.radius;
    }

    public void area(){
        // Area = пr^2
        double result = Math.PI * (double) Math.pow(radius, 2);
        System.out.println("Area of Circle: " + result);
    }

    public void perimeter(){
        double result = 2 * Math.PI * (double) radius;
        System.out.println("Perimeter of Circle: " + result);
    }
}
