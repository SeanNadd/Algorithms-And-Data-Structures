package searches;

public interface Search {
    int binarySearch(int[] values, int toFind);
    int recursiveBinarySearch(int[] values, int toFind, int high, int low);
    int linearSearch(int[] values, int toFind);

}
