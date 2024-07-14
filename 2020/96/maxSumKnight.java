

public class maxSumKnight {
    

    public static int maxSumKnight(int[][] mat) {
        if (mat.length < 2) {
            return -1;
        }
        return maxSumKnight(mat, 0, 0, 0, mat[0][0]);
    }
    
    private static int maxSumKnight(int[][] mat, int i, int j, int sum, int prev) {
        // תנאים לבדיקה אם אינדקסים חורגים מגבולות המערך או אם ההפרש בין הערכים עולה על 2
        if (i < 0 || j < 0 || i > mat.length - 1 || j > mat[0].length - 1 || Math.abs(prev - mat[i][j]) > 1 || mat[i][j] == -1) {
            return -1;
        }
        
        // אם הגענו לסוף המערך, מחזירים את הסכום
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            return sum + mat[i][j];
        }
    
        prev = mat[i][j];
        sum += prev;
        mat[i][j] = -1; // מסמנים את התא שביקרנו בו
        
        // חישוב של כל 8 האפשרויות לתזוזת הפרש
        int opt1 = maxSumKnight(mat, i + 1, j + 2, sum, prev);
        int opt2 = maxSumKnight(mat, i + 1, j - 2, sum, prev);
        int opt3 = maxSumKnight(mat, i + 2, j + 1, sum, prev);
        int opt4 = maxSumKnight(mat, i + 2, j - 1, sum, prev);
        int opt5 = maxSumKnight(mat, i - 1, j + 2, sum, prev);
        int opt6 = maxSumKnight(mat, i - 1, j - 2, sum, prev);
        int opt7 = maxSumKnight(mat, i - 2, j + 1, sum, prev);
        int opt8 = maxSumKnight(mat, i - 2, j - 1, sum, prev);
        
        // מחזירים את הערך הגדול ביותר מכל האפשרויות
        return Math.max(Math.max(Math.max(opt1, opt2), Math.max(opt3, opt4)), Math.max(Math.max(opt5, opt6), Math.max(opt7, opt8)));
    }

    
}
