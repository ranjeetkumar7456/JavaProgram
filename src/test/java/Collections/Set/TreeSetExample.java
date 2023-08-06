/*
        Interfaces that extend Set
        The Set interface is also extended by these subinterfaces:

        SortedSet
        NavigableSet
        Classes EnumSet, HashSet, LinkedHastSet and TreeSet implement the Set interface.

        How to use Set?
        In Java, we must import java.util.Set package in order to use Set.

        // Set implementation using HashSet
        Set<String> animals = new HashSet<>();
        Here, we have created a Set called animals. We have used the HashSet class to implement the Set interface.

        Methods of Set
        The Set interface includes all the methods of the Collection interface. It's because Collection is a super interface of Set.


        Some of the commonly used methods of the Collection interface that's also available in the Set interface are:

        add() - adds the specified element to the set
        addAll() - adds all the elements of the specified collection to the set
        iterator() - returns an iterator that can be used to access elements of the set sequentially
        remove() - removes the specified element from the set
        removeAll() - removes all the elements from the set that is present in another specified set
        retainAll() - retains all the elements in the set that are also present in another specified set
        clear() - removes all the elements from the set
        size() - returns the length (number of elements) of the set
        toArray() - returns an array containing all the elements of the set
        contains() - returns true if the set contains the specified element
        containsAll() - returns true if the set contains all the elements of the specified collection
        hashCode() - returns a hash code value (address of the element in the set)
        To learn about more methods of the Set interface, visit Java Set (official Java documentation).

        Set Operations
        The Java Set interface allows us to perform basic mathematical set operations like union, intersection, and subset.

        Union - to get the union of two sets x and y, we can use x.addAll(y)
        Intersection - to get the intersection of two sets x and y, we can use x.retainAll(y)
        Subset - to check if x is a subset of y, we can use y.containsAll(x)
*/


package Collections.Set;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetExample {
    public static void main(String[] args) {
// Creating a set using the TreeSet class
        Set<Integer> numbers = new TreeSet<>();

        // Add elements to the set
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
        System.out.println("Set using TreeSet: " + numbers);

        // Access Elements using iterator()
        System.out.print("Accessing elements using iterator(): ");
        Iterator<Integer> iterate = numbers.iterator();
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
    }
}
