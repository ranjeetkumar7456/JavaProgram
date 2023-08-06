package ExceptionExampleCode;

public class CustomExceptionExample extends Exception{

    public CustomExceptionExample(String message) {
        // call the constructor of Exception class
        super(message);
    }
}
