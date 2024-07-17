import java.util.Arrays;

/**
 * Binary Search Algorithm is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half.
 * The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(log N).
 */
class BinarySearch {
    public static void main(String[] args) {
        int[] arrayValues = {1, 2, 18, 50, 68, 105};
        printArray(arrayValues);
        int out = search(arrayValues, 18);
        System.out.println("Position at:" + out);
    }

    private static int search(int[] array, int target) {

        int length = array.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {

            // find the mid position of the array
            int middle = (left + right) / 2;
            int middlePosition = left + middle;

            if (array[middlePosition] == target) {
                return middlePosition;
            }

            // If target is greater then mid position, ignore left half
            if (array[middlePosition] < target) {
                left = middlePosition + 1;
            } else {
                right = middlePosition - 1;
            }
        }
        return -1;
    }

    private static void printArray(int[] arrays) {
        System.out.println(Arrays.toString(Arrays.stream(arrays).toArray()));
    }

}