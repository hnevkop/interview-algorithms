package datastructures;

import java.util.Arrays;

/**
 * A heap is a special type of binary tree that satisfies the heap property.
 * It is a complete binary tree, which means all levels of the tree are fully filled except possibly for the last level, which is filled from left to right.
 */
public class BinaryHeap {

  /**
   * Standard Implementation via PriorityQueue:
   *
   * PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
   *
   */
  private int size;

    private int[] heap;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        this.size = 0;
        this.heap = new int[DEFAULT_CAPACITY];
    }

    public void insert(int value) {
        if (size >= heap.length) {
            resize();
        }
        heap[size] = value;
        bubbleUp(size);
        size++;
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index] >= heap[parent]) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    public int removeMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is Empty");
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        bubbleDown(0);
        return min;
    }

    private void bubbleDown(int index) {
        while (index <= size / 2) {
            int leftChild = (2 * index) + 1;
            int rightChild = (2 * index) + 2;
            int smallestChild = leftChild;

            if (rightChild < size && heap[rightChild] < heap[leftChild]) {
                smallestChild = rightChild;
            }

            if (heap[smallestChild] >= heap[index]) {
                break;
            }
            swap(index, smallestChild);
            index = smallestChild;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }
}