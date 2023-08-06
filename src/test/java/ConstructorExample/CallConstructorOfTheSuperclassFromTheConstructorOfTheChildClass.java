/*

    We can also call the constructor of the superclass from the constructor of child class using super().
*/


package ConstructorExample;

class CallConstructorOfTheSuperclassFromTheConstructorOfTheChildClass {

    // constructor of the superclass
    CallConstructorOfTheSuperclassFromTheConstructorOfTheChildClass(int version1, int version2) {

        if (version1 > version2) {
            System.out.println("The latest version is: " + version1);
        }

        else {
            System.out.println("The latest version is: " + version2);
        }

    }
}

// child class
class Language extends CallConstructorOfTheSuperclassFromTheConstructorOfTheChildClass {

    // constructor of the child class
    Language() {
        // calling the constructor of super class
        super(11, 8);
    }

    // main method
    public static void main(String[] args) {

        // call the first constructor
        Language obj = new Language();

    }
}


/*

        Output

        The latest version is: 11

*/

/*
        In the above example, we have created a superclass named Languages and a subclass Main. Inside the constructor of the Main class, notice the line,

        super(11, 8);

        Here, we are calling the constructor of the superclass (i.e. Languages(int version1, int version2)) from the constructor of the subclass (Main()).

*/
