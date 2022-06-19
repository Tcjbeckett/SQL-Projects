import java.util.InputMismatchException;
import  java.util.Scanner;

public class Menu2 {

    public static void displayMenu(int options[], String menuItems [], double prices []){ //passing in the Menu data arrays AND the prices
        //Display Menu
        System.out.println("--------");
        System.out.println("M E N U");
        System.out.println("--------");

        //Loop through the Menu data options and menuItems
        //Note* the options/menu item arrays are the same size
        for(int i = 0; i < options.length-1; i++){ //changed the loop to leave the last one out bc the prices is not the same size and exit will be a special case
            //printf to format the string better - %d is the placeholder for an int and %s is the placeholder for string - \n = newline - \t = tab and %.2f means two decimal places
            System.out.printf("%d. %s \t $%.2f\n", options[i], menuItems[i], prices[i]);
        }
        //Print the Exit option
        System.out.printf("%d. %s \n", options[options.length-1], menuItems[menuItems.length-1]); //printing the last item in both arrays

        System.out.println("===================");
        System.out.print("Enter choice: "); //didn't use a println so the input can be on the same line

    }

    public static void main(String[] args) {
        //Setup Scanner
        Scanner scanner = new Scanner(System.in);

        //User Choice
        int choice;

        //Menu data - stored in an array so we are not hard coding the displayed menu
        int options[] = {1,2,3,4,5};
        String menuItems [] = {"Spring Water", "Cherry Pepsi", "PowerAde Grape", "Orange Juice", "Exit"};
        double prices [] = {2.00, 1.75, 2.50, 2.25}; //this will be a different size than the other arrays because exit doesn't need a price

        //Exit option - this was our number 4. Exit from the original menu
        int EXIT = options[options.length-1]; //the last value in the option array

        //Display Menu
        displayMenu(options, menuItems, prices); // passing in the two arrays to the display menu to compliment the loop we added to the display menu method

        //Get choice from user
        choice = scanner.nextInt();

        //Menu Loop - this would be a separate method

        while(choice != EXIT){ // our exit option
            //Check the Choice Value
            if (choice == options[0]) {  //updated all the hard coded choices with the menuItems array
                System.out.println(menuItems[0]);
            } else if (choice == options[1]) {
                System.out.println(menuItems[1]);
            } else if (choice == options[2]) {
                System.out.println(menuItems[2]);
            } else if (choice == options[3]) {
                System.out.println(menuItems[3]);
            } // You don't need the else if for the exit choice because it would automatically end

            //Display Menu Again (This should also be a method...this code is not dry)
            //a try catch would be here for wrong inputs as well as a do while, if it was a method
            displayMenu(options, menuItems, prices); // passing in the two arrays to the display menu to compliment the loop we added to the display menu method


            //Get User Choice Again
            choice = scanner.nextInt();

        }
        System.out.println("Goodbye and Come Again!");

    }
}

