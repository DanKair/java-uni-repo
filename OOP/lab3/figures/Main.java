package figures;

public class Main {
    public static void main(String[] args) {
        // Rectangle Class Interface
        Rectangle rect1 = new Rectangle("Rectangle", "Blue", 5, 4);
        System.out.println("Area of Rectangle: " + rect1.area());
        rect1.perimeter();
        
        Rectangle rect2 = new Rectangle("Rectangle", "Red", 0, 0);
        System.out.println("Area of Rectangle: " + rect2.area());

        
    }
}
