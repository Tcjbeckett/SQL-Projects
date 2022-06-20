import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import  java.util.Scanner;

public class Menu3 {

    public static void displayMenu(ArrayList<MenuItem> items){ //passing in the Menu Arraylist
        //Display Menu
        System.out.println("--------");
        System.out.println("M E N U");
        System.out.println("--------");

        //Loop through the Menu data options and menuItems
        //Note* the options/menu item arrays are the same size
        for(int i = 0; i < items.size(); i++){ //changed to Arraylist size
            MenuItem item = items.get(i); //iterating through the ArrayList
            //printf to format the string better - %d is the placeholder for an int and %s is the placeholder for string - \n = newline - \t = tab and %.2f means two decimal places
            System.out.printf("%d. %s \t $%.2f\n", i + 1, item.getName(), item.getPrice()); //using the for loop i, and getter methods in the Menu Item class
        }
        //Print the Exit option
        System.out.printf("%d. Exit\n", items.size() + 1); //printing the Exit option using ArrayList size + 1 and hard code Exit

        System.out.println("===================");

    }
    //method to replace the conditional block
    public static void completeTransaction(int choice, ArrayList<MenuItem> items) { //method that replaces the conditional block
        MenuItem item = items.get(choice-1); //subtracting 1 from the choice because the zero index
        System.out.printf("Here is your %s worth %.2f\n", item.getName(), item.getPrice());

    }

    public static void main(String[] args) {
        //Setup Scanner
        Scanner scanner = new Scanner(System.in);

        //Create a Keyboard object for keyboard validation
        Keyboard keyboard = new Keyboard();

        //User Choice
        int choice;

        //Menu data - stored in an array so we are not hard coding the displayed menu
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>(); //Create arraylist for Menu Items instead of the 3 arrays
        menuItem.add(new MenuItem("Spring Water", 2.00)); //adding menu items to the array list
        menuItem.add(new MenuItem("Cherry Pepsi", 1.75));
        menuItem.add(new MenuItem("PowerAde Grape", 2.50));
        menuItem.add(new MenuItem("Orange Juice", 2.25));

        //Exit option - this was our number 4. Exit from the original menu
        int EXIT = menuItem.size() + 1; //the last value in the option array

        //Display Menu
        displayMenu(menuItem); // passing in Arraylist

        //Get choice from user ***Using the Keyboard class method****
        choice = keyboard.readInteger("Enter choice: ", "Error: invalid input", 1 , EXIT); //low is 1 and high is EXIT last options

        //Menu Loop - this would be a separate method

        while(choice != EXIT){ // our exit option
            //Check the Choice Value
            completeTransaction(choice, menuItem); //method that replaces the conditional block

            //Display Menu Again
            displayMenu(menuItem); // passing in ArrayList


            //Get User Choice Again
            choice = keyboard.readInteger("Enter choice: ", "Error: invalid input", 1 , EXIT); //low is 1 and high is EXIT last options

        }
        System.out.println("Goodbye and Come Again!");

    }
}

