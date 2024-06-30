public class Q5 {

    // פונקציה שמחזירה את הערך המקסימלי במערך a
    // Function that returns the maximum value in array a
    public static int what(int[] a) {
        int p = 0; // אינדקס למעקב אחרי המיקום של הערך המקסימלי
                   // Index to keep track of the position of the maximum value
        for (int i = 1; i < a.length; i++) { // לולאה שעוברת על כל האיברים במערך
                                             // Loop that iterates through all elements in the array
            if (a[p] < a[i]) // בדיקה אם הערך באינדקס p קטן מהערך הנוכחי
                             // Check if the value at index p is less than the current value
                p = i; // עדכון האינדקס של הערך המקסימלי
                       // Update the index of the maximum value
        }
        return a[p]; // החזרת הערך המקסימלי
                     // Return the maximum value
    }

    // פונקציה שמבצעת חישוב מסוים על מערך a ומספר k ומחזירה אינדקס
    // Function that performs a specific calculation on array a and number k, and returns an index
    public static int secret(int[] a, int k) {
        int[] temp = new int[what(a) + 1]; // יצירת מערך עזר temp עם אורך לפי הערך המקסימלי במערך a + 1
                                           // Create a helper array temp with length based on the maximum value in array a + 1
        int i, total = 0; // משתנים למעקב אחרי אינדקס והסכום הכללי
                          // Variables to keep track of the index and the total sum
        for (i = 0; i < a.length; i++) // לולאה שמעדכנת את מערך העזר temp
                                       // Loop that updates the helper array temp
            temp[a[i]]++; // הגדלת הערך במערך temp באינדקס של הערך הנוכחי במערך a
                          // Increment the value in the temp array at the index of the current value in array a
        for (i = 0; i < temp.length && total < k; i++) // לולאה שמחברת את ערכי מערך temp עד שהסכום מגיע ל-k
                                                       // Loop that sums the values in the temp array until the total reaches k
            total += temp[i]; // הוספת הערך הנוכחי במערך temp לסכום הכללי
                              // Add the current value in the temp array to the total sum
        return i - 1; // החזרת האינדקס האחרון שעברנו עליו
                      // Return the last index that was iterated over
    }

    // פונקציית main לבדיקת הפונקציות
    // Main function to test the other functions
    public static void main(String[] args) {
        int[] a = {71, 5, 2, 12, 84, 71, 85, 192, 71, 85}; // יצירת מערך לבדיקה
                                                          // Create an array for testing
        for (int i = 1; i <= a.length; i++) // לולאה שעוברת על כל האיברים במערך
                                            // Loop that iterates through all elements in the array
            System.out.println(i + ": " + secret(a, i)); // הדפסת התוצאה של הפונקציה secret עבור כל אינדקס במערך
                                                         // Print the result of the secret function for each index in the array
    }
}
