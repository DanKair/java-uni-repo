import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    public String name;
    public double salary;
    public String role;
    // Would be used to store Employees in the list and manipulate them using sorting / searching techniques
    private static ArrayList<Employee> employees = new ArrayList<>();

    // Parametrized Constructor
    public Employee(String name, double salary, String role){
        this.name = name;
        this.salary = salary;
        this.role = role;
        // Add the newly created employee to the shared list
        employees.add(this);
    }

    public boolean hasHigherSalary(Employee anotherEmployee){
        if (this.salary > anotherEmployee.salary){
            return true;
        }
        return false;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static double getHighestSalary() {
        // Algorithm Logic:
        // 0. Traverse through the list
        // 1. Assume that first item in the list is highest (max = employees[0])
        // 2. Compare current item with first item
        // 3. if employee[i].salary > max.salary: max = current.salary
        Employee max = employees.get(0);
        for (Employee employee : employees) {
            if (employee.salary > max.salary) {
                max = employee;
            }
        }
        return max.salary;
    }

    public static double getLowestSalary() {
        // Algorithm Logic:
        // 0. Traverse through the list
        // 1. Assume that first item in the list is lowest (min = employees[0])
        // 2. Compare current item with first item
        // 3. if employee[i].salary < min.salary: update min_salary
        Employee min = employees.get(0);
        for (Employee employee : employees) {
            if (employee.salary < min.salary) {
                min = employee;
            }
        }
        return min.salary;
    }

    public static void getHighestSalaryEmployee() {
        // Algorithm Logic:
        // 0. Traverse through the list
        // 1. Assume that first item in the list is highest (max = employees[0])
        // 2. Compare current item with first item
        // 3. if employee[i].salary > max.salary: max = current.salary
        Employee max = employees.get(0);
        for (Employee employee: employees){
            if (employee.salary > max.salary){
                max = employee;
            }
        };
        System.out.println("Employee with highest salary: " + max.name + ", earning: $" + max.salary);
    }

    public static void getLowestSalaryEmployee() {
        // Algorithm Logic:
        // 0. Traverse through the list
        // 1. Assume that first item in the list is lowest (min = employees[0])
        // 2. Compare current item with first item
        // 3. if employee[i].salary < min.salary: update min_salary
        Employee min = employees.get(0);
        for (Employee employee : employees) {
            if (employee.salary < min.salary) {
                min = employee;
            }
        }
        System.out.println("Employee with lowest salary: " + min.name + ", earning: $" + min.salary);
    }

    public static void getSalaryDifference(){
        double difference = getHighestSalary() - getLowestSalary();
        System.out.println("Difference between Highest Salary and Lowest Salary: $" + difference);
    }

    // String Representation of Object for Prettier Formatting
    public String toString() {
        return "Employee: " + this.name + "\nRole: " + this.role + "\nEarns: $" + this.salary;
    }

    public static void createEmployees(){
        // 1. Get number of objects user wanna create
        // 2. Iterate till that number
        // 3. Ask for object's property parametrs
        // 4. Create new object each iteration with following userInput attributes
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how much employees you wanna create: ");
        int n = Integer.valueOf(scanner.nextLine());

        // Main logic is here --->
        for (int i = 0; i < n; i++){
            System.out.print("Enter the employee's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter the employee's salary: ");
            int salary = Integer.valueOf(scanner.nextLine());
            System.out.print("Enter the employee's role: ");
            String role = scanner.nextLine();
            // Create new object each iteration
            Employee employee = new Employee(name, salary, role);
        }
    }

    public static void main(String[] args) {
        createEmployees();
        Employee.getHighestSalaryEmployee();
        Employee.getLowestSalaryEmployee();
        Employee.getSalaryDifference();

    }
}
