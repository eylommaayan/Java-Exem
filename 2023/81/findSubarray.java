public static void findSubarray(int[] arr, int target) {
    int i = 0, j = 0, sum = arr[0];  // Initialize pointers and sum
    
    while (j < arr.length) {  // Continue while j is within array bounds
        if (sum == target) {  // If the current sum equals the target
            System.out.println("Subarray found between indexes " + i + " and " + j + " with sum " + target);
            return;  // Print the result and exit
        } else if (sum < target) {  // If the current sum is less than the target
            j++;  // Move the right pointer to the right
            if (j < arr.length) sum += arr[j];  // Add the new element to the sum
        } else {  // If the current sum is greater than the target
            sum -= arr[i];  // Subtract the element at the left pointer from the sum
            i++;  // Move the left pointer to the right
        }
    }
    
    System.out.println("No subarray found with sum " + target);  // Print if no subarray is found
}
