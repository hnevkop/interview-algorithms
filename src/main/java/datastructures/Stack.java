package datastructures;

/**
 * This class implements a custom Stack data structure.
 * The Stack uses a {@link CustomLinkedList} object to store its elements.
 * The Stack follows the LIFO (Last In First Out) rule.
 * The push operation adds an element to the top of the Stack.
 * The pop operation removes an element from the top of the Stack.
 */
public class Stack {

    private CustomLinkedList list;

    public Stack() {
        list = new CustomLinkedList();
    }

    public boolean isEmpty()
    {
        return (list.size() == 0);
    }

    /**
     * This method adds an element to the top of the Stack.
     *
     * @param item The item to be added to the Stack.
     */
    public void push(Object item)
    {
        list.add(item);
    }

    /**
     * This method removes and returns the top element of the Stack.
     *
     * @return The top item of the Stack.
     */
    public Object pop() {
        Object item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    /**
     * This method returns the top element of the Stack without removing it.
     *
     * @return The top item of the Stack.
     */
    public Object peek() {
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // push elements
        stack.push("Element 1");
        stack.push("Element 2");

        System.out.println("After pushes, is Stack empty? : " + stack.isEmpty());

        // peek the top element
        System.out.println("Peek: " + stack.peek());

        // pop elements
        System.out.println("Pop: " + stack.pop());
        System.out.println("After popping one element, is Stack empty? : " + stack.isEmpty());

        // pop last element
        System.out.println("Pop: " + stack.pop());
        System.out.println("After popping all elements, is Stack empty? : " + stack.isEmpty());
    }
}