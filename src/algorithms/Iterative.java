package algorithms;

/**
 * FIXME: Complete the following famous algorithms with their method body implementations
 *        It is suggested that you type them out by memory-ish to see if you understand the
 *        algorithm.
 */

public class Iterative {

    //TODO: Complete this search algorithm to find an element location is in array
    //      use while loops here
    public static int binarySearch(int[] data, int target){
        //TODO: update with search algorithm
    	int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == target) {
                return mid;
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }


    //TODO: Complete the following sorting algorithm
    public static void bubbleSort(int[] data) {
        //TODO: Implement the algorithm for this sort.
    	int n = data.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (data[i - 1] > data[i]) {
                    swap(data, i - 1, i);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }


    //TODO: Complete this search algorithm to check if an element is in array
    public static boolean contains(int[] data, int target) {
        //TODO: update with search algorithm
    	for (int value : data) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }


    //TODO: Complete this search algorithm to find an element location is in array
    //      use for loops here
    public static int indexOf(int[] data, int target) {
        //TODO: update with search algorithm
    	for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1; // target not found
    }


    //TODO: Complete the following insertion sorting algorithm with the swap method
    public static void insertionSort(int[] data) {
        //TODO: Implement the algorithm for this sort.
    	for (int i = 1; i < data.length; i++) {
            int current = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > current) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = current;
        }
    }


    // This is an example of "finding the worst case run time function"
    // for a maximum value algorithm
    public static int max(int[] data){
        int n   = data.length;          // (1)      data size
        int max = data[0];              // (1)

        //       (1)
        for(int i = 0; i < n; i++)     // n times
            // (1  + 1)
            if(max < data[i])               // (1)
                max = data[i];              // (1)
        // (1)      terminates loop
        return max;                     // (1)

        // run time function f(n) = 1 + 1 + 1 + n(2 + 1 + 1)
        //                   f(n) = 4n + 5
    }


    //TODO: Complete the following selection sorting algorithm using swap method
    public static void selectionSort(int[] data) {
        //TODO: Implement the algorithm for this sort.
    	for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            swap(data, i, minIndex);
        }
    }


    //TODO: Complete and use the following swap method for
    //      sorting algorithm that require swapping of data
    public static void swap(int[] data, int a, int b) {
        //TODO: Complete Body
    	int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

}
