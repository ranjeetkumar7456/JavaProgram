package DSA;

import java.util.*;
public class HashMapCode
{
    private static class HashMapDesign<K,V>    //generics
    {
        private class Node   // design of linklist
        {
            K key;
            V value;
            public Node(K key, V value)
            {
                this.key = key;
                this.value = value;
            }
        }
        private int n; //n - nodes
        private int N; //N - buckets
        private LinkedList<Node> buckets[]; //N = buckets.length           // this is actual hashmap



       /*
        This is constructor that is user to create empty empty linkedlist at every node.
        It is mandatory to create empty linked list oftherwise it will not store the data
        as hashmap uses the array of linked list internally

        */
        @SuppressWarnings("unchecked")       //  it is warning that you have to mension type of linklist while defining
        public HashMapDesign()
        {       // this is constrctor
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++)
            {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key)            // The index or bucket value always be in the range 0 to N-1
        {
            int bi = key.hashCode();
            return Math.abs(bi) % N;               // Here we are taking remender which always gives less than N. Example if any number is divided by N Then remainder must be lies between 0 to N-1
                                                   // This function will return any random value. It can be positive or negative.
                                                   // But we need positive value. Hence we use Math.abs() which return only positive number
        }

        private int searchInLL(K key, int bi)
        {
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++)
            {
                if(ll.get(i).key == key)
                {
                    return i; //di
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash()
        {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];
            for(int i=0; i<N*2; i++)      // Here we are creating empty linkedList as linked list should be there to add old linked list data.
                                          // If we will not create linked list then every time we need to search wether linked list is empty or not
            {
                buckets[i] = new LinkedList<>();
            }
            for(int i=0; i<oldBucket.length; i++)
            {
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++)            // Here we are adding all old linked list data into new linked list
                {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value)
        {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di = -1
            if(di == -1) //key doesn't exist
            {
                buckets[bi].add(new Node(key, value));  // this will create a linkedlist and add the value of key value pair as key,value
                n++;
            }
            else //key exists
            {
                Node node = buckets[bi].get(di);  // Here we are getting the index value where data is already present
                node.value = value;               // Here we are updating the existing value
            }
            double lambda = (double)n/N;          // Here we are finding lambda value

            if(lambda > 2.0)                       // Here we are checking the value of lambda value
            {
                rehash();                           // Then perform rehashing
            }
        }

        public boolean containsKey(K key)
        {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di = -1
            if(di == -1) //key doesn't exist
            {
                return false;
            }
            else //key exists
            {
                return true;
            }
        }

        public V remove(K key)
        {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di = -1
            if(di == -1) //key doesn't exist
            {
                return null;
            }
            else //key exists
            {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public V get(K key)
        {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di = -1
            if(di == -1)  //key doesn't exist
            {
                return null;
            }
            else //key exists
            {
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet()
        {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) //bi - > bucket index
            {
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++) //di- > data index
                {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty()
        {
            return n == 0;
        }
    }
    public static void main(String args[])
    {
        HashMapDesign<String, Integer> map = new HashMapDesign<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);
        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++)
        {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }
        System.out.println("============================");
        map.remove("India");
        System.out.println(map.get("India"));
    }
}