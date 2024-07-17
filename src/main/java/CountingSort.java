import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Counting Sort
 * algorithm to sort a collection of objects according to keys that are small integers;
 * how it works:
 * 1. find the maximum value in the array
 * 2. create a count array of size max + 1
 * 3. iterate through the input array and increment the count of each element
 */
public class CountingSort {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33);
        List<Integer> output = countingSort(numbers);

        for (int num : output) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        int max = Collections.max(arr);
        int[] countArr = new int[max + 1];

        for(int num : arr) {
            countArr[num]++;
        }

        for(int i = 1; i <= max; i++) {
            countArr[i] += countArr[i - 1];
        }

        List<Integer> output = new ArrayList<>(Collections.nCopies(arr.size(), 0));

        for (int i = arr.size() - 1; i >= 0; i--) {
            output.set(countArr[arr.get(i)] - 1, arr.get(i));
            countArr[arr.get(i)]--;
        }

        return output;
    }

}
