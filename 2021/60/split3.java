public class split3 {
    

    public static boolean split3(int[] arr) {
        // קריאה לפונקציה רקורסיבית עם פרמטרים התחליים:
        // arr - המערך לבדיקה
        // 0 - אינדקס התחלתי
        // 0 - סכום הקבוצה הראשונה ההתחלתית
        // 0 - סכום הקבוצה השנייה ההתחלתית
        // 0 - סכום הקבוצה השלישית ההתחלתית
        return split3(arr, 0, 0, 0, 0);
    }
    
    private static boolean split3(int[] arr, int i, int set1, int set2, int set3) {
        // תנאי עצירה: אם הגענו לסוף המערך
        if (i == arr.length) {
            // בדיקה אם סכום כל שלוש הקבוצות שווה
            return set1 == set2 && set1 == set3;
        }
    
        // קריאה רקורסיבית עם שלוש אפשרויות:
        // 1. הוספת האיבר הנוכחי לקבוצה הראשונה
        // 2. הוספת האיבר הנוכחי לקבוצה השנייה
        // 3. הוספת האיבר הנוכחי לקבוצה השלישית
        // אם אחת מהקריאות מחזירה true, הפונקציה תחזיר true
        return split3(arr, i + 1, set1 + arr[i], set2, set3) ||
               split3(arr, i + 1, set1, set2 + arr[i], set3) ||
               split3(arr, i + 1, set1, set2, set3 + arr[i]);
    }
    

}
