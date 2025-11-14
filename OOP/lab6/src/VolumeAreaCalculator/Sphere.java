package VolumeAreaCalculator;

public class Sphere extends Figure{
    private int radius;

    // Constructor
    public Sphere(String name, int radius){
        super(name);
        setRadius(radius);
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

    @Override
    public void calculateVolume() {
        //  V= 4/3πr³
        double volume = (double) 4 / 3 * Math.PI * Math.pow(this.radius, 3);
        System.out.println("Volume of the Sphere: " + volume);
    }

    @Override
    public void calculateArea() {
        // A=4πr²
        double area = (double) 4 * Math.PI * Math.pow(this.radius, 2);
        System.out.println("Surface Area of Sphere: " + area);
    }
}
