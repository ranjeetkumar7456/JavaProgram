/*

        Java FileInputStream Class

        In this tutorial, we will learn about Java FileInputStream and its methods with the help of examples.

        The FileInputStream class of the java.io package can be used to read data (in bytes) from files.

        It extends the InputStream abstract class.



                                  -------------------------------
                                  |        InputStream          |
                                  |             ^               |
                                  |             |    extends    |
                                  |      FileInputStream        |
                                  -------------------------------
*/


/*
Create a FileInputStream
        In order to create a file input stream, we must import the java.io.FileInputStream package first.
        Once we import the package, here is how we can create a file input stream in Java.


        1. Using the path to file

       -----------------------------------------------------------
      |  FileInputStream input = new FileInputStream(stringPath); |
       -----------------------------------------------------------

        Here, we have created an input stream that will be linked to the file specified by the path.

        2. Using an object of the file

        FileInputStream input = new FileInputStream(File fileObject);
        Here, we have created an input stream that will be linked to the file specified by fileObject.
*/

/*
        Methods of FileInputStream
        The FileInputStream class provides implementations for different methods present in the InputStream class.

        ========== read() Method =============
        1. read()                                        - reads a single byte from the file
        2. read(byte[] array)                            - reads the bytes from the file and stores in the specified
                                                           array
        3. read(byte[] array, int start, int length)     - reads the number of bytes equal to length from the file and
                                                           stores in the specified array starting from the position
                                                           start



        Suppose we have a file named input.txt with the following content.

        This is a line of text inside the file.
        Let's try to read this file using FileInputStream.

*/








package IOStream;
import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("D:\\SELENIUM_FRAMEWORK\\MavenProjects\\SeleniumMaven\\src\\test\\java\\IOStream\\input.txt");

            System.out.println("Data in the file: ");

            // Reads the first byte
            int i = input.read();

            while(i != -1) {
                System.out.print((char)i);

                // Reads next byte from the file
                i = input.read();
            }
            input.close();
        }

        catch(Exception e) {
            e.getStackTrace();
        }
/*

        Output

        Data in the file:
        This is a line of text inside the file.
*/

/*

        In the above example, we have created a file input stream named input. The input stream
        is linked with the input.txt file.

        FileInputStream input = new FileInputStream("input.txt");

        To read data from the file, we have used the read() method inside the while loop.
*/


/*

        available() Method
        To get the number of available bytes, we can use the available() method. For example,
*/
        try {
            // Suppose, the input.txt file contains the following text
            // This is a line of text inside the file.
            FileInputStream input = new FileInputStream("input.txt");

            // Returns the number of available bytes
            System.out.println("Available bytes at the beginning: " + input.available());

            // Reads 3 bytes from the file
            input.read();
            input.read();
            input.read();

            // Returns the number of available bytes
            System.out.println("Available bytes at the end: " + input.available());

            input.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }

/*
        Output

        Available bytes at the beginning: 39
        Available bytes at the end: 36
*/


/*
        In the above example,

        1. We first use the available() method to check the number of available bytes in the file input stream.
        2. We then have used the read() method 3 times to read 3 bytes from the file input stream.
        3. Now, after reading the bytes we again have checked the available bytes. This time the available bytes
           decreased by 3.
*/

/*
          skip() Method
          To discard and skip the specified number of bytes, we can use the skip() method. For example,

*/

        try {
            // Suppose, the input.txt file contains the following text
            // This is a line of text inside the file.
            FileInputStream input = new FileInputStream("input.txt");

            // Skips the 5 bytes
            input.skip(5);
            System.out.println("Input stream after skipping 5 bytes:");

            // Reads the first byte
            int i = input.read();
            while (i != -1) {
                System.out.print((char) i);

                // Reads next byte from the file
                i = input.read();
            }

            // close() method
            input.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }

/*
        Output

        Input Stream after skipping 5 bytes:
        is a line of text inside the file.
*/


/*
        In the above example, we have used the skip() method to skip 5 bytes of data from
        the file input stream. Hence, the bytes representing the text "This " is not read from the input stream.
*/


/*
        close() Method
        To close the file input stream, we can use the close() method.
        Once the close() method is called, we cannot use the input stream to read data.

         In all the above examples, we have used the close() method to close the file input stream.
   */



    }
}


/*


             Other Methods Of FileInputStream

             Methods	          Descriptions
             finalize()	          - ensures that the close() method is called
             getChannel()	      - returns the object of FileChannel associated with the input stream
             getFD()	          - returns the file descriptor associated with the input stream
             mark() 	          - mark the position in input stream up to which data has been read
             reset() 	          - returns the control to the point in the input stream where the mark was set

*/




