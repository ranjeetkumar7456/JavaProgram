package Roopal;

public class RemoveJunkExaple {
    public static void removeJunk(String input)
    {
        String output = input.replaceAll("[^0-9][^a-z][^A-Z]","");

        System.out.println(output);
    }
    public static void main(String[] args) {

        String input = "12^%&*((),.356780fdhljhero7t438756#$^%&*(";

        removeJunk(input);

    }
}
