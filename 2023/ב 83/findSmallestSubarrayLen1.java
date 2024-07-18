public class findSmallestSubarrayLen1 {
   

public static int findSmallestSubarrayLen(int[] arr, int num) {
    // Initialize variables: minLength to store the smallest length found,
    // currentSum to store the sum of the current window, and start to mark the beginning of the window
    int minLength = Integer.MAX_VALUE;  // Stores the smallest length of the subarray found
    int currentSum = 0;  // Stores the sum of the current window
    int start = 0;  // Marks the beginning of the window
    String smallestSubarray = "";  // Stores the indices of the smallest subarray found

    // Loop through the array with end marking the end of the window
    for (int end = 0; end < arr.length; end++) {
        // Add the current element to the current sum
        currentSum += arr[end];
        
        // While the current sum is greater than the target num
        while (currentSum > num) {
            // If the current window is smaller than the previously found smallest window
            if (end - start + 1 < minLength) {
                // Update the minimum length and the smallest subarray
                minLength = end - start + 1;
                smallestSubarray = "[" + start + "-" + end + "]";
            }
            // Print the found subarray
            System.out.println("Subarray found [" + start + "-" + end + "]");
            // Remove the element at start from the current sum and move the start forward
            currentSum -= arr[start];
            start++;
        }
    }
    
    // If no valid subarray was found, print a message and return 0
    if (minLength == Integer.MAX_VALUE) {
        System.out.println("No subarray exists");
        return 0;
    } else {
        // Print the smallest subarray found and return its length
        System.out.println("Smallest Subarray found " + smallestSubarray);
        return minLength;
    }
}

}
