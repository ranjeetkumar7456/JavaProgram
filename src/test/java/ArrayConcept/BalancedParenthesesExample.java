package ArrayConcept;

import java.util.Stack;

public class BalancedParenthesesExample {
    public static boolean isBalanced(String str)
    {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray())
        {
            if (c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '['))
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean isBalance1(String str)
    {
        Stack<Character> stack = new Stack<>();
        char[] charArray  = str.toCharArray();
        for (int i =0 ; i<charArray .length;i++)
        {
            if(charArray[i]=='(' || charArray[i]=='{' || charArray[i]=='[')
            {
                stack.push(charArray[i]);
            }
            else if(charArray[i]==')' || charArray[i]=='}' || charArray[i]==']')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                char top = stack.pop();
                if ((charArray[i] == ')' && top != '(') || (charArray[i] == '}' && top != '{') || (charArray[i] == ']' && top != '['))
                {
                    return false;
                }
            }
        }


        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str1 = "(2 + 3) * (5 - 1)";
        String str2 = "{[()]()}";
        String str3 = "([)]";
        String str4 = "((()";

        String str5 = ")}]";

        System.out.println(isBalance1(str1));  // Output: true
        System.out.println(isBalance1(str2));  // Output: true
        System.out.println(isBalance1(str3));  // Output: false
        System.out.println(isBalance1(str4));  // Output: false
        System.out.println(isBalance1(str5));  // Output: false
    }
}

     /*
        In this implementation, the isBalanced function takes a string as input and returns true if the parentheses
        in the string are balanced, and false otherwise.

        The function uses a Stack to track the opening parentheses encountered. It iterates through each character
        in the string and performs the following steps:

        If an opening parenthesis ('(', '{', or '[') is encountered, it is pushed onto the stack.
        If a closing parenthesis (')', '}', or ']') is encountered, it checks if the stack is empty. If the stack is empty, it means there is no matching opening parenthesis, and the parentheses are unbalanced. If the stack is not empty, it pops the top element from the stack and checks if it matches the current closing parenthesis. If the opening and closing parentheses do not match, the parentheses are unbalanced.
        After processing all characters, if the stack is empty, it means all opening parentheses have been matched and balanced. If the stack is not empty, there are unmatched opening parentheses, indicating unbalanced parentheses.
        In the main method, we provide four example strings containing parentheses and call the isBalanced function on each string. The results are printed to demonstrate the balanced and unbalanced cases.

        The output will be:

        arduino
        Copy code
        true
        true
        false
        false

        */

/*

    The code is a Java program that checks if the given string contains
    balanced parentheses. It uses a stack data structure to keep track of opening parentheses and ensures that each closing parenthesis corresponds to the correct opening parenthesis.

        Let's go through the code step-by-step:

        The isBalanced function takes a string str as input and returns a boolean value (true if the parentheses are balanced, false otherwise).

        Inside the function, a Stack<Character> named stack is created. This stack will be used to store the opening parentheses encountered
        while iterating through the input string.

        The function then iterates through each character c in the input string using a for-each loop on the str.toCharArray().

        If the character c is an opening parenthesis ('(', '{', or '['), it is pushed onto the stack, indicating that a corresponding
        closing parenthesis should be expected later in the string.

        If the character c is a closing parenthesis (')', '}', or ']'), the function checks if the stack is empty. If the stack
        is empty, it means there is no corresponding opening parenthesis for the current closing parenthesis, so the function
        returns false as the parentheses are not balanced.

        If the stack is not empty, the function pops the top character top from the stack, which should be the last
        encountered opening parenthesis.

        The function then checks if the current closing parenthesis c matches the corresponding opening parenthesis top.
        If they don't match (e.g., c is ')', but top is not '('), it means the parentheses are not balanced, so the
        function returns false.

        The loop continues until all characters in the input string are processed.

        After the loop, the function checks if the stack is empty. If it's empty, it means all opening parentheses
        have been matched with the corresponding closing parentheses, and the function returns true, indicating that
        the parentheses are balanced. Otherwise, it returns false.

        In the main method, the isBalanced function is tested with four different input strings: str1, str2, str3,
        and str4. The program prints the results of the function calls, showing whether the corresponding strings
        have balanced parentheses or not.
        */

