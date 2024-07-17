/**
 * Bubble sort example, complexity quadratic O(n*n)
 *
 */
public class BubbleSort {
  public static void main(String[] args) {
    BubbleSort bs = new BubbleSort();
    int[] arr = {64, 34, 25, 12, 22, 11, 90};
    bs.bubbleSort(arr);
    printOutArray(arr);
  }

  void bubbleSort(int[] arr) {

    int counter = 0;
    int n = arr.length;
    // All the array loop:
    for (int i = 0; i < n - 1; i++)

      // Bubble loop
      for (int j = 0; j < n - i - 1; j++) {
        counter++;
        if (arr[j] > arr[j + 1]) {
          counter++;
          // swap arr[j] and arr[j+1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    System.out.println("Operations counter: " + counter);
  }

  private static void printOutArray(int[] arr) {
    System.out.println("Sorted array:");
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
  }
}
