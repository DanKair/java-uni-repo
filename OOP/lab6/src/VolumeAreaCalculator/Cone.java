package VolumeAreaCalculator;

public class Cone extends Figure{
    private int radius;
    private int height;

    // Constructor
    public Cone(String name, int radius, int height){
        super(name);
        setRadius(radius);
        setHeight(height);
    }

    // Setter method to handle invalid inputs
    public void setRadius(int radius){
        if (radius > 0){
            this.radius = radius;
        }
        else{
            throw new IllegalArgumentException("Radius can't be negative or zero number");
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
        // TSA=πr²+πrl=πr(r+l), l - height
        double area = (double) Math.PI * this.radius * (this.radius + this.height);
        System.out.println("Total Surface Area of Cone: " + area);
    }

    @Override
    public void calculateVolume() {
       // 1/3πr²h
        double volume = (double) 1/3 * Math.PI * Math.pow(this.radius, 2) * this.height;
        System.out.println("Volume of Cone: " + volume);
    }
}
