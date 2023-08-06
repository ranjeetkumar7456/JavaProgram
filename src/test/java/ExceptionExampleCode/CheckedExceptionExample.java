package ExceptionExampleCode;

public class CheckedExceptionExample  extends  RuntimeException{
    public CheckedExceptionExample(String message) {
        // call the constructor of Exception class
        super(message);
    }
}
