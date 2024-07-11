public class frinds3 {
    
    public static int friends3(int[][] mat) {
        return friends3(mat, 0, 0, 0, new int[3], 0);
    }
    
    // פונקציה פרטית רקורסיבית שמבצעת את החישוב
    private static int friends3(int[][] mat, int i, int j, int k, int[] circle, int count) {
        // תנאי עצירה: אם הגענו לסוף המטריצה
        if (i == mat.length) {
            return count; // מחזירים את מספר מעגלי ההכרות שמצאנו
        }
    
        // אם הגענו לסוף השורה הנוכחית, עוברים לשורה הבאה
        if (j == mat.length) {
            return friends3(mat, i + 1, 0, 0, circle, count);
        }
    
        // אם הגענו לסוף העמודה הנוכחית, עוברים לעמודה הבאה
        if (k == mat.length) {
            return friends3(mat, i, j + 1, 0, circle, count);
        }
    
        // בדיקה אם i < j < k והאם mat[i][j] == 1, mat[j][k] == 1, ו-mat[k][i] == 1
        if (i < j && j < k && mat[i][j] == 1 && mat[j][k] == 1 && mat[k][i] == 1) {
            circle[0] = i; // מאחסנים את i במעגל
            circle[1] = j; // מאחסנים את j במעגל
            circle[2] = k; // מאחסנים את k במעגל
            System.out.println(circle[0] + " " + circle[1] + " " + circle[2]); // מדפיסים את המעגל
            count++; // מגדילים את מספר המעגלים שנמצאו
        }
    
        // קריאה רקורסיבית לעמודה הבאה
        return friends3(mat, i, j, k + 1, circle, count);
    }
    


}
