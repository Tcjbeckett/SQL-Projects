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
    }
}
