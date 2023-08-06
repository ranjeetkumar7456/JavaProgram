package Roopal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberVerification {

    public static boolean isValidNumber(String no)
    {
        boolean status = false;

        Pattern p = Pattern.compile("[7-9][0-9]{9}");

        Matcher m = p.matcher(no);
        status = m.find() && m.group().equals(no);
     return status;
    }

    public static void main(String[] args) {

        boolean status = isValidNumber("99345678978");
        if(status)
        {
            System.out.println("Valid Mobile No");
        }
        else
        {
            System.out.println("Invalid mobile no");
        }

    }
}
