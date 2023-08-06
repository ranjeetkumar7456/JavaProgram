package InterviewQuestion;

public class BinaryToDecimalConverterExample {

    public static void convertBinaryToDecimal(String binaryNumber) {
        int number = Integer.parseInt(binaryNumber, 2);
        System.out.println(number);
    }
    public static void main(String[] args)
    {
        String binaryNumber = "1101";
        //String binaryNumber = "11011100110";
        convertBinaryToDecimal(binaryNumber);

        /*System.out.println("Decimal equivalent of " + binaryNumber + ": " + decimalNumber);*/
    }

   /* Let's understand the code step-by-step:

    public static void convertBinaryToDecimal(String binaryNumber): This is a static method that takes a string
    binaryNumber as input. It is responsible for converting the binary number represented by binaryNumber to its decimal equivalent.

    int number = Integer.parseInt(binaryNumber, 2);: Inside the convertBinaryToDecimal method, this line converts the binary
    number (binaryNumber) to its decimal representation. It uses the Integer.parseInt method, which parses the binary number and
    returns its decimal value. The second argument 2 passed to parseInt is the radix, which indicates that the input binaryNumber
    is in base 2 (binary).

            System.out.println(number);: After converting the binary number to its decimal equivalent, the decimal value is printed to the console.

    public static void main(String[] args) { ... }: This is the main method of the class, where the program execution starts.

            String binaryNumber = "1101";: In the main method, a binary number represented as a string "1101" is assigned to the
            variable binaryNumber.

    convertBinaryToDecimal(binaryNumber);: The convertBinaryToDecimal method is called with the binaryNumber as an argument, which
    converts the binary number to its decimal equivalent and prints the result to the console.

    When you run this program, it will output the decimal equivalent of the binary number "1101", which is 13. If you want to convert
    a different binary number, you can comment out the current binaryNumber line and uncomment the next line where you can assign a
    new binary number to the binaryNumber variable before calling the convertBinaryToDecimal method again to get its decimal equivalent.

*/
}
