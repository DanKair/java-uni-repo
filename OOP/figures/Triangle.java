package figures;

public class Triangle extends Figure{
private int base;
    private int height;

    public Triangle(String name, String color, int base, int height){
        super(name, color);
        // Setter Validation
        setBase(base);
        setHeight(height);
    }

    // Setter methods with validation
    public void setBase(int base){
        if (base > 0){
            this.base = base;
        }
        else{
            throw new IllegalArgumentException("Base can't be negative or zero number");
        }
    }

    public void setHeight(int height){
        if (height > 0){
            this.height = height;
        }
        else{
            throw new IllegalArgumentException("Height can't be negative or zero number");
        }
    }

    // Getter methods
    public int getBase(){
        return this.base;
    }

    public int getHeight(){
        return this.height;
    }


    public void area(){
        // Area = 1/2 * base * height
        double area = (double) 0.5 * this.getBase() * this.getHeight();
        System.out.println("Area of Triangle: " + area);
    }

    public void perimeter(){
        // Perimeter = (w+h) + Math.sqrt(w^2+h^2)
        double squaredSumOfHeightAndWidth = Math.pow(base, 2) + Math.pow(height, 2);
        double perimeter = (double) (this.getHeight() + this.getBase()) + Math.sqrt(squaredSumOfHeightAndWidth);
        System.out.println("Perimeter of Triangle: " + perimeter);
    }
}
