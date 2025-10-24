import java.util.Scanner;

public class PetyaCakes {
    public static void main(String[] args) {
        // Program Algorithm:
        // 1. Get guestNum
        // 2. n = guestNum + 1 (1 is Petya itself), if n == 0: no cuts needed, else: proceed to next step
        // 3. if n even: use diamter cuts, if odd: use radius cuts (n itself)
        // 4. diamterCuts = n / 2; radiusCuts = n;
        // 5. return radius or diameter cuts as min num of cuts

        System.out.print("Enter the number of guests: ");
        Scanner scanner = new Scanner(System.in);
        int guestsNum = Integer.valueOf(scanner.nextLine());
        int n = guestsNum + 1;
        int minCuts;
        String cutType;

        if (guestsNum < 0 || guestsNum <= 1000){
            if (n == 1) {
                minCuts = 0;
                cutType = "none";
            }
            else if (n % 2 == 0){
                minCuts = n / 2;
                cutType = "diameter";
            }
            else {
                minCuts = n;
                cutType = "radius";
            }
            System.out.println("Minimum number of cuts: " + minCuts);
            System.out.println("Type of cuts: " + cutType);
        }
        else {
            System.out.println("Guest numbers exceeded (must be between 0 and 1000)!");
        }




    }
}
