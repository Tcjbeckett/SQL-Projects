import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       BasicScanner bs = new BasicScanner();
       BasicScanner.basicScanner();

       ScannerWithBoolean swb = new ScannerWithBoolean();
       ScannerWithBoolean.booleanScanner();

        scanner.close(); //close the scanner

    }
}
