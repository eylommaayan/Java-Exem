public class MinDifference {

    // פונקציה ראשית שמתחילה את התהליך של מציאת ההפרש המינימלי
    public static int minDiff(int[] arr) {
        // קריאה לפונקציה הרקורסיבית עם האינדקס ההתחלתי (0) ושני הסכומים ההתחלתיים של שתי הקבוצות (0)
        return minDiff(arr, 0, 0, 0);
    }

    // פונקציה רקורסיבית למציאת ההפרש המינימלי בין שתי קבוצות
    private static int minDiff(int[] arr, int i, int setA, int setB) {
        // תנאי עצירה: אם הגענו לסוף המערך (כלומר, עברנו על כל המספרים)
        if (i == arr.length) {
            // מחזירים את ההפרש המוחלט בין סכומי שתי הקבוצות
            return Math.abs(setA - setB);
        } else {
            // קריאה רקורסיבית ראשונה: מוסיפים את המספר הנוכחי לקבוצה A וממשיכים הלאה
            int set1 = minDiff(arr, i + 1, setA + arr[i], setB);
            
            // קריאה רקורסיבית שנייה: מוסיפים את המספר הנוכחי לקבוצה B וממשיכים הלאה
            int set2 = minDiff(arr, i + 1, setA, setB + arr[i]);
            
            // מחזירים את המינימום מבין שני ההפרשים שהתקבלו מהקריאות הרקורסיביות
            return Math.min(set1, set2);
        }
    }
}
