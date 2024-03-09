package algorithms;

/**
 * FIXME: Complete the following famous algorithms with their method body implementations
 *        It is suggested that you type them out by memory-ish to see if you understand the
 *        algorithm.
 */

public class Recursive {

    public static int binarySearch(int[] data, int target) {
        return 0;
    }

    private static int binarySearch(int[] data, int target, int min, int max) {
    	return binarySearch(data, target, 0, data.length - 1);
    }

    //TODO: Complete the following helper method for the corresponding
    //      sorting algorithm
    private static int[] getFirstHalf(int[] data) {
        //TODO : update to get first half of array
    	int size = data.length / 2;
        int[] firstHalf = new int[size];
        System.arraycopy(data, 0, firstHalf, 0, size);
        return firstHalf;
    }

    //TODO: Complete the following helper method for the corresponding
    //      sorting algorithm
    private static int[] getSecondHalf(int[] data) {
        //TODO : update to get second half of array
    	int size1 = data.length / 2;
        int size2 = data.length - size1;
        int[] secondHalf = new int[size2];
        System.arraycopy(data, size1, secondHalf, 0, size2);
        return secondHalf;
    }


    //TODO: Complete the following helper method for the corresponding
    //      sorting algorithm
    private static void merge(int[] data, int[] left, int[] right) {
        //TODO: complete body
    	int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
            	data[k++] = left[i++];
            } else {
            	data[k++] = right[j++];
            }
        }
        while (i < left.length) {
        	data[k++] = left[i++];
        }
        while (j < right.length) {
        	data[k++] = right[j++];
        }
    }

    //TODO: Complete the following sorting algorithm
    public static void mergeSort(int[] data) {
        //TODO: RECURSIVE CASE
        //TODO: complete body
    	if (data.length > 1) {
            int[] left = getFirstHalf(data);
            int[] right = getSecondHalf(data);

            mergeSort(left);
            mergeSort(right);

            merge(data, left, right);
        }

    }

    //TODO: Complete the following helper method for the corresponding
    //      sorting algorithm
    private static int partition(int[] data, int low, int high) {
        //TODO: update with partition algorithm
    	int pivot = data[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, high);
        return i + 1;
    }


    //TODO: Complete the following sorting algorithm
    public static void quickSort(int[] data) {
        //TODO : update to call helper method
    	 quickSort(data, 0, data.length - 1);
    }


    //TODO: Complete the following helper method for the corresponding
    //          sorting algorithm
    private static void quickSort(int[] data, int min, int max) {
        //TODO: update to partition list
    	if (min < max) {
            int pivotIndex = partition(data, min, max);
            quickSort(data, min, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, max);
        }
    }


    //TODO: Complete the following sorting algorithm
    public static void selectionSort(int[] data) {
        //TODO: complete body
    	selectionSort(data, 0);
    }


    //TODO: Update/Complete the following selectionSort algorithm
    //      using for loops and swap method (see below)
    private static void selectionSort(int[] data, int start) {
        //TODO: complete body
    	if (start < data.length - 1) {
            int minIndex = start;
            for (int i = start + 1; i < data.length; i++) {
                if (data[i] < data[minIndex]) {
                    minIndex = i;
                }
            }
            swap(data, start, minIndex);
            selectionSort(data, start + 1);
        }
    }

    //TODO: Complete and use the following swap method for
    //      sorting algorithm that require swapping of data
    public static void swap(int[] data, int a, int b) {
        //TODO: complete body
    	 int temp = data[a];
         data[a] = data[b];
         data[b] = temp;
    }

}