/*

    The stack data structure is used in the above code to check whether the parentheses in the input string are balanced or not. The main reason for
    using a stack is to keep track of the opening parentheses encountered in the string so that we can ensure that each closing parenthesis matches
    the corresponding opening parenthesis in the correct order.

        Here's why we use a stack:

        Matching Opening and Closing Parentheses: When parsing the input string, we need to ensure that each closing parenthesis (')', '}', ']')
        is matched with its corresponding opening parenthesis ('(', '{', '[') in the correct order. A stack allows us to maintain the order of
        opening parentheses encountered in the string.

        Last-In-First-Out (LIFO) Property: The stack data structure follows the Last-In-First-Out (LIFO) property, meaning the last element added
        to the stack is the first one to be removed. This property is useful when dealing with nested parentheses. As we encounter opening parentheses,
        we push them onto the stack. When we encounter a closing parenthesis, we can easily check if it matches the last opening parenthesis by popping
        the top element from the stack.

        Nested Parentheses: The presence of nested parentheses (e.g., "(2 + (3 * 5))") makes it important to keep track of the order in which they appear.
        The stack helps in handling nested parentheses efficiently by maintaining the correct order.

        Balancing Check: By using a stack, we can efficiently check if the string contains balanced parentheses. If there are any unmatched closing
        parentheses or if the stack is not empty after processing the entire string, it means the parentheses are not balanced.

        The stack allows us to process the parentheses in a way that guarantees their correct matching, ensuring the string is balanced if all
        opening and closing parentheses match correctly. If any parenthesis is unmatched, the stack helps us detect this condition and return false.

        In summary, using a stack simplifies the process of checking for balanced parentheses in the input string and ensures that the order of
        opening and closing parentheses is correctly maintained.


*/

/*

    In the given code, char top = stack.pop(); is a statement that retrieves and removes the top element from the stack data structure
    and assigns it to the variable top. The pop() method is used to remove the top element from the stack and return it.

        Here's what happens when char top = stack.pop(); is executed:

        The pop() method of the Stack class is called, which removes the top element from the stack.
        The removed element is of type Character, which is why it is assigned to the variable top of type char.
        Since the stack contains characters ('(', '{', '[') representing opening parentheses, the pop()
        method will return the last encountered opening parenthesis from the stack.

        This operation is crucial for ensuring that the closing parenthesis (')', '}', ']') matches the corresponding
        opening parenthesis in the correct order. When a closing parenthesis is encountered, it needs to be matched
        with the last encountered opening parenthesis. The pop() method helps achieve this by retrieving the last
        opening parenthesis from the stack and comparing it with the current closing parenthesis.

        For example, if the input string is "{[()]()}", the stack will hold the following elements as we iterate through the characters:

        Stack: { (Opening curly brace encountered)
        Stack: { [ (Opening square bracket encountered)
        Stack: { [ ( (Opening round bracket encountered)

        Now, when we encounter the closing round bracket ), we can use char top = stack.pop(); to get the last opening
        round bracket (, and then we can check if they match (which they do in this case).

        If at any point the stack is empty, it means there is no corresponding opening parenthesis for the current closing
        parenthesis, and the code returns false, indicating that the parentheses are not balanced.

*/


/*
Here's what this section does:

        The code enters this block if the current character charArray[i] is a closing parenthesis (')', '}', or ']').

        It first checks if the stack (stack) is empty. If the stack is empty and we encounter a closing parenthesis,
        it means there is no corresponding opening parenthesis for it, and the parentheses are not balanced. In this case,
        the method returns false.

        If the stack is not empty, it means there is at least one opening parenthesis that should match the current
        closing parenthesis. The code then proceeds to compare the current closing parenthesis with the last opening
        parenthesis from the stack.

        The statement char top = stack.pop(); retrieves and removes the last element (opening parenthesis) from the
        stack and assigns it to the variable top. This is done to compare it with the current closing parenthesis (charArray[i]).

        The code then checks if the current closing parenthesis and the last opening parenthesis do not match.
        If they don't match, it means the parentheses are not balanced, and the method returns false.

        Here's an example to illustrate the process:

        Input string: "{()}"

        '{': The opening curly brace '{' is encountered, so it is pushed onto the stack.
        Stack: '{'

        '[': The opening square bracket '[' is encountered, so it is pushed onto the stack.
        Stack: '{', '['

        '(': The opening round bracket '(' is encountered, so it is pushed onto the stack.
        Stack: '{', '[', '('

        ']': The closing square bracket ']' is encountered. It matches the last opening square bracket '[', so the last element ('[') is popped from the stack.
        Stack: '{', '('

        ')': The closing round bracket ')' is encountered. It matches the last opening round bracket '(', so the last element ('(') is popped from the stack.
        Stack: '{'

        '}': The closing curly brace '}' is encountered. It matches the last opening curly brace '{', so the last element ('{') is popped from the stack.
        Stack: (empty)

        Since all the parentheses have matching pairs and the stack is empty at the end of the iteration, the method returns true, indicating
        that the string contains balanced parentheses.

*/








