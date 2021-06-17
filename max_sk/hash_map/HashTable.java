package max_sk.hash_map;

public interface HashTable<K, V> {

    boolean put(K key, V value);

    V get(K key);

    void display();

    interface Node<K, V>{
        K getKey();

        V getValue();

        void setValue(V value);

        public HashTableImpl.Item<K, V> getNextElement();

        public void setNextElement(HashTableImpl.Item<K, V> nextElement);
    }
}
