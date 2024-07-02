
public class PassingCars {

    public static int passingCars(int[] a) {
        int countEast = 0, passing = 0; // Initialize counters for eastward cars and passing pairs
    
        for (int i = 0; i < a.length; i++) { // Loop through all elements in the array
            if (a[i] == 1) { // If the current car is traveling west
                passing += countEast; // Add the number of eastward cars encountered so far to the passing count
            } else { // If the current car is traveling east
                countEast++; // Increment the eastward car counter
            }
        }
    
        return passing; // Return the total number of passing pairs
    }
    
}
