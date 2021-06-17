package max_sk;

import max_sk.hash_map.HashTableImpl;
import java.util.concurrent.*;

import java.util.HashMap;

public class HomeWorkApplication {
    public static void main(String[] args) {
        HashTableImpl<Integer, String> hashTable = new HashTableImpl<>(5);



        hashTable.put(0,"Hello 0");
        hashTable.put(1,"Hello 1");
        hashTable.put(2,"Hello 2");
        hashTable.put(3,"Hello 3");
        hashTable.put(4,"Hello 4");
        hashTable.put(5,"Hello 5");
        hashTable.put(6,"Hello 1");
        hashTable.put(7,"Hello 2");
        hashTable.put(8,"Hello 3");
        hashTable.put(9,"Hello 4");
        hashTable.put(10,"Hello 5");
        hashTable.put(5,"Hello 5555");

        hashTable.display();

        System.out.println(hashTable.get(4) + "     qqqqq");
    }
}
