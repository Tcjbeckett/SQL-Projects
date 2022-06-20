import java.security.Key;

public class TestKeyboard {

    public static void main(String[] args) {

        //Create a Keyboard Object
        Keyboard keyboard = new Keyboard();

        //Test Case 1: readInteger
        int intInput;
        String promptMsg1 = "Enter an integer value: ";
        String errorMsg1 = "Invalid entry, enter an integer value";

        //Call to readInteger
        intInput = keyboard.readInteger(promptMsg1, errorMsg1);

        //Output to make sure it works
        System.out.println("You entered the value of :" + intInput);

        //Test Case 2: readDouble
        double doubleInput;
        String promptMsg2 = "Enter a decimal value: ";
        String errorMsg2 = "Invalid entry, enter an decimal value";

        //Call to readInteger
        doubleInput = keyboard.readDouble(promptMsg2, errorMsg2);

        //Output to make sure it works
        System.out.println("You entered the value of :" + doubleInput);

        //Test Case 3: readInteger with low and high
        int intInput2;
        String promptMsg3 = "Enter an integer value between (1-10): ";
        String errorMsg3 = "Invalid entry, enter an integer value between (1-10)";

        //Call to readInteger
        intInput2 = keyboard.readInteger(promptMsg3, errorMsg3,1, 10); //takes in the range as well

        //Output to make sure it works
        System.out.println("You entered the value of :" + intInput2);
    }
}
