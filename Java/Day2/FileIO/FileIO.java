package Java.Day2.FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
    public static void main(String[] args) {

        // can either use forward slashes or if using backslashes, make sure to escape them 
        // relative path is fine if you are within the same project file structure - otherwise use the full path
        String inputFile = "Java/Day2/FileIO/fileInput.txt"; // relative path
        String outputFile = "Java/Day2/FileIO/fileOutput.txt";

        /*
         * TRY-CATCH
         *      -> put some "risky" code in the try block
         *      -> handle those errors in the catch block
         *      -> can only catch one at a time, but you can do multiple catch blocks
         */

        try {
            /*
             * FILE INPUT AND OUTPUT STREAMS
             *      -> have to work with streams to have your data flow between files
             */

            InputStream inputStream = new FileInputStream(inputFile); // creates a new input stream that can read from the inputFile
            OutputStream outputStream = new FileOutputStream(outputFile); // creates a new output stream that can write to the outputFile

            // reading in data from a file
            int byteData;

            //loops until the end of the input file
            while((byteData = inputStream.read()) != -1) {
                System.out.println(byteData);
                
                // converts each int into a character
                char c = (char)byteData;
                System.out.println(c);

                // write to output file
                outputStream.write(byteData); // will overwrite a file
            }

            // always close your files!!
            inputStream.close();
            outputStream.close();

        } catch (IOException ioException) {
            System.out.println("Error with opening and closing files.");
            ioException.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something else went wrong.");
            e.printStackTrace();
        }

        /*
         * CLASS LOADER and RESOURCE STREAM
         *      -> works similarly to FileInputStream
         *      -> the difference:
         *              - getResourceAsStream() grabs a static resource from your class path (ie. within your project)
         * 
         *      -> very useful for apps not running on your local machine
         */

        String resourcePath = "Java\\Day2\\FileIO\\fileInput.txt";
        try {
            InputStream inputStream = FileIO.class.getClassLoader().getResourceAsStream(resourcePath);

            // checking if we found the file
            if(inputStream != null) {
                int byteData;

                // loops until the end of the input file
                while((byteData = inputStream.read()) != -1) {
                    // converting each int into a character
                    System.out.println((char)byteData);
                }
            } else {
                System.out.println("Resource not found!");
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
         * TRY WITH RESOURCES
         *      -> still a try-catch block
         *      -> we pass something that needs to be opened (like a file stream) and it will
         *         automatically close it for us
         *      -> must implement the AutoClosable interface
         */

         try (FileInputStream fileInput = new FileInputStream(inputFile)) {

            int byteData;

            //loops until the end up the input file
            while((byteData = fileInput.read()) != -1) {
                System.out.println((char)byteData);
            }
            
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
}
