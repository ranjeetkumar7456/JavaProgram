package Java8ByProgRank;

import java.util.Map;

@FunctionalInterface
public interface FunctionalInterfaceDemo<K,V> {
    //int printNum(int x,int b);
    Map<K, V> generateMap();

}
