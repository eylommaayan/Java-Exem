public class get {

  
    public static int get(int[] b, int k) {
        if (k == 0) {
            // The first element of a is directly the first element of b
            return b[0];  
        } else {
            // For k > 0, the value at a[k] is the difference of b[k] and b[k - 1]
            return b[k] - b[k - 1];  
        }
    }
    


    public static int find(int[] b, int x) {
        int left = 0;  // אתחול המצביע השמאלי
        int right = b.length - 1;  // אתחול המצביע הימני
    
        while (left <= right) {  // המשך החיפוש כל עוד המצביעים לא חוצים
            int mid = (left + right) / 2;  // חישוב אינדקס האמצע
            int midValue = get(b, mid);  // שימוש בפונקציית get כדי לגשת לערך המקורי במערך a
    
            if (midValue == x) {  // אם הערך באינדקס האמצע הוא הערך המבוקש
                return mid;  // החזר את האינדקס
            } else if (midValue < x) {  // אם הערך המבוקש גדול מהערך באינדקס האמצע
                left = mid + 1;  // הזז את המצביע השמאלי ימינה מהאמצע
            } else {  // אם הערך המבוקש קטן מהערך באינדקס האמצע
                right = mid - 1;  // הזז את המצביע הימני שמאלה מהאמצע
            }
        }
    
        return -1;  // אם x לא נמצא במערך a, החזר -1
    }
} 