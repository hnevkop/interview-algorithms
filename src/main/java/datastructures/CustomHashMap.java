package datastructures;

import java.util.logging.Logger;

/**
 * Custom implementation of a HashMap
 */
public class CustomHashMap {
    private static final int TABLE_SIZE = 128;
    private static final Logger LOGGER = Logger.getLogger(CustomHashMap.class.getName());
    HashEntry[] table;

    CustomHashMap() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public int get(int key) {
        int hash = findHash(key);
        return (table[hash] == null) ? -1 : table[hash].getValue();
    }

    public void put(int key, int value) {
        int hash = findHash(key);
        LOGGER.info("Putting into hash: " + hash);
        table[hash] = new HashEntry(key, value);
    }

    private int findHash(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        return hash;
    }

    private class HashEntry {
        private int key;
        private int value;

        HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.put(1, 0);
        customHashMap.put(5, 20);
        customHashMap.put(21, 15);
        customHashMap.put(31, 10);
        System.out.println(customHashMap.get(5));
        System.out.println(customHashMap.get(21));
        System.out.println(customHashMap.get(31));
    }
}
