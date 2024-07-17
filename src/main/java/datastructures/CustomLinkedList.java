package datastructures;

/**
 * This class implements a custom LinkedList.
 * LinkedList is a linear data structure with every element being a separate object of Node class.
 * Each Node object holds a data field and a link to the next Node in the structure.
 */
public class CustomLinkedList {

    private Node head;
    private int listCount;

    public CustomLinkedList() {
        head = null;
        listCount = 0;
    }

    /**
     * This helper method is used to get the Node at a specific index. Returns null when index out of bounds.
     *
     * @param index Position of the Node in the LinkedList.
     * @return The Node object at the specified position in the LinkedList.
     */
    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Method to add a new Node with specific data at the end of the LinkedList.
     *
     * @param data Object data to be added.
     */
    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            getNode(size() - 1).setNext(newNode);
        }
        listCount++;
    }

    public void add(Object data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node prevNode = getNode(index - 1);
            newNode.setNext(prevNode.getNext());
            prevNode.setNext(newNode);
        }
        listCount++;
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node != null ? node.getData() : null;
    }

    public boolean remove(int index) {
        if (index >= size()) {
            return false;
        } else if (index == 0) {
            head = head.getNext();
            listCount--;
            return true;
        } else {
            Node prevNode = getNode(index - 1);
            prevNode.setNext(prevNode.getNext().getNext());
            listCount--;
            return true;
        }
    }

    public int size() {
        return listCount;
    }

    public String toString() {
        Node current = head;
        StringBuilder output = new StringBuilder();
        while (current != null) {
            output.append("[").append(current.getData().toString()).append("]");
            current = current.getNext();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // create instance
        CustomLinkedList list = new CustomLinkedList();

        // add elements
        list.add("Element 1"); // Adds element to end of the list
        list.add("Element 2", 1); // Adds element at position 1
        list.add("Element 3");
        list.add("Element 4", 2); // Adds element at position 2

        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());

        // retrieve elements
        System.out.println("Element at Index 1: " + list.get(1));

        // remove elements
        list.remove(2); // remove element at position 2
        System.out.println("List After Removal at index 2: " + list);

        // remove elements
        list.remove(3); // attempt to remove element at position 3, expect false as result
        System.out.println("Attempting Removal at index 3: " + list);
    }

    /**
     * Inner class Node represents a node in the LinkedList.
     * Contains data and a link to the next Node in the LinkedList.
     */
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.next = null;
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}