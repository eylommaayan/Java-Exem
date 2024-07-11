

public class countPairs {
    

    public static int countPairs(int n) {
        return countPairs(n, "", 0, 0);
    }
    
    public static int countPairs(int n, String expression, int open, int close) {
        // אם מספר הסוגרים הפתוחים או הסוגרים גדול מ-n, השיטה מחזירה 0
        if (open > n || close > open) return 0;
    
        // אם מספר הסוגרים הסגורים שווה ל-n, מדפיסים את הביטוי ומחזירים 1
        if (close == n) {
            System.out.println(expression);
            return 1;
        }
    
        // קריאה רקורסיבית להוספת סוגר פתוח או סגור לביטוי
        return countPairs(n, expression + "(", open + 1, close)
            + countPairs(n, expression + ")", open, close + 1);
    }
    
    
}
