public class findAverage {
    
    public static boolean findAverage(int[] a, double x) {
        // Initialize sum to 0 and divide to the length of the array a.
        // These variables will be used to calculate the average.
        double sum = 0, divide = a.length, average;
    
        // Initialize low to 0 and high to the last index of the array.
        // These will be used as pointers to traverse the array.
        int low = 0, high = a.length - 1;
    
        // Calculate the sum of all elements in the array.
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
    
        // While there are elements to consider (low <= high) and there are still
        // elements in the subarray (divide > 0).
        while (low <= high && divide > 0) {
            // Calculate the average of the current subarray.
            average = sum / divide;
    
            // If the average matches x, print the range and return true.
            if (average == x) {
                System.out.println(low + "---" + (high));
                return true;
            }
    
            // If the average is greater than x, exclude the current high element
            // from the subarray and update the sum and high pointer.
            if (average > x) {
                sum -= a[high];
                high--;
            } else {
                // If the average is less than x, exclude the current low element
                // from the subarray and update the sum and low pointer.
                sum -= a[low];
                low++;
            }
    
            // Decrease the divide to reflect the new subarray length.
            divide--;
        }
    
        // If no subarray with the given average is found, return false.
        return false;
    }

    
}
