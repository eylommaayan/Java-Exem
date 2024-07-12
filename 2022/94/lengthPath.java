public class lengthPath {
    

    public class LengthPath {

        // פונקציה ראשית שמתחילה את הקריאה הרקורסיבית
        public static int lengthPath(char[][] mat, String pattern) {
            // בודקים אם התו הראשון במטריצה נמצא ב-pattern
            if (pattern.indexOf(mat[0][0]) == -1) return 0;
            // מתחילים את הקריאה הרקורסיבית מהתא הראשון (0,0) עם אורך תוואי התחלתי 0
            return lengthPath(mat, pattern, 0, 0, 0);
        }
    
        // פונקציה רקורסיבית שמחשבת את אורך התוואי הארוך ביותר במטריצה
        public static int lengthPath(char[][] mat, String pattern, int x, int y, int len) {
            // תנאי עצירה - אם חרגנו מגבולות המטריצה, או הגענו לתא שכבר ביקרנו בו, או לתו שלא נמצא ב-pattern
            if (x<0 || y<0 || x>=mat.length || y>=mat[0].length || mat[x][y] == '-' || pattern.indexOf(mat[x][y]) == -1)
                return len; // מחזירים את האורך הנוכחי של התוואי
    
            // שמירת הערך הנוכחי של התא למקרה שנצטרך לשחזר אותו בהמשך
            char temp = mat[x][y];
            // מסמנים את התא הנוכחי כ-'-' כדי למנוע חזרה אליו
            mat[x][y] = '-';
    
            // קריאות רקורסיביות לכל ארבעת הכיוונים האפשריים (למעלה, למטה, שמאלה, ימינה)
            int maxLen = Math.max(Math.max(lengthPath(mat, pattern, x-1, y, len+1), // למעלה
                                           lengthPath(mat, pattern, x+1, y, len+1)), // למטה
                                  Math.max(lengthPath(mat, pattern, x, y-1, len+1), // שמאלה
                                           lengthPath(mat, pattern, x, y+1, len+1))); // ימינה
    
            // שחזור הערך המקורי של התא אחרי הקריאות הרקורסיביות
            mat[x][y] = temp;
            // החזרת האורך המקסימלי שנמצא
            return maxLen;
        }
    
        public static void main(String[] args) {
            // דוגמה למטריצה ול-pattern
            char[][] mat = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
            };
            String pattern = "abc";
            // קריאה לפונקציה הראשית והדפסת התוצאה
            System.out.println(lengthPath(mat, pattern)); // הפלט יהיה 3
        }
    }
    
    
}
