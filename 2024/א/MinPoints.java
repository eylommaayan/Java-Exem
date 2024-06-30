./*
	1- הבנת השאלה - יצירת מסלול מנימלי שבו המספר של הערך לא מתבטל עם האינדקסים של המשבצות.
	1- הצעד הקטן ביותר - ארבע אפשרויות למעלה למטה שמאלה וימינה + להוסיף 
	2- תנאי עצירה :
	   איפוס או הפכיה לשלילי את המספר במסלול.
	3- החזרת תשובה  - הגעה למשבצת הראשונה
	4- נתוני פונקציית עזר - אינדקס, מערך, תא יעד
כתיבת קוד */
public class MinPoints {
   
    private static int minPoints(int[][] m, int i, int j, int min, int temp, int before) {
        // Check if the current position is out of bounds
        if (i > m.length - 1 || j > m[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        
        // Check if the current position is the bottom-right corner (end of the path)
        if (i == m.length - 1 && j == m[0].length - 1) {
            if (temp + m[i][j] < 0) {
                return Math.abs(temp + m[i][j]) + 1;
            }
            return min + 1;
        }
        
        // Adjust min if the temporary sum becomes negative
        if (temp < 0) {
            min += Math.abs(before);
        }
        
        // Recursive calls to explore both down and right paths
        int down = minPoints(m, i + 1, j, min, temp + m[i][j], m[i][j]);
        int right = minPoints(m, i, j + 1, min, temp + m[i][j], m[i][j]);
        
        // Return the minimum of the two possible paths
        return Math.min(down, right);
    }
D    
    
}
