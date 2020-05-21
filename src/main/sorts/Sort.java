package sorts;

public interface Sort {
    int[] selectionSort(int[] values);
    int[] insertionSort(int[] values);
    void mergeSort(int[] inputArray, int inputArrayLength);
}
