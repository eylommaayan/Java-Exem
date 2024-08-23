public class findWord {
     /*
     * הפונקציה findWord אחראית על מציאת המילה בטבלת התווים,
     * וקוראת לפונקציות נוספות על מנת לבצע את החיפוש
     *  היא יוצרת מערך דו-ממדי של מספרים
     *  (a)
     *  בגודל של טבלת התווים ומתחילה את החיפוש מהמקום הראשון בטבלה.
     */
    public static void findWord(char[][] arr, String word) {
        int[][] a = new int[arr.length][arr[0].length];  // יצירת מערך שלם בגודל הטבלה
        findWord(arr, word, 0, 0, a, 1);  // קריאה לפונקציה עם מיקום התחלתי 0,0
        printArr(a);  // הדפסת המערך לאחר החיפוש
    }
    //פונקציה זו אחראית על חיפוש המילה בכל תא של הטבלה ובדיקת ההתאמה לתו הראשון של המילה. אם נמצא תו מתאים, היא קוראת לפונקציה search.
    public static void findWord(char[][] arr, String word, int i, int j, int[][] a, int count) {
        if (i > arr.length - 1 || j > arr[0].length - 1) {  // תנאי עצירה: אם חרגנו ממידות הטבלה
            System.out.println("No Such Word");  // הודעה אם לא נמצאה המילה
            return;
        }
        if (arr[i][j] == word.charAt(0) && search(arr, word, i, j, a, count)) {  // בדיקה אם התו מתאים וקריאה לפונקציית החיפוש
            return;
        }
        if (j == arr[0].length - 1) {
            findWord(arr, word, i + 1, 0, a, count);  // מעבר לשורה הבאה אם הגענו לסוף השורה הנוכחית
        } else {
            findWord(arr, word, i, j + 1, a, count);  // מעבר לתא הבא באותה השורה
        }
    }
    //פונקציה זו אחראית על החיפוש הרקורסיבי של המשך המילה בארבעה כיוונים (למעלה, למטה, ימין ושמאל).
    public static boolean search(char[][] arr, String word, int i, int j, int[][] a, int count) {
        if (word.length() == 0) {  // אם הגענו לסוף המילה, החיפוש הסתיים בהצלחה
            return true;
        } else if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1 
                   || arr[i][j] != word.charAt(0) || arr[i][j] == '0') {  // תנאי עצירה אם חרגנו מהטבלה או אם התו לא מתאים
            return false;
        }
        char temp = arr[i][j];  // שמירת התו הנוכחי לפני שינויו
        arr[i][j] = '0';  // סימון התו הנוכחי כ'ביקרנו כאן'
        boolean up = search(arr, word.substring(1), i - 1, j, a, count + 1);  // חיפוש למעלה
        boolean down = search(arr, word.substring(1), i + 1, j, a, count + 1);  // חיפוש למטה
        boolean right = search(arr, word.substring(1), i, j + 1, a, count + 1);  // חיפוש ימינה
        boolean left = search(arr, word.substring(1), i, j - 1, a, count + 1);  // חיפוש שמאלה
        arr[i][j] = temp;  // שחזור התו המקורי
        if (up || down || right || left) {
            a[i][j] = count;  // סימון המיקום במערך המסלול
            return true;
        }
        return false;
    }
    
}
