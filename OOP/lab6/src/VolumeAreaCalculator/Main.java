package VolumeAreaCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Volume & Surface Area Calculator ---");
                System.out.println("Choose a shape:");
                System.out.println("1. Parallelepiped");
                System.out.println("2. Sphere");
                System.out.println("3. Cylinder");
                System.out.println("4. Cone");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();

                Figure shape = null;

                // Traditional switch statement for Java 11
                switch (choice) {
                    case 1:
                        System.out.print("Enter length: ");
                        int l = scanner.nextInt();
                        System.out.print("Enter width: ");
                        int w = scanner.nextInt();
                        System.out.print("Enter height: ");
                        int h = scanner.nextInt();
                        shape = new Parallelepiped("Parallelepiped", l, w, h);
                        break;
                    case 2:
                        System.out.print("Enter radius: ");
                        int r = scanner.nextInt();
                        shape = new Sphere("Sphere", r);
                        break;
                    case 3:
                        System.out.print("Enter radius: ");
                        int r2 = scanner.nextInt();
                        System.out.print("Enter height: ");
                        int h2 = scanner.nextInt();
                        shape = new Cylinder("Cylinder", r2, h2);
                        break;
                    case 4:
                        System.out.print("Enter radius: ");
                        int r3 = scanner.nextInt();
                        System.out.print("Enter height: ");
                        int h3 = scanner.nextInt();
                        shape = new Cone("Cone", r3, h3);
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        throw new IllegalArgumentException("Invalid shape selection!");
                }

                shape.calculateArea();
                shape.calculateVolume();

            } catch (InputMismatchException e) {
                System.out.println("Error: You must enter numbers only.");
                e.printStackTrace();
                scanner.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
