package figures;

public class Rectangle extends Figure{
    private int width;
    private int height;

    public Rectangle(String name, String color, int width, int height){
        super(name, color);
        // Setter Validation
        setWidth(width);
        setHeight(height);
    }

    // Setter methods with validation
    public void setWidth(int width){
        if (width > 0){
            this.width = width;
        }
        else{
            throw new IllegalArgumentException("Width can't be negative or zero number");
        }
    }

    public void setHeight(int height){
        if (width > 0){
            this.height = height;
        }
        else{
            throw new IllegalArgumentException("Height can't be negative or zero number");
        }
    }

    // Getter methods
    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }


    public int area(){
        // Area = width * height
        return this.getHeight() * this.getWidth();
    }

    public void perimeter(){
        // Perimeter = 2 * (w+h)
        double perimeter = 2 * (this.getHeight() + this.getWidth());
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }
}
