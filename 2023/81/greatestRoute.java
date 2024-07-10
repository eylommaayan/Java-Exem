
public class greatestRoute {
 
    public static int greatestRoute(int[][] mat) {
        int[][] trackMat = new int[mat.length][mat[0].length]; // מטריצה שמעקב אחרי מספר הביקורים בכל תא
        copyMatrix(mat, trackMat, 0, 0); // העתקת המטריצה המקורית למטריצת המעקב
        return greatestRoute(mat, trackMat, 0, 0, "", 0, Integer.MIN_VALUE); // קריאה לפונקציה רקורסיבית שמתחילה מהתא הראשון
    }
    

    


    private static void copyMatrix(int[][] source, int[][] destination, int row, int col) {
        if (row >= source.length) {
            return; // תנאי עצירה אם עברנו על כל השורות
        }
        destination[row][col] = source[row][col]; // העתקת הערך מהמטריצה המקורית למטריצת המעקב
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol >= source[0].length) {
            nextRow++;
            nextCol = 0;
        }
        copyMatrix(source, destination, nextRow, nextCol); // קריאה רקורסיבית לעמודה הבאה
    }
    

    private static int greatestRoute(int[][] mat, int[][] trackMat, int i, int j, String path, int sum, int max) {
        if (i == mat.length - 1 && j == mat[0].length - 1) { // אם הגענו לתא היעד
            sum += mat[i][j]; // הוספת הערך של תא היעד לסכום
            System.out.println(path + " (" + i + "," + j + ") = " + sum);
            return Math.max(max, sum); // החזרת הסכום המקסימלי
        } else if (trackMat[i][j] > 0) { // אם התא יכול להיות מבוקר
            sum += mat[i][j]; // הוספת הערך של התא הנוכחי לסכום
            path += " (" + i + "," + j + ") --> "; // עדכון הנתיב
            trackMat[i][j]--; // הפחתת מספר הביקורים האפשריים בתא
    
            if (i < mat.length - 1) // תנועה למטה
                max = greatestRoute(mat, trackMat, i + 1, j, path, sum, max);
            if (j > 0) // תנועה שמאלה
                max = greatestRoute(mat, trackMat, i, j - 1, path, sum, max);
            if (j < mat[0].length - 1) // תנועה ימינה
                max = greatestRoute(mat, trackMat, i, j + 1, path, sum, max);
            if (i > 0) // תנועה למעלה
                max = greatestRoute(mat, trackMat, i - 1, j, path, sum, max);
    
            trackMat[i][j]++; // שחזור מספר הביקורים האפשריים בתא עבור נתיבים אחרים
        }
        return max; // החזרת הסכום המקסימלי
    }
    
}
