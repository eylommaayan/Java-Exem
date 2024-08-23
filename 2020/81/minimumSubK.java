
public class minimumSubK {
    
    public static void minimumSubK(int[] arr, int k) {
        int j = 0, min = 0, index = 0, curr = 0;
        
        // Initialize the sum of the first subarray of size k
        for (int i = 0; i < k; i++) {
            min += arr[i];
        }
        
        curr = min;
        
        // Iterate through the array starting from the k-th element
        for (int i = k; i < arr.length; i++) {
            curr -= arr[j++];  // Subtract the element going out of the window
            curr += arr[i];    // Add the new element coming into the window
            
            // Update the minimum sum and its starting index if the current sum is smaller
            if (curr < min) {
                index = j;
                min = curr;
            }
        }
        
        k = index + k - 1;
        System.out.println("Minimum sum sub-array is (" + index + "," + k + ")");
    }
    

}
