
public class isIdentity {
    

    public static boolean isIdentity(int[][] mat, int x, int size) {
        return isIdentity(mat, x, size, x, x); // קריאה לפונקציה הרקורסיבית עם הפרמטרים ההתחלתיים
    }
    
    
    private static boolean isIdentity(int[][] mat, int x, int size, int i, int j) {
        if ((i == j && mat[i][j] != 1) || (i != j && mat[i][j] != 0)) // בדיקה אם האלכסון הוא 1 ושאר האלמנטים הם 0
            return false; // אם התנאים לא מתקיימים, נחזיר false
        if (j < x + size - 1) // אם האינדקס j קטן מהקצה הימני של תת-המרובע
            return isIdentity(mat, x, size, i, j + 1); // נקדם את j ונמשיך לבדוק בעמודות
        if (i < x + size - 1) // אם האינדקס i קטן מהקצה התחתון של תת-המרובע
            return isIdentity(mat, x, size, i + 1, x); // נקדם את i ונמשיך לבדוק בשורות ונאפס את j
        return true; // אם סיימנו לבדוק את כל האלמנטים בתת-המרובע והם מקיימים את התנאים, נחזיר true
    }

    private static int maxMatrix(int[][] mat, int x, int size) {
        if (size < 1) // אם גודל המטריצה קטן מ-1, אין מטריצת זהות מרכזית
            return -1; // נחזיר -1 שמציין שאין מטריצת זהות מרכזית
    
        if (isIdentity(mat, x, size)) // בדיקה אם תת-המרובע בגודל הנתון הוא מטריצת זהות
            return size; // אם כן, נחזיר את הגודל של המטריצה
    
        return maxMatrix(mat, x + 1, size - 2); // נמשיך עם המטריצה המרכזית הבאה: נעדכן את האינדקס התחלתי (x+1) ונקטין את הגודל ב-2
    }
    
}
