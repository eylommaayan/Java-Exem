

public class countPairs {

    // פונקציה ראשית שמתחילה את התהליך
    public static int countPairs(int n) {
        return countPairs(n, 0, 0, "");
    }

    // פונקציה רקורסיבית שמחשבת את מספר הזוגות ומדפיסה את הביטויים החוקיים
    private static int countPairs(int n, int open, int close, String s) {
        // אם מספר הסוגריים השמאליים עולה על n או מספר הסוגריים הימניים עולה על מספר הסוגריים השמאליים, הביטוי לא חוקי
        if (open > n || close > open) {
            return 0;
        }

        // אם מספר הסוגריים השמאליים והימניים שווה ל-n, והם שווים, הביטוי חוקי
        if (open == close && open == n) {
            // מדפיס את הביטוי החוקי
            System.out.println(s);
            return 1;
        }

        // קריאה רקורסיבית להוספת סוגר שמאלי והתקדמות עם סוגר שמאלי נוסף
        int openPairs = countPairs(n, open + 1, close, s + "(");
        // קריאה רקורסיבית להוספת סוגר ימני והתקדמות עם סוגר ימני נוסף
        int closePairs = countPairs(n, open, close + 1, s + ")");
        
        // מחזיר את סכום התוצאות של הקריאות הרקורסיביות
        return openPairs + closePairs;
    }

    // פונקציה ראשית להרצת הדוגמה
    public static void main(String[] args) {
        int n = 3; // ניתן לשנות את הערך ל-n אחר
        int count = countPairs(n);
        // מדפיס את סך כל הזוגות החוקיים
        System.out.println("Total pairs: " + count);
    }
}
