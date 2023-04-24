import java.util.Arrays;

public class BenchmarkingSortingAlgorithms {
    public static void main(String[] args) {

        final int ARRAY_SIZE = 100000; // Change this to test with different array sizes

        int[] array1 = new int[ARRAY_SIZE];
        int[] array2 = new int[ARRAY_SIZE];

        // Fill the arrays with random integers
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int randNum = (int)(Integer.MAX_VALUE * Math.random());
            array1[i] = randNum;
            array2[i] = randNum;
        }

        // Sort array1 using selection sort and time it
        long startTime1 = System.currentTimeMillis();
        selectionSort(array1);
        long runTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("Selection sort time: " + runTime1 + " ms");

        // Sort array2 using Arrays.sort() and time it
        long startTime2 = System.currentTimeMillis();
        Arrays.sort(array2);
        long runTime2 = System.currentTimeMillis() - startTime2;
        System.out.println("Arrays.sort() time: " + runTime2 + " ms");

        // Check that the arrays are sorted identically
        boolean sortedCorrectly = true;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (array1[i] != array2[i]) {
                sortedCorrectly = false;
                break;
            }
        }
        System.out.println("Arrays sorted correctly: " + sortedCorrectly);
    }

    // Selection sort method
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
