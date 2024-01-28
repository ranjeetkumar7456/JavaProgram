package CollectionsAndExample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsIntroduction {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(10));
        list.add(new Integer(20));
        list.add(new Integer(30));
        list.add(new Integer(40));
        list.add(new Integer(50));

        //Streams
        //filter
        List<Integer> l1 = list.stream().filter(i -> i>=30).collect(Collectors.toList());
        System.out.println(l1);

        //map

        List<Integer> l2= list.stream().map( i -> i*2).collect(Collectors.toList());
        System.out.println(l2);

        //count
        long cnt = list.stream().filter(i -> i>=30).count();
        System.out.println(cnt);



    }
}
