./*
	1- הבנת השאלה - יצירת מסלול מנימלי שבו המספר של הערך לא מתבטל עם האינדקסים של המשבצות.
	1- הצעד הקטן ביותר - ארבע אפשרויות למעלה למטה שמאלה וימינה + להוסיף 
	2- תנאי עצירה :
	   איפוס או הפכיה לשלילי את המספר במסלול.
	3- החזרת תשובה  - הגעה למשבצת הראשונה
	4- נתוני פונקציית עזר - אינדקס, מערך, תא יעד
*/

public static int minPoints(int[][] m) {
    int row = m.length;
    int col = m[0].length;
    return minPoints(m, row - 1, col - 1, new int[row][col]); // קריאה לפונקציה הרקורסיבית עם משתני עזר
    // Call the recursive function with helper variables
}

private static int minPoints(int[][] m, int i, int j, int[][] temp) {
    if (i == 0 && j == 0) { // אם הגענו לתא היעד
        return Math.max(1, 1 - m[0][0]); // מחזירים את הערך המקסימלי בין 1 לבין 1 פחות הערך בתא ההתחלתי
        // Base case: destination cell
    }
    if (temp[i][j] != 0) { // אם התוצאה כבר חושבה
        return temp[i][j]; // מחזירים את התוצאה החישובית שנשמרה
        // Check if the result is already computed
    }
    int left = Integer.MAX_VALUE; // מאתחלים את הערך של התא השמאלי לערך מקסימלי
    int up = Integer.MAX_VALUE; // מאתחלים את הערך של התא העליון לערך מקסימלי
    if (j > 0) { // אם יש תא שמאלי
        left = Math.max(1, minPoints(m, i, j - 1, temp) - m[i][j]); // מחשבים את הערך המינימלי הדרוש מתא שמאלי
        // Calculate minimum number needed if coming from the left
    }
    if (i > 0) { // אם יש תא עליון
        up = Math.max(1, minPoints(m, i - 1, j, temp) - m[i][j]); // מחשבים את הערך המינימלי הדרוש מתא עליון
        // Calculate minimum number needed if coming from above
    }
    temp[i][j] = Math.min(left, up); // בוחרים את הנתיב שדורש את המספר ההתחלתי המינימלי
    // Choose the path that requires the minimum initial number
    return temp[i][j]; // מחזירים את הערך המחושב עבור התא הנוכחי
}

