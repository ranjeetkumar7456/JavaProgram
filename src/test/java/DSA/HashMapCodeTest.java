package DSA;

import java.util.*;

public class HashMapCodeTest {
    private static class HashMapDesign<K, V1, V2> {
        private class Node {
            K key;
            V1 value1;
            V2 value2;

            public Node(K key, V1 value1, V2 value2) {
                this.key = key;
                this.value1 = value1;
                this.value2 = value2;
            }
        }

        private int n; // Number of nodes
        private int N; // Number of buckets
        private LinkedList<Node>[] buckets; // Buckets to store linked lists of nodes

        @SuppressWarnings("unchecked")
        public HashMapDesign() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets;
            buckets = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value1, node.value2);
                }
            }
        }

        public void put(K key, V1 value1, V2 value2) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                buckets[bi].add(new Node(key, value1, value2));
                n++;
            } else {
                Node node = buckets[bi].get(di);
                node.value1 = value1;
                node.value2 = value2;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public V1 getValue1(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            }
            return buckets[bi].get(di).value1;
        }

        public V2 getValue2(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            }
            return buckets[bi].get(di).value2;
        }

        public void remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                buckets[bi].remove(di);
                n--;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public static void main(String args[]) {
            HashMapDesign<String, Integer, Double> map = new HashMapDesign<>();
            map.put("India", 190, 1.23);
            map.put("China", 200, 4.56);
            map.put("US", 50, 7.89);

            ArrayList<String> keys = map.keySet();
            for (String key : keys) {
                System.out.println("Key: " + key);
                System.out.println("Value1: " + map.getValue1(key));
                System.out.println("Value2: " + map.getValue2(key));
                System.out.println("===============================");
            }
        }
    }

    public static void main(String[] args) {
        HashMapDesign<String, Integer, Double> map = new HashMapDesign<>();
        map.put("India", 190, 1.23);
        map.put("China", 200, 4.56);
        map.put("US", 50, 7.89);

     /*   ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("Key: " + key);
            System.out.println("Value1: " + map.getValue1(key));
            System.out.println("Value2: " + map.getValue2(key));
            System.out.println("===============================");
        }*/


        ArrayList<String> key1 = map.keySet();
        for (String key : key1) {
            //System.out.println("Key: " + key);
            System.out.println("Key: " + key+","+"Value1: " + map.getValue1(key)+" "+"Value2: " + map.getValue2(key));
            //System.out.println("Value2: " + map.getValue2(key));
            System.out.println("===============================");
        }
    }
}
