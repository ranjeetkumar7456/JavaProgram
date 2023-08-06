package Roopal;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class IterateOverHashMapUsingLambdaExpressionExample {
    public static void iterateAndPrint(Map<String, String> map, int n)
    {
       // map.forEach((key,value) -> System.out.println(key+" :"+value));
        //map.forEach((key,value) -> System.out.println(key+" :"+value));
        //map.entrySet().stream().limit(n).forEach((key,value) -> System.out.println(key+" :"+value));
        map.entrySet().stream().limit(n).forEach((key) -> System.out.println(key));
        //map.entrySet().stream().limit(n).forEach((key) -> System.out.println(key));
    }

    public static void iterateAndPrint1(Map<String, String> map, int n)
    {

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, String> comparingByValue())
                .limit(n)
                .forEach(System.out::println);
    }

    public static void iterateAndPrint2(Map<String, String> map, int n)
    {

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, String> comparingByKey())
                .limit(n)
                .forEach(System.out::println);


        System.out.println("=================================>");

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, String> comparingByValue())
                .limit(n)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        Map<String, String> employeeSalary1 = new HashMap<>();
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
        employeeSalary1.put("LSteven2", "134000.00");

        iterateAndPrint2(employeeSalary1,16);
    }
}
