package VolumeAreaCalculator;

public class Cylinder extends Figure{
    private int radius;
    private int height;

    public Cylinder(String name, int radius, int height){
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
        //  TSA=2πr(r+h) or TSA=2πr²+2πrh
        double area = (double) 2 * Math.PI * this.radius * (this.radius + this.height);
        System.out.println("Total Surface Area of Cylinder: " + area);
    }

    @Override
    public void calculateVolume() {
        // V=πr²h
        double volume = (double) Math.PI * this.height * Math.pow(this.radius, 2);
        System.out.println("Volume of Cylinder: " + volume);
    }
}
