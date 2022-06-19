import java.util.InputMismatchException;
import  java.util.Scanner;

public class Menu2 {

    public static void main(String[] args) {
        //Setup Scanner
        Scanner scanner = new Scanner(System.in);

        //User Choice
        int choice;

        //Display Menu
        System.out.println("--------");
        System.out.println("M E N U");
        System.out.println("--------");
        System.out.println("1. Spring Water");
        System.out.println("2. Cherry Pepsi");
        System.out.println("3. Orange Juice");
        System.out.println("4. Exit");
        System.out.println("===================");
        System.out.print("Enter choice: "); //didn't use a println so the input can be on the same line

        //Get choice from user
        choice = scanner.nextInt();

        //Menu Loop - this would be a separate method

        while(choice !=4){
            //Check the Choice Value
            if (choice == 1) {
                System.out.println("Spring Water");
            } else if (choice == 2) {
                System.out.println("Cherry Pepsi");
            } else if (choice == 3) {
                System.out.println("Orange Juice");
            } // You don't need the else if 4 choice because it would automatically end

            //Display Menu Again (This should also be a method...this code is not dry)
            //a try catch would be here for wrong inputs as well as a do while, if it was a method

            System.out.println("--------");
            System.out.println("M E N U");
            System.out.println("--------");
            System.out.println("1. Spring Water");
            System.out.println("2. Cherry Pepsi");
            System.out.println("3. Orange Juice");
            System.out.println("4. Exit");
            System.out.println("===================");
            System.out.print("Enter choice: "); //didn't use a println so the input can be on the same line

            //Get User Choice Again
            choice = scanner.nextInt();

        }
        System.out.println("Goodbye and Come Again!");

    }
}

