import java.util.InputMismatchException;
import  java.util.Scanner;

public class Menu2 {

    public static void displayMenu(int options[], String menuItems []){ //passing in the Menu data arrays
        //Display Menu
        System.out.println("--------");
        System.out.println("M E N U");
        System.out.println("--------");

        //Loop through the Menu data options and menuItems
        //Note* the options/menu item arrays are the same size
        for(int i = 0; i < options.length; i++){
            System.out.printf("%d. %s\n", options[i], menuItems[i]);  //printf to format the string better - %d is the placeholder for an int and %s is the placeholder for string - \n = newline
        }

        System.out.println("===================");
        System.out.print("Enter choice: "); //didn't use a println so the input can be on the same line

    }

    public static void main(String[] args) {
        //Setup Scanner
        Scanner scanner = new Scanner(System.in);

        //User Choice
        int choice;

        //Menu data - stored in an array so we are not hard coding the displayed menu
        int options[] = {1,2,3,4};
        String menuItems [] = {"Spring Water", "Cherry Pepsi", "Orange Juice", "Exit"};

        //Display Menu
        displayMenu(options, menuItems); // passing in the two arrays to the display menu to compliment the loop we added to the display menu method

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
            displayMenu(options, menuItems); // passing in the two arrays to the display menu to compliment the loop we added to the display menu method


            //Get User Choice Again
            choice = scanner.nextInt();

        }
        System.out.println("Goodbye and Come Again!");

    }
}

