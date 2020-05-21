package searches.impl;

import searches.Search;

public class SearchImpl implements Search {

    @Override
    public int binarySearch(int[] values, int toFind) {
        int high = values.length -1;
        int low = 0;
        int middle;
        while(high >= low) {
            middle = (high + low) / 2;
            if (values[middle] > toFind) {
                high = middle -1;
            } else if (values[middle] < toFind) {
                low = middle + 1;
            }
            if(values[middle] == toFind) return toFind;
        }
        return -1;

    }

    @Override
    public int recursiveBinarySearch(int[] values, int toFind, int high, int low) {
        int middle = (high + low) / 2;
        if(high > low) {
            if (values[middle] > toFind) {
                return recursiveBinarySearch(values, toFind, middle - 1, low);
            } else if (values[middle] < toFind) {
                return recursiveBinarySearch(values, toFind, high, middle + 1);
            }
        }
        return (values[middle] == toFind) ? toFind : -1;
    }

    @Override
    public int linearSearch(int[] values, int toFind) {
        for(int v : values){
            if(v == toFind) return v;
        }
        return -1;
    }
}
