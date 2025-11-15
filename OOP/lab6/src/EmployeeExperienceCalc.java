import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeExperienceCalc {

    // Method to calculate the age based on birth year
    public static int calculateAge(int birthYear) {
        int currentYear = 2025;
        return currentYear - birthYear;
    }

    // Method to validate if a name contains only alphabets
    public static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z]+");
    }

    // Method to validate the year input (whether it's numeric and in the correct range)
    public static boolean isValidYear(int year) {
        int currentYear = 2025; // You can dynamically fetch the current year if required
        return year <= currentYear && year > 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = "";
        String lastName = "";
        int birthYear = 0;
        int employmentStartYear = 0;

        try {
            // Input first name and validate
            System.out.print("Enter First Name: ");
            firstName = scanner.nextLine();
            if (!isValidName(firstName)) {
                throw new IllegalArgumentException("First Name must contain only letters!");
            }

            // Input last name and validate
            System.out.print("Enter Last Name: ");
            lastName = scanner.nextLine();
            if (!isValidName(lastName)) {
                throw new IllegalArgumentException("Last Name must contain only letters!");
            }

            // Input birth year and validate
            System.out.print("Enter Year of Birth: ");
            birthYear = scanner.nextInt();
            if (!isValidYear(birthYear)) {
                throw new IllegalArgumentException("Year of Birth is either invalid or in the future!");
            }

            // Input employment start year and validate
            System.out.print("Enter Year of Employment Start: ");
            employmentStartYear = scanner.nextInt();
            if (!isValidYear(employmentStartYear)) {
                throw new IllegalArgumentException("Year of Employment Start is either invalid or in the future!");
            }

            // Calculate age and validate employment start year (must be at least 18)
            int age = calculateAge(birthYear);
            if (age < 18) {
                throw new IllegalArgumentException("Employee must be at least 18 years old to start working!");
            }

            if (employmentStartYear < birthYear + 18) {
                throw new IllegalArgumentException("Employee cannot start work before turning 18!");
            }

            // Calculate work experience
            int workExperience = 2025 - employmentStartYear;

            // Output employee info and experience
            System.out.println("\nEmployee Information:");
            System.out.println("Name: " + firstName + " " + lastName);
            System.out.println("Age: " + age);
            System.out.println("Total Work Experience: " + workExperience + " years");

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input type! Please enter numeric values for years.");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
