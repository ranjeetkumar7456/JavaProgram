package ArrayConcept;

public class LoopingThroughArrayElements {
    public static void main(String[] args) {


        // Example: 1. Using For Loop
        // create an array
        int[] age = {12, 4, 5};

        // loop through the array
        // using for loop
        System.out.println("Using for Loop:");
        for(int i = 0; i < age.length; i++) {
            System.out.println(age[i]);
        }


        // Example: 2. Using the for-each Loop
        // create an array
        int[] age1 = {12, 4, 5};

        // loop through the array
        // using for loop
        System.out.println("Using for-each Loop:");
        for(int a : age1) {
            System.out.println(a);
        }

    }
}
