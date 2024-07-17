/**
 * The most straightforward algorithm for searching an element in an unsorted array is the Linear Search. Here's how it works:
 * Start from the leftmost element of your array and one by one compare the element to be searched with each element of the array.
 *
 * If the element to be searched matches an element in the array, return the index.
 * If the end of the array is reached without finding the element, return a message indicating that the element was not found.
 *
 */
public class LinearSearch {
    // This function returns index of element x in arr[]

    static int search(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            // Return the index if the element is found
            if (arr[i] == x)
                return i;
        }
        // Return -1 if the element is not found
        return -1;
    }

    // Driver code to test the functions
    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, 7, 5 };
        int n = arr.length;
        int x = 7;
        int index = search(arr, n, x);
        if(index == -1)
            System.out.println("Element is not present in the array.");
        else
            System.out.println("Element found at index: " + index);
    }
}
