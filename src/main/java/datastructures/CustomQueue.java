package datastructures;

/**
 * This class implements a custom Queue data structure. The Queue uses a {@link CustomLinkedList}
 * object to store its elements. The Queue follows the FIFO (First In First Out) rule. The enqueue
 * operation adds an element to the end of the Queue. The dequeue operation removes an element from
 * the start of the Queue.
 */
public class CustomQueue {

  private CustomLinkedList list;

  public CustomQueue() {
    list = new CustomLinkedList();
  }

  /**
   * This method checks if the Queue is empty.
   *
   * @return True if the Queue is empty, False otherwise.
   */
  public boolean isEmpty() {
    return (list.size() == 0);
  }

  /**
   * This method adds an element to the end of the Queue.
   *
   * @param item The item to be added to the Queue.
   */
  public void enqueue(Object item) {
    list.add(item);
  }

  /**
   * This method removes and returns the first element of the Queue.
   *
   * @return The first item of the Queue.
   */
  public Object dequeue() throws Exception {
      if(isEmpty()){
          // handle underflow condition here.
          throw new Exception("Invalid index");
      }
      Object item = list.get(0);
      list.remove(0);
      return item;
  }

  /**
   * This method returns the first element of the Queue without removing it.
   *
   * @return The first item of the Queue.
   */
  public Object peek() throws Exception {
      if(isEmpty()){
          // handle underflow condition here.
          throw new Exception("Invalid index");
      }
      return list.get(0);
  }

  /** Main method to provide an example usage of CustomQueue. */
  public static void main(String[] args) {
    CustomQueue queue = new CustomQueue();

    // enqueue elements
    queue.enqueue("Element 1");
    queue.enqueue("Element 2");

    System.out.println("After enqueues, is Queue empty? : " + queue.isEmpty());

    // peek the first element
      try {
          System.out.println("Peek: " + queue.peek());
          System.out.println("Dequeue: " + queue.dequeue());
          System.out.println("After dequeuing one element, is Queue empty? : " + queue.isEmpty());

          // dequeue last element
          System.out.println("Dequeue: " + queue.dequeue());
          System.out.println("After dequeuing all elements, is Queue empty? : " + queue.isEmpty());

      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }
}
