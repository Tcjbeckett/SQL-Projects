import java.util.Scanner;

public class BasicScanner {
    static Scanner scanner = new Scanner(System.in);

    public static void basicScanner(){

        String name;
        int age;
        float shoeSize;

        System.out.println("Please enter your name.");
        name = scanner.nextLine();
        System.out.println("Please enter your age");
        age = scanner.nextInt();
        System.out.println("Please enter your shoe size");
        shoeSize = scanner.nextFloat();

        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("Your shoe size is: " + shoeSize);




    }

}
