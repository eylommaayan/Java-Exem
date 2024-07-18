

public class isJump {
    

    public static boolean isJump(String str1, String str2, int step) {
        // קריאה לפונקציה הפרטית עם פרמטרים התחלתיים (i=0, j=0)
        return isJump(str1, str2, step, 0, 0);
    }
    
    // פונקציה רקורסיבית שבודקת אם ניתן למצוא את str2 בתוך str1 עם קפיצות של step
    private static boolean isJump(String str1, String str2, int step, int i, int j) {
        // תנאי עצירה - אם הגענו לסוף של str2, הפונקציה מחזירה true
        if (j == str2.length()) {
            return true;
        }
        // תנאי עצירה - אם חרגנו מגבולות str1 או str2 ארוכה יותר מ-str1 או התו הראשון לא שווה, הפונקציה מחזירה false
        if (i >= str1.length() || str1.length() < str2.length() || str1.charAt(0) != str2.charAt(0)) {
            return false;
        }
        // אם התו ב-str2 באינדקס j שווה לתו ב-str1 באינדקס i, ממשיכים לבדוק עם קפיצה של step
        if (str2.charAt(j) == str1.charAt(i)) {
            return isJump(str1, str2, step, i + step, j + 1);
        }
        return false;
    }

    
    public static int strStep(String str1, String str2) {
        // קריאה לפונקציה הפרטית עם פרמטרים התחלתיים (step=1)
        return strStep(str1, str2, 1);
    }
    
    // פונקציה רקורסיבית שבודקת את הקפיצה המינימלית האפשרית עבור str2 ב-str1
    private static int strStep(String str1, String str2, int step) {
        // תנאי עצירה - אם step גדול מדי ולא ניתן להכניס את str2 ב-str1, הפונקציה מחזירה -1
        if (step > (str1.length() - str2.length() - 1)) {
            return -1;
        }
        // בודקים אם ניתן להכניס את str2 ב-str1 עם הקפיצות הנוכחיות
        if (isJump(str1, str2, step)) {
            return step; // מחזירים את הערך של step אם אפשר
        }
        // ממשיכים לקריאה הרקורסיבית עם step מוגדל ב-1
        return strStep(str1, str2, step + 1);
    }
    
}
