

public class makeSum {
 
    
    public static int makeSum(int[] lengths, int k, int num) {
        return makeSum(lengths, k, num, 0);
    }
    
    private static int makeSum(int[] lengths, int k, int num, int i) {
        // If the remaining sum to achieve is 0, we have found one way to achieve the sum k
        if (k == 0) {
            return 1;
        }
        // If we have gone through all elements or if the number of elements to use is 0, return 0 indicating failure
        if (i == lengths.length || num == 0) {
            return 0;
        }
        // Recursively try to include the current element or skip it
        return makeSum(lengths, k - lengths[i], num - 1, i) +
               makeSum(lengths, k, num, i + 1);
    }
    

}
