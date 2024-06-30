public class Array_2 {
    public static int get(int[]b, int k){
        if (k == 0) {
            // The first element of a is directly the first element of b
            return b[0];
        } else {
            // For k > 0, the value at a[k] is the difference of b[k] and b[k-1]
            return b[k] - b[k - 1];
        }
    } 


    public static int find(int[] b, int x) {
        int left = 0;
        int right = b.length - 1;
    
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = get(b, mid); // השתמש בפונקציה get כדי לקבל את הערך המקורי ב-a עבור האינדקס mid
    
            if (midValue == x) {
                return mid; // x נמצא, החזר את האינדקס שלו
            } else if (midValue < x) {
                left = mid + 1; // x גדול יותר, התעלם מהחלק השמאלי
            } else {
                right = mid - 1; // x קטן יותר, התעלם מהחלק הימני
            }
        }
        // x לא נמצא ב-a
        return -1;
    }
    
}
