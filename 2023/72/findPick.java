public static int findPeak(int[] arr) {
    int low = 0, high = arr.length - 1;  // Initialize low and high pointers

    while (low <= high) {  // Continue searching while low is less than or equal to high
        int mid = low + (high - low) / 2;  // Calculate mid index to avoid overflow

        // Check if mid is a peak
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && 
            (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
            return arr[mid];  // If mid is a peak, return its value
        }
        // If the left neighbor is greater, move to the left subarray
        else if (mid > 0 && arr[mid - 1] > arr[mid]) {
            high = mid - 1;  // Update the high pointer
        }
        // If the right neighbor is greater, move to the right subarray
        else {
            low = mid + 1;  // Update the low pointer
        }
    }

    return -1;  // If no peak is found (should not happen in a valid input array)
}
