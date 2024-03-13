package Java.Day2.FileIO;

import java.io.PrintWriter;
import java.util.Scanner;

public class CmdLineIO {
    public static void main(String[] args) {

        // system default is tyhe command line
        System.out.println("Hello World!");

        Scanner scanIn = new Scanner(System.in); // tells the scanner to use the default system input

        /*
         * SCANNER
         *      -> all data has to be stored into a variable
         *          specifically a primitive type OR String
         */

        System.out.println("Enter a String: ");

        String textInput = scanIn.nextLine();
        System.out.println("You entered: " + textInput); // print doesnt append a newline to the end of your text

        System.out.println("Enter a number: ");
        double numInput = scanIn.nextDouble();
        System.out.println("You entered: " + numInput);

        // must close Scanners!! otherwise memory leaks
        scanIn.close();

        /*
         * PRINT WRITER
         *      -> allows for better formatting for print statements
         *      -> allows you too queue up several prints and flush them out all at once
         */

        String name = "Caroline";
        int age = 26;
        double height = 150.5;

        // this is the normal method without the print writer
        System.out.println(name + " is " + age + " years old and is " + height + " cm tall!");

        PrintWriter consoleOut = new PrintWriter(System.out);
        // wildcard character must match the data type of variable
        consoleOut.printf("%s is %d years old and is %f cm tall!", name, age, height);

        consoleOut.print("This prints a normal String!");
        consoleOut.append("This string will be added to the end of the previous one!");

        // need to flush to clear your print writer queue
        consoleOut.flush();

        consoleOut.println("This print another string!");
        consoleOut.flush();
    }
}
