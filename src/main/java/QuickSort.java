/**
 * Devide and conquer algorithm O(n log n) average case, O(n^2) in the worst-case best case O(log n)
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] array = {10, 7, 8, 9, 1, 5};

    System.out.println("Unsorted array");
    printArray(array);


    int n = array.length;

    QuickSort qs = new QuickSort();
    qs.quickSort(array, 0, n - 1);

    System.out.println("Sorted array");
    printArray(array);
  }

  /**
   * The target of partitions is to place the pivot (any element can be chosen to be a pivot) at its
   * correct position in the sorted array and put all smaller elements to the left of the pivot and
   * all greater elements to the right of the pivot.
   *
   * @param array
   * @param low
   * @param high
   * @return returns a correct position of the pivot
   */
  int partition(int[] array, int low, int high) {

    int pivot = array[high];

    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;
    return (i + 1);
  }

  void quickSort(int[] array, int low, int high) {
    if (low < high) {

      // Partition is done recursively on each side of the pivot after the pivot
      // is placed in its correct position and this finally sorts the array.
      int pi = partition(array, low, high);

      // left division, elements less than pivot
      quickSort(array, low, pi - 1);

      // right division, elements more than pivot
      quickSort(array, pi + 1, high);
    }
  }

  static void printArray(int[] array) {
    int n = array.length;
    for (int i = 0; i < n; ++i) System.out.print(array[i] + " ");
    System.out.println();
  }
}
