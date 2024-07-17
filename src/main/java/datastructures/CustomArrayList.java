package datastructures;

import java.util.Arrays;
import java.util.Objects;

/**
 * This is a custom implementation of ArrayList data structure.
 * It supports classic ArrayList operations such as add, get, and remove.
 */
public class CustomArrayList {
    private static final int CAPACITY_INCREMENT = 5;
    private Object[] data;
    private int index;
    private int size;

    public CustomArrayList() {
        this.data = new Object[CAPACITY_INCREMENT];
        this.size = CAPACITY_INCREMENT;
    }

    /**
     * Add an item to the ArrayList.
     * Capacity of ArrayList will be increased dynamically.
     *
     * @param item item that needs to be added to the ArrayList
     */
    public void add(Object item) {
        if (this.index == this.size - 1) {
            expandCapacity();
        }
        data[this.index++] = item;
    }

    /**
     * Retrive an item by its index from the ArrayList.
     *
     * @param i index of item
     * @return item from ArrayList.
     * @throws Exception if index is invalid
     */
    public Object get(int i) throws Exception {
        if (!isValidIndex(i)) {
            throw new Exception("Invalid index");
        }
        return this.data[i];
    }

    /**
     * Remove an item by its index from the ArrayList.
     *
     * @param removeIndex index of item that needs to be removed
     * @throws Exception if index is invalid
     */
    public void remove(int removeIndex) throws Exception {
        if (!isValidIndex(removeIndex)) {
            throw new Exception("Invalid index");
        }

        System.arraycopy(this.data, removeIndex + 1, this.data, removeIndex, this.size - removeIndex - 1);
        this.index--;
    }

    private boolean isValidIndex(int i) {
        return i >= 0 && i < this.index;
    }

    private void expandCapacity() {
        this.size += CAPACITY_INCREMENT;
        Object[] newData = new Object[this.size];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }

    public static void main(String[] args) throws Exception {
        CustomArrayList customArrayList = new CustomArrayList();
        customArrayList.add("11");
        customArrayList.add("TEST");
        customArrayList.add("FF");
        customArrayList.add("456789");
        customArrayList.add("TEST2");
        customArrayList.add("FIVE");
        customArrayList.add("XX");
        customArrayList.add("GTH");
        customArrayList.add("9");
        customArrayList.add("10");

        // Removing FIVE
        customArrayList.remove(5);
        printArray(customArrayList.data);
    }

    private static void printArray(Object[] data) {
        System.out.println(Arrays.toString(Arrays.stream(data).filter(Objects::nonNull).toArray()));
    }
}