package InterviewQuestion;

public class StringReverseMaintainingSpecialCharacterExample {

    public static void reverseStringMaintainingSpeacialCharacter(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            if (!isSpecialCharacter(charArray[left])) {
                if (!isSpecialCharacter(charArray[right])) {
                    char temp = charArray[left];
                    charArray[left] = charArray[right];
                    charArray[right] = temp;
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }

        System.out.println(charArray);
    }

    public static boolean isSpecialCharacter(char c) {
        return !Character.isLetterOrDigit(c);
    }

    public static void main(String[] args) {
        String str="a,b$cdefg";
        reverseStringMaintainingSpeacialCharacter(str);

    }
}
