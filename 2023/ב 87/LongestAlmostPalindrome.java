public class LongestAlmostPalindrome {

    // Public method to start the process of finding the longest almost palindrome
    // שיטה ציבורית להתחיל את התהליך של מציאת הריצף הכמעט פלינדרומי הארוך ביותר
    public static int longestAlmostPalindrome(int[] arr) {
        // Check for empty or null array
        // בדיקה אם המערך ריק או null
        if (arr == null || arr.length == 0) return 0;
        // Start searching for almost palindrome with a size of 2
        // התחלת החיפוש אחר ריצף כמעט פלינדרומי בגודל 2
        return longestAlmostPalindrome(arr, 2, 1, 0, 1);
    }

    // Private recursive method to find the longest almost palindrome
    // שיטה פרטית רקורסיבית למצוא את הריצף הכמעט פלינדרומי הארוך ביותר
    private static int longestAlmostPalindrome(int[] arr, int size, int max, int i, int j) {
        // If the current sequence size is greater than the array length, return the max found so far
        // אם הגודל הנוכחי של הריצף גדול מאורך המערך, החזרת המקסימום שנמצא עד כה
        if (size > arr.length) {
            return max;
        }

        // If the end index of the sequence exceeds array bounds, increase sequence size and reset i, j
        // אם אינדקס הסיום של הריצף חורג מגבולות המערך, הגדלת גודל הריצף ואיפוס האינדקסים i ו-j
        if (j >= arr.length) {
            return longestAlmostPalindrome(arr, size + 1, max, 0, size);
        }

        // If the values at indices i and j are the same, check if the sequence is an almost palindrome
        // אם הערכים באינדקסים i ו-j זהים, בדיקת אם הריצף הוא כמעט פלינדרום
        if (arr[i] == arr[j]) {
            int temp = checkPalindrome(arr, 2, false, i + 1, j - 1);
            // If the current sequence is longer than previously found sequences, update max
            // אם הריצף הנוכחי ארוך יותר מהריצפים שנמצאו קודם לכן, עדכון המקסימום
            if (temp > max) {
                max = temp;
            }
        }

        // Continue search by incrementing i and j
        // המשך החיפוש על ידי הגדלת האינדקסים i ו-j
        return longestAlmostPalindrome(arr, size, max, i + 1, j + 1);
    }

    // Private recursive method to check if a sequence is an almost palindrome
    // שיטה פרטית רקורסיבית לבדוק אם ריצף הוא כמעט פלינדרום
    private static int checkPalindrome(int[] arr, int size, boolean hasMismatched, int i, int j) {
        // Base case: If sequence has only one value, return its length
        // בסיס רקורסיה: אם לריצף יש רק ערך אחד, החזרת אורכו
        if (j - i == 0) {
            return size + 1;
        }

        // Base case: If i is greater than j, return current sequence size
        // בסיס רקורסיה: אם i גדול מ-j, החזרת גודל הריצף הנוכחי
        if (i > j) {
            return size;
        }

        // If the values at indices i and j are the same, move inwards
        // אם הערכים באינדקסים i ו-j זהים, תנועה פנימה
        if (arr[i] == arr[j]) {
            return checkPalindrome(arr, size + 2, hasMismatched, i + 1, j - 1);
        }

        // If there hasn't been a mismatch yet, try skipping either i or j to find almost palindrome
        // אם לא הייתה אי התאמה, נסיון לדלג על i או j למציאת כמעט פלינדרום
        if (!hasMismatched) {
            int skipI = checkPalindrome(arr, size + 1, true, i + 1, j); // Skip i
            int skipJ = checkPalindrome(arr, size + 1, true, i, j - 1); // Skip j
            // Return the longer of the two sequences
            // החזרת הריצף הארוך מבין השניים
            return Math.max(skipI, skipJ);
        }

        // If there's already been a mismatch, this sequence cannot be an almost palindrome
        // אם כבר הייתה אי התאמה, הריצף לא יכול להיות כמעט פלינדרום
        return -1;
    }

    // Main method for testing
    // שיטה ראשית לבדיקת הפתרון
    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 3, 4, 10, 7, 3, 10};
        System.out.println(longestAlmostPalindrome(arr));
    }
}
