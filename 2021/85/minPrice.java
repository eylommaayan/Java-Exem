
public class minPrice {
    

    public static int minPrice(int[][] mat) {
        return minPrice(mat, 0, 0, 0);
    }
    
    // פונקציה רקורסיבית למציאת העלות המינימלית
    private static int minPrice(int[][] mat, int i, int j, int sum) {
        // תנאי עצירה - כאשר יוצאים מהגבולות של המטריצה או כאשר המיקום הנוכחי לא חוקי
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[i].length || mat[i][j] == -1) {
            return Integer.MAX_VALUE;
        }
        
        // תנאי עצירה - כאשר מגיעים לעמודה האחרונה בשורה הנוכחית
        if (j == mat[i].length - 1) {
            return sum + mat[i][j];
        }
    
        // חישוב העלות המינימלית על ידי מעבר לשורה הבאה או לעמודה הבאה
        return Math.min(
            minPrice(mat, i + 1, j, sum + mat[i][j]),
            minPrice(mat, i, j + 1, sum + mat[i][j])
        );
    }

    
}
