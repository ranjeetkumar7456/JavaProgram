package ArrayConcept;


/*
    Java Arrays

    In this tutorial, we will learn to work with arrays in Java. We will learn to declare, initialize, and access array elements with the help of examples.

    An array is a collection of similar types of data.

    For example, if we want to store the names of 100 people then we can create an array of the string type that can store 100 names.

            String[] array = new String[100];
    Here, the above array cannot store more than 100 names. The number of values in a Java array is always fixed.

    How to declare an array in Java?
    In Java, here is how we can declare an array.

            dataType[] arrayName;
    dataType - it can be primitive data types like int, char, double, byte, etc. or Java objects
    arrayName - it is an identifier
    For example,

    double[] data;
    Here, data is an array that can hold values of type double.

    But, how many elements can array this hold?

    Good question! To define the number of elements that an array can hold, we have to allocate memory for the array in Java. For example,

    // declare an array
    double[] data;

    // allocate memory
    data = new double[10];
    Here, the array can store 10 elements. We can also say that the size or length of the array is 10.

    In Java, we can declare and allocate the memory of an array in one single statement. For example,

    double[] data = new double[10];
    How to Initialize Arrays in Java?
    In Java, we can initialize arrays during declaration. For example,

    //declare and initialize and array
    int[] age = {12, 4, 5, 2, 5};
    Here, we have created an array named age and initialized it with the values inside the curly brackets.

    Note that we have not provided the size of the array. In this case, the Java compiler automatically specifies the size by counting the number of elements in the array (i.e. 5).

    In the Java array, each memory location is associated with a number. The number is known as an array index. We can also initialize arrays in Java, using the index number. For example,

    // declare an array
    int[] age = new int[5];

    // initialize array
    age[0] = 12;
    age[1] = 4;
    age[2] = 5;

    Elements are stored in the array
    Java Arrays initialization
    Note:

    Array indices always start from 0. That is, the first element of an array is at index 0.
    If the size of an array is n, then the last element of the array will be at index n-1.
    How to Access Elements of an Array in Java?
    We can access the element of an array using the index number. Here is the syntax for accessing elements of an array,

// access array elements
    array[index]

    */

public class ArrayConcepts {
    public static void main(String[] args) {

        // create an array
        int[] age = {12, 4, 5, 2, 5};

        // access each array elements
        System.out.println("Accessing Elements of Array:");
        System.out.println("First Element: " + age[0]);
        System.out.println("Second Element: " + age[1]);
        System.out.println("Third Element: " + age[2]);
        System.out.println("Fourth Element: " + age[3]);
        System.out.println("Fifth Element: " + age[4]);
    }
}
