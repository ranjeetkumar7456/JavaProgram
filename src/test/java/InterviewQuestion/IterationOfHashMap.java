package InterviewQuestion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterationOfHashMap
{
    //1. Iterate HashMap using EntrySet
    public static void Iterate_HashMap_using_EntrySet(Map<String, String> employee)
    {
        for (Map.Entry<String, String> set : employee.entrySet())
        {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = " + set.getValue());
        }
    }

    //2. Iterate HashMap using forEach
    public static void Iterate_HashMap_using_forEach(Map<String, String> employee)
    {
            employee.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    //3. Iterate HashMap using Iterator
    public static void Iterate_HashMap_using_Iterator(Map<String, String> employee)
    {
            // Iterator
            Iterator<Map.Entry<String, String>> it = employee.entrySet().iterator();

            // Iterating every set of entry in the HashMap
            while (it.hasNext())
            {
                Map.Entry<String, String> entry = it.next();

                // Displaying HashMap
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
    }

    //4. Iterate HashMap using Lambda
    public static void Iterate_HashMap_using_Lambda(Map<String, String> employee)
    {
        employee.forEach((key, value) -> System.out.println(key + " = " + value));
    }

    //5. Iterate HashMap using Stream API
    public static void Iterate_HashMap_using_StreamAPI(Map<String, String> employee)
    {
        employee.entrySet().stream().forEach(input -> System.out.println(input.getKey() + " : " + input.getValue()));
    }
    public static void main(String[] args)
    {
        Map<String, String> employeeSalary = new HashMap<>();
        employeeSalary.put("ADavid", "76000.00");
        employeeSalary.put("BJohn", "120000.00");
        /*employeeSalary1.put("CMark", "95000.00");
        employeeSalary1.put("DSteven", "134000.00");
        employeeSalary1.put("EDavid1", "76000.00");
        employeeSalary1.put("GJohn1", "120000.00");
        employeeSalary1.put("FMark1", "95000.00");
        employeeSalary1.put("ISteven1", "134000.00");
        employeeSalary1.put("JDavid2", "76000.00");
        employeeSalary1.put("HJohn2", "120000.00");
        employeeSalary1.put("KMark2", "95000.00");
        employeeSalary1.put("LSteven2", "134000.00");
        employeeSalary1.put("ADavid", "76000.00");
        employeeSalary1.put("BJohn", "120000.00");
        employeeSalary1.put("CMark", "95000.00");
        employeeSalary1.put("DSteven", "134000.00");
        employeeSalary1.put("EDavid1", "76000.00");
        employeeSalary1.put("GJohn1", "120000.00");
        employeeSalary1.put("FMark1", "95000.00");
        employeeSalary1.put("ISteven1", "134000.00");
        employeeSalary1.put("JDavid2", "76000.00");
        employeeSalary1.put("HJohn2", "120000.00");
        employeeSalary1.put("KMark2", "95000.00");
        employeeSalary1.put("LSteven2", "134000.00");*/

        System.out.println("=================================");
        System.out.println("1. Iterate HashMap using EntrySet");
        Iterate_HashMap_using_EntrySet(employeeSalary);

        System.out.println("=================================");
        System.out.println("2. Iterate HashMap using forEach");
        Iterate_HashMap_using_forEach(employeeSalary);

        System.out.println("=================================");
        System.out.println("3. Iterate HashMap using Iterator");
        Iterate_HashMap_using_Iterator(employeeSalary);

        System.out.println("=================================");
        System.out.println("4. Iterate HashMap using Lambda");
        Iterate_HashMap_using_Lambda(employeeSalary);

        System.out.println("=================================");
        System.out.println("5. Iterate HashMap using Stream API");
        Iterate_HashMap_using_StreamAPI(employeeSalary);

        Map<String, String> charType = new HashMap<String, String>();

        // Inserting data in the hash map.
       /* charType.put('J', "Java");
        charType.put('H', "Hibernate");
        charType.put('P', "Python");
        charType.put('A', "Angular");*/

        // Iterating HashMap through forEach and
        // Printing all. elements in a Map
        //employeeSalary.forEach((key, value) -> System.out.println(key + " = " + value));



    }
}
