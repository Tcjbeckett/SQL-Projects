import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
//
//        String name;
//        int age;
//        float shoeSize;
//
//        System.out.println("Please enter your name.");
//        name = scanner.nextLine();
//        System.out.println("Please enter your age");
//        age = scanner.nextInt();
//        System.out.println("Please enter your shoe size");
//        shoeSize = scanner.nextFloat();
//
//        System.out.println("Your name is: " + name);
//        System.out.println("Your age is: " + age);
//        System.out.println("Your shoe size is: " + shoeSize);
//
//        scanner.close(); //close the scanner
        ScannerWithBoolean swb = new ScannerWithBoolean();
        ScannerWithBoolean.booleanScanner();

    }
}
