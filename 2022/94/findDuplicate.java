public static int findDuplicate(int[] a) {
    // First pass: Modify the array to count occurrences
    for (int i = 0; i < a.length; i++) {
        int index = a[i] % a.length;  // Calculate the index to update
        a[index] += a.length;  // Increment the value at the calculated index by the length of the array
    }

    // Second pass: Identify the duplicate
    for (int i = 0; i < a.length; i++) {
        if ((a[i] / a.length) >= 2) {  // Check if the value at index i has been incremented at least twice
            return i;  // Return the index (which is the duplicate value)
        }
    }

    return -1;  // If no duplicate is found, return -1
}
