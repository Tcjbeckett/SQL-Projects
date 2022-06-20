import java.util.Scanner;

public class Keyboard {

   //instance variable
   private Scanner in;

   //constructor
   Keyboard(){
      in = new Scanner(System.in);
   }

   //method
   public int readInteger(String promptMsg, String errorMsg){
      int num = 0;
      String strInput;
      boolean valid = false;

      //Keep looking for valid input
      while(valid == false){
         //Prompt the user
         System.out.println(promptMsg); //prompt message not hard coded
         //Get input from the keyboard
         strInput = in.nextLine();
         //Try to convert the String to an int
         try{
            num = Integer.parseInt(strInput);
            valid = true;
         }catch(NumberFormatException e){
            System.out.println(errorMsg); //error message not hard coded
         }
      }
      return num;
   }

   //This readInteger method creates a range criteria
   public int readInteger(String promptMsg, String errorMsg, int low, int high){ //added low and high range
      int num = 0;
      String strInput;
      boolean valid = false;

      //Keep looking for valid input
      while(valid == false){
         //Prompt the user
         System.out.println(promptMsg); //prompt message not hard coded
         //Get input from the keyboard
         strInput = in.nextLine();
         //Try to convert the String to an int
         try{
            num = Integer.parseInt(strInput);
            if(num >= low && num <= high) {  //added an if statement to evaluate the range
               valid = true;
            }else{
               System.out.println(errorMsg); //Same error message as catch
            }
         }catch(NumberFormatException e){
            System.out.println(errorMsg); //error message not hard coded
         }
      }
      return num;
   }

   public double readDouble(String promptMsg, String errorMsg){
      double num = 0;
      String strInput;
      boolean valid = false;

      //Keep looking for valid input
      while(valid == false){
         //Prompt the user
         System.out.println(promptMsg); //prompt message not hard coded
         //Get input from the keyboard
         strInput = in.nextLine();
         //Try to convert the String to an int
         try{
            num = Double.parseDouble(strInput);
            valid = true;
         }catch(NumberFormatException e){
            System.out.println(errorMsg); //error message not hard coded
         }
      }
      return num;
   }

}
