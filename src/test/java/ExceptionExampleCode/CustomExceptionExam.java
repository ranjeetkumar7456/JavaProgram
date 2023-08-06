package ExceptionExampleCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomExceptionExam {

    ArrayList<String> languages = new ArrayList<>(Arrays.asList("Java", "Python", "JavaScript"));

    // check the exception condition
    public void checkLanguage(String language) throws CustomExceptionExample {

        // throw exception if language already present in ArrayList
        if(languages.contains(language)) {
            throw new CustomExceptionExample(language + " already exists");
        }
        else {
            // insert language to ArrayList
            languages.add(language);
            System.out.println(language + " is added to the ArrayList");
        }
    }

    public static void main(String[] args) {

        // create object of Main class
        CustomExceptionExam obj = new CustomExceptionExam();

        // exception is handled using try...catch
        try {
            obj.checkLanguage("Swift");
            obj.checkLanguage("Java");
        }

        catch(CustomExceptionExample e) {
            System.out.println("[" + e + "] Exception Occured");
        }
    }
}
