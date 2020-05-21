package sorts.impl;

import sorts.Sort;

public class SortImpl implements Sort {
    @Override
    public int[] selectionSort(int[] values) {
        int indexMin;
        int tmp;
        for(int i = 0; i < values.length -1; i++){
            indexMin = i;
            for(int j = i+1; j < values.length; j++){
                if(values[j] < values[indexMin]){
                    indexMin = j;
                }
            }
            tmp = values[i];
            values[i] = values[indexMin];
            values[indexMin] = tmp;
        }
        return values;
    }

    @Override
    public int[] insertionSort(int[] values) {
        int currInd;
        int tmp;
        for(int i = 0; i < values.length -1; i++){
            currInd = i;
            while (currInd > 0 && values[currInd] < values[currInd - 1]){
                tmp = values[currInd -1];
                values[currInd -1] = values[currInd];
                values[currInd] = tmp;
                currInd--;
            }
        }

        return values;
    }

    @Override
    public void mergeSort(int[] inputArray, int inputArrayLength) {

        if(inputArrayLength < 2){
            return;
        }

        // Calculate the middle of the array by deviding the length by 2. It'll always round down. 5/2 = 2.
        int middle = inputArrayLength / 2;
        // Declare new array for the left side. The length is that middle just calculated. Ex.: 2
        int[] leftSide = new int[middle];
        // Declare new array for the right side. The length is the remained of the original array length minus the value for the middle. Ex.: 3
        int [] rightSide = new int[inputArrayLength - middle];

        //Copy all elements from the input array (until the middle) into the left side.
        for(int i = 0; i < middle; i++){
            leftSide[i] = inputArray[i];
        }

        //Copy all elements from the input array (from the middle) into the right side.
        for(int i = middle; i < inputArrayLength; i++){
            rightSide[i - middle] = inputArray[i];
        }

        // Call the same function again to further divide into halves what's on the left side.
        mergeSort(leftSide,middle);

        // Call the same function again to further divide into halves what's on the right side.
        mergeSort(rightSide, inputArrayLength - middle);

        //This is gonna be called for the first time when all the array is broken down into little 1 element ones.
        merge(inputArray, leftSide, rightSide, middle, inputArrayLength-middle);

    }

    private static void merge(
            int[] inputArray, int[] leftSide, int[] rightSide, int leftSideLength, int rightSideLength) {

        // Start a counter for each array.
        int leftSideCounter = 0, rightSideCounter = 0, inputArrayCounter = 0;


        // Start looping while we have elements on both sides.
        while (leftSideCounter < leftSideLength && rightSideCounter < rightSideLength) {
            // if the element on the left side is less or equal in value to the right one. Put it in the inputArray.
            //After that, increment the counter.
            if (leftSide[leftSideCounter] <= rightSide[rightSideCounter]) {
                inputArray[inputArrayCounter++] = leftSide[leftSideCounter++];
            }
            // Else, put the right side one in the input array.
            // After that, increment the counter.
            else {
                inputArray[inputArrayCounter++] = rightSide[rightSideCounter++];
            }
        }

        // Loop while there's elements on the left side.
        while (leftSideCounter < leftSideLength) {
            //Putting the elements into the input array.
            inputArray[inputArrayCounter++] = leftSide[leftSideCounter++];
        }

        //Loop while there's elements on the right side.
        while (rightSideCounter < rightSideLength) {
            // Putting them in the input array.
            inputArray[inputArrayCounter++] = rightSide[rightSideCounter++];
        }
    }
}
