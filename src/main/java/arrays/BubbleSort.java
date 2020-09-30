import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < (numbers.length - i); j++) {
                if (numbers[j - 1] > numbers[j]) {
                    //swap elements
                    swap(j - 1, j, numbers);
                }
            }
        }
        return numbers; // returning the final sorted array
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String args[]) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        int[] sortedNumbers;

        sortedNumbers = sort(randomNumbers); // bubble sort

        // print out the sorted numbers
        System.out.println(Arrays.toString(sortedNumbers));
    }
}
