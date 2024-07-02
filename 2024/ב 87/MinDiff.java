

public class MinDiff {

    /**
 * Function to find the minimum difference between the sums of two subsets of an array.
 * The function uses a recursive approach to explore all possible subsets and calculate the minimum difference.
 * 
 * @param arr the input array of integers
 * @param i the current index in the array
 * @param setA the current sum of the first subset
 * @param setB the current sum of the second subset
 * @return the minimum difference between the sums of the two subsets
 */
private static int minDiff(int[] arr, int i, int setA, int setB) {
    // Base case: if we have considered all elements in the array
    if (i == arr.length) {
        // Return the absolute difference between the two subset sums
        return Math.abs(setA - setB);
    } else {
        // Recursive case 1: include the current element in the first subset (setA)
        int set1 = minDiff(arr, i + 1, setA + arr[i], setB);
        // Recursive case 2: include the current element in the second subset (setB)
        int set2 = minDiff(arr, i + 1, setA, setB + arr[i]);
        // Return the minimum difference obtained from both recursive cases
        return Math.min(set1, set2);
    }
}

    
}
