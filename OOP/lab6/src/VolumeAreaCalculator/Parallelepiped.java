package VolumeAreaCalculator;

public class Parallelepiped extends Figure{
    private int length;
    private int width;
    private int height;

    // Constructor
    public Parallelepiped(String name, int length, int width, int height){
        // Calling parent (Abstract) class method and passing name as parameter
        super(name);
        // Calling setter methods with input validation
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    // Setter methods with validation
    public void setLength(int length){
        if (length > 0){
            this.length = length;
        }
        else{
            throw new IllegalArgumentException("Length can't be negative or zero number");
        }
    }

    public void setWidth(int width){
        if (width > 0){
            this.width = width;
        }
        else{
            throw new IllegalArgumentException("Width can't be negative or zero number");
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

    @Override
    public void calculateArea() {
        // For a rectangular parallelepiped, the total surface area is given by the formula TSA=2(lw+lh+wh)
        double area = (double) 2 * (this.length * this.width + this.length * this.height + this.width * this.height);
        System.out.println("Total Surface Area of Parallelepiped: " + area);
    }

    @Override
    public void calculateVolume() {
        double volume = (double) this.length * this.height * this.width;
        System.out.println("Volume of Parallelepiped: " + volume);
    }
}
