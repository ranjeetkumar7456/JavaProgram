package Java8ByProgRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCollectionUsingLambdaEmplement {
    public static void main(String[] args) {
        List<SortCollectionUsingLambda> list = new ArrayList<>();
        list.addAll(Arrays.asList(
                new SortCollectionUsingLambda("Ranjeet",101),
                new SortCollectionUsingLambda("Amrit",102),
                new SortCollectionUsingLambda("Ashutosh",103),
                new SortCollectionUsingLambda("Nagraj",104)
        ));

        System.out.println(list);
    }
}
