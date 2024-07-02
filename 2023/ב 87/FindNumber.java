
public class FindNumber {
   
    public static int findNumber(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            // Calculate the expected value at mid, given that the array is sorted in descending order
            int expected = arr[0] - mid;
            // If the value at mid does not match the expected value, it indicates a potential gap
            if (arr[mid] != expected) {
                // Check if the gap between the numbers at mid and mid-1 is greater than 1
                // If it is, we've found a missing number, which would be arr[mid - 1] - 1
                if (mid > 0 && arr[mid - 1] - arr[mid] > 1) {
                    return arr[mid - 1] - 1;
                }
                // If the missing number isn't immediately before mid,
                //adjust the upper bound to search the left side (larger numbers)
                high = mid - 1;
            } else {
                // If the value at mid matches the expected value, it means the missing number
                // is on the right side of mid. Adjust the lower bound to search the right side
                low = mid + 1;
            }
        }
        // If no gap is found in the array, return Integer.MIN_VALUE
        return Integer.MIN_VALUE;
    }
    
}
