package max_sk.hash_map;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Node<K, V> {
        private final K key;
        private V curentElement;
        private Item<K, V> nextElement;

        public Item(K key, V value) {
            this.key = key;
            this.curentElement = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return curentElement;
        }

        @Override
        public void setValue(V value) {
            this.curentElement = value;


        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + curentElement +
                    '}';
        }

        @Override
        public Item<K, V> getNextElement() {
            return nextElement;
        }

        @Override
        public void setNextElement(Item<K, V> nextElement) {
            this.nextElement = nextElement;
        }

    }

    private Item<K, V>[] data;
    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity];
    }

    private int hashFunc(K key) {
        //return 3; //Искуственная колизия
        return key.hashCode() % data.length;
    }


    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        int count = 0;

        setDataSize();

        while (data[index] != null) {
            if (isKeysEqual(data[index], key)) {
                data[index] = new Item<>(key, value);
                return true;
            }

            if (hashFunc(key) == hashFunc(data[index].key)) {
                Item<K, V> item = data[index];
                System.out.println("Колизия");
                while (true) {
                    if (item.nextElement == null) {
                        item.setNextElement(new Item<>(key, value));
                        return false;

                    } else {
                        item = item.getNextElement();
                    }
                }
            }

            if (count >= data.length) {
                return false;
            }
            count++;
            index += getStep(key);
            index %= data.length;
        }
        data[index] = new Item<>(key, value);
        size++;
        return true;
    }

    private void setDataSize() {
        if ((data.length - 1) == size) {
            Item<K, V>[] newData = new Item[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    private boolean isKeysEqual(Item<K, V> item, K key) {
        if (item == null) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        Item<K, V> item;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && hashFunc(data[i].key) == hashFunc(key)) {
                item = data[i];
                while (!(item == null)) {
                    if (item.key == key) {
                        return item.getValue();
                    } else {
                        item = item.getNextElement();
                    }
                }
            }
        }
        return null;
    }


    protected int getStep(K key) {
        return 1;
    }


    @Override
    public void display() {
        Item<K, V> item;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                item = data[i];
                System.out.print(item + " ");
                while (item != null) {
                    item = item.getNextElement();
                    if (item != null) {
                        System.out.print(item);
                    }
                }
                System.out.println();
            } else {
                System.out.println(data[i]);
            }

        }
    }
}
