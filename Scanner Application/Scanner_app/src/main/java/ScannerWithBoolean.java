import java.util.Scanner;

public class ScannerWithBoolean {
    static Scanner scanner = new Scanner(System.in); //I had to make this static in order to use it in booleanScanner

    public static void booleanScanner(){
        int intAge = 0;

        boolean validUserInput = false; //assume the user may not put in the right information

        System.out.println("Please enter your name.");
        String name = scanner.nextLine();
        do{

            System.out.println("Please enter your age.");
            String age = scanner.nextLine();
            try{
                intAge = Integer.parseInt(age);
                validUserInput = true;
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid number.");
            }
        }while (!validUserInput); //this will run as long as the valid user input is false

        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + intAge);
    }

}
