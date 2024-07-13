
public class printExpr {
    

    public static int printExpr(int[] arr, int num) {
        // קריאה לפונקציה הפרטית עם פרמטרים התחלתיים (i=0, s="")
        return printExpr(arr, num, 0, "");
    }
    
    // פונקציה רקורסיבית שמחשבת את כל הדרכים להגיע למספר המבוקש num מהמערך arr
    private static int printExpr(int[] arr, int num, int i, String s) {
        // תנאי עצירה - אם הגענו לסוף המערך
        if (i == arr.length) {
            // אם הסכום הנוכחי שווה ל-num, הדפסת השרשרת והחזרת 1
            if (num == 0) {
                System.out.println(s);
                return 1;
            }
            // אם לא, החזרת 0
            else return 0;
        }
    
        // קריאה רקורסיבית עם הוספת הערך הנוכחי וחיסורו מ-num
        int plus = printExpr(arr, num - arr[i], i + 1, s + " +" + arr[i]);
        // קריאה רקורסיבית עם הוספת הערך הנוכחי והוספתו ל-num
        int minus = printExpr(arr, num + arr[i], i + 1, s + " -" + arr[i]);
        // קריאה רקורסיבית ללא הוספת הערך הנוכחי (מעבר לערך הבא)
        int nothing = printExpr(arr, num, i + 1, s);
        
        // החזרת סך כל התוצאות שהושגו מכל הקריאות הרקורסיביות
        return plus + minus + nothing;
    }
    


}
