package view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

    private PrintWriter out;
    private Scanner in;

    public Menu (InputStream input, OutputStream output){
        this.out = new PrintWriter(out);
        this.in = new Scanner(input);
    }

    //default menu
    public Object getChoiceFromOptions(Object[] options){
        Object choice = null;
        while(choice == null){
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    public Object getChoiceFromUserInput(Object[] options){
        Object choice = null;
        String userInput = in.next();
        try{
            int selectedOption = Integer.valueOf(userInput);
            if(selectedOption > 0 && selectedOption <= options.length){
                choice = options[selectedOption - 1];
            }
        }catch(NumberFormatException e){
            //this exception will be dealt with below
        }
        if(choice == null){
            out.println(System.lineSeparator() + "***" + userInput + "is not a valid option ***" + System.lineSeparator());
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options){
        out.println();
        for(int i = 0; i < options.length; i++){
            int optionNum = i + 1;
            out.println(optionNum + ") " + options[i]);
        }
        out.print(System.lineSeparator() + "Please choose an option>>> ");
        out.flush();
    }

}
