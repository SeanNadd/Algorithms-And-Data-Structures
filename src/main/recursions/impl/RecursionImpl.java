package recursions.impl;

import recursions.Recursion;

public class RecursionImpl implements Recursion {

    @Override
    public int findLargestNumber(int[] input, int leftBound, int rightBound) {
        if(leftBound - rightBound == 1){
            return Math.max(input[leftBound], input[rightBound]);
        }else if(leftBound == rightBound){
            return input[leftBound];
        }
        return Math.max(findLargestNumber(input, leftBound, (leftBound+rightBound)/2), findLargestNumber(input, (leftBound+rightBound)/2 +1, rightBound));
    }
}
