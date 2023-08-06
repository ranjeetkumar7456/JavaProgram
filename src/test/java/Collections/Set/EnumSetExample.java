/*
        The EnumSet class of the Java collections framework provides a set implementation of elements of a single enum.
        Before you learn about EnumSet, make sure to know about Java Enums.
        It implements the Set interface.

                            Collection
                                ^
                                |    Extends
                               Set
                                ^
                                |    implements
                              EnumSet

       Creating EnumSet
       In order to create an enum set, we must import the java.util.EnumSet package first.

       Unlike other set implementations, the enum set does not have public constructors. We must use the predefined methods to create an enum set.

       1. Using allOf(Size)
       The allof() method creates an enum set that contains all the values of the specified enum type Size. For example,



*/



package Collections.Set;
import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetExample {
    // 1. Using allOf(Size)
    // an enum named Size
    enum Size1
    {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    // 2. Using noneOf(Size)

    enum Size2 {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    // 3. Using range(e1, e2) Method
    enum Size3 {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    // 4. Using of() Method
    enum Size4 {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    // 5. Insert Elements to EnumSet
    enum Size5 {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    // 6. Access EnumSet Elements
    enum Size6 {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    // 7. Remove EnumSet Elements
    enum Size7 {
        SMALL, MEDIUM, LARGE, EXTRALARGE
    }
    public static void main(String[] args)
    {
        /*
        The allof() method creates an enum set that contains all the values of the specified enum type Size. For example,
        */

        // 1. Using allOf(Size)
        // Creating an EnumSet using allOf()
        EnumSet<Size1> sizes1 = EnumSet.allOf(Size1.class);
        System.out.println("EnumSet: " + sizes1);

        // Output - 1

        // EnumSet: [SMALL, MEDIUM, LARGE, EXTRALARGE]

/*

        EnumSet<Size> sizes = EnumSet.allOf(Size.class);
        Here, Size.class denotes the Size enum that we have created.
*/


        // 2. Using noneOf(Size)
        // Creating an EnumSet using noneOf()
/*
        The noneOf() method creates an empty enum set. For example,

*/
        EnumSet<Size2> sizes2 = EnumSet.noneOf(Size2.class);
        System.out.println("Empty EnumSet: " + sizes2);

        // Output - 2

        // Empty EnumSet : []

/*
        Here, we have created an empty enum named sizes.
        Note: We can only insert elements of enum type Size in the above program. It's because we created our empty enum set using Size enum.
*/
        // 3. Using range(e1, e2) Method
        // Creating an EnumSet using range()

        EnumSet<Size3> sizes3 = EnumSet.range(Size3.MEDIUM, Size3.EXTRALARGE);
        System.out.println("EnumSet: " + sizes3);

        // Output - 3

        // EnumSet: [MEDIUM, LARGE, EXTRALARGE]



        // 4. Using of() Method
        // Using of() with a single parameter

        EnumSet<Size4> sizes11 = EnumSet.of(Size4.MEDIUM);
        System.out.println("EnumSet1: " + sizes1);

        EnumSet<Size4> sizes22 = EnumSet.of(Size4.SMALL, Size4.LARGE);
        System.out.println("EnumSet2: " + sizes2);

        // Output - 4

        //  EnumSet1: [MEDIUM]
        //  EnumSet2: [SMALL, LARGE]



        // 5. Insert Elements to EnumSet

/*
        Methods of EnumSet
        The EnumSet class provides methods that allow us to perform various elements on the enum set.

        Insert Elements to EnumSet
        add() - inserts specified enum values to the enum set
        addAll() inserts all the elements of the specified collection to the set

        For example,

*/

        // Creating an EnumSet using allOf()
        EnumSet<Size5> sizes51 = EnumSet.allOf(Size5.class);

        // Creating an EnumSet using noneOf()
        EnumSet<Size5> sizes52 = EnumSet.noneOf(Size5.class);

        // Using add method
        sizes52.add(Size5.MEDIUM);
        System.out.println("EnumSet Using add(): " + sizes52);

        // Using addAll() method
        sizes52.addAll(sizes51);
        System.out.println("EnumSet Using addAll(): " + sizes52);


        // Output - 5

        //  EnumSet using add(): [MEDIUM]
        //EnumSet using addAll(): [SMALL, MEDIUM, LARGE, EXTRALARGE]


/*
        In the above example, we have used the addAll() method to insert all the elements of an enum set sizes1 to an enum set sizes2.
        It's also possible to insert elements from other collections such as ArrayList, LinkedList, etc. to an enum set using addAll(). However, all collections should be of the same enum type.
*/


        // 6. Insert Elements to EnumSet
/*
        Access EnumSet Elements
        To access elements of an enum set, we can use the iterator() method. In order to use this method, we must import the java.util.Iterator package. For example,
*/

        // Creating an EnumSet using allOf()
        EnumSet<Size6> sizes6 = EnumSet.allOf(Size6.class);

        Iterator<Size6> iterate = sizes6.iterator();

        System.out.print("EnumSet: ");
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }

        // Output - 6

        //  EnumSet: SMALL, MEDIUM, LARGE, EXTRALARGE,


/*
        Note:
        hasNext() returns true if there is a next element in the enum set
        next() returns the next element in the enum set
*/



        // 7. Remove EnumSet Elements

/*
        remove() - removes the specified element from the enum set
        removeAll() - removes all the elements from the enum set
        For example,

*/


        // Creating EnumSet using allOf()
        EnumSet<Size7> sizes7 = EnumSet.allOf(Size7.class);
        System.out.println("EnumSet: " + sizes7);

        // Using remove()
        boolean value1 = sizes7.remove(Size7.MEDIUM);
        System.out.println("Is MEDIUM removed? " + value1);

        // Using removeAll()
        boolean value2 = sizes7.removeAll(sizes7);
        System.out.println("Are all elements removed? " + value2);


        // Output - 7

        // EnumSet: [SMALL, MEDIUM, LARGE, EXTRALARGE]
        // Is MEDIUM removed? true
        // Are all elements removed? true


/*


        Other Methods

        Method	                        Description
        copyOf()	                    Creates a copy of the EnumSet
        contains()		                Searches the EnumSet for the specified element and returns a boolean result
        isEmpty()		                Checks if the EnumSet is empty
        size()		                    Returns the size of the EnumSet
        clear()		                    Removes all the elements from the EnumSet

     =============================================================================
        Clonable and Serializable Interfaces

        The EnumSet class also implements Cloneable and Serializable interfaces.

 */



//        Cloneable Interface
//
//        It allows the EnumSet class to make a copy of instances of the class.
//
//        Serializable Interface
//
//        Whenever Java objects need to be transmitted over a network, objects need to be converted into bits or bytes.
//        This is because Java objects cannot be transmitted over the network.
//
//        The Serializable interface allows classes to be serialized. This means objects of the classes implementing Serializable can be converted into bits or bytes.
//
//        Why EnumSet?
//        The EnumSet provides an efficient way to store enum values than other set implementations (like HashSet, TreeSet).
//        An enum set only stores enum values of a specific enum. Hence, the JVM already knows all the possible values of the set.
//        This is the reason why enum sets are internally implemented as a sequence of bits. Bits specifies whether elements are present in the enum set or not.
//        The bit of a corresponding element is turned on if that element is present in the set.









































    }
}
