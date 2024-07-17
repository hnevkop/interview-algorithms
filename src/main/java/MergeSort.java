/**
 * merge sort is a divide and conquer algorithm. It divides input array in two halves, calls itself
 * for the two halves and then merges the two sorted halves. The merge() function is used for
 * merging two halves. sort() function is a recursive function that sorts the array.
 */
public class MergeSort {

  public static void main(String[] args) {
    MergeSort ms = new MergeSort();
    int[] arr = {12, 11, 13, 5, 6, 7};

    System.out.println("Given Array");
    printArray(arr);

    ms.sort(arr, 0, arr.length - 1);

    System.out.println("\nSorted array");
    printArray(arr);
  }

  // Method to merge two halves
  void merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int[] leftArray = new int[n1];
    int[] rightArray = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i) leftArray[i] = arr[l + i];
    for (int j = 0; j < n2; ++j) rightArray[j] = arr[m + 1 + j];

    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        arr[k] = leftArray[i];
        i++;
      } else {
        arr[k] = rightArray[j];
        j++;
      }
      k++;
    }

    // remaining elements
    while (i < n1) {
      arr[k] = leftArray[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = rightArray[j];
      j++;
      k++;
    }
  }

  // Merge sort method
  void sort(int[] arr, int l, int r) {
    if (l < r) {
      // Find the middle point
      int m = (l + r) / 2;

      // Sort first and second halves
      sort(arr, l, m);
      sort(arr, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }

  // Method to print array
  static void printArray(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }
}
