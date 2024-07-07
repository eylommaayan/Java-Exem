

public class countPairs {
    

    public static int countPairs(int n) {
        return countPairs(n, n, ""); // קריאה לפונקציה הרקורסיבית עם n זוגות סוגריים ו-toPrint התחלתי ריק
    }

    private static int countPairs(int left, int right, String toPrint) {
        // אנחנו עוצרים כשלא ניתן לשים עוד סוגריים ימניים - כשכל הסוגריים הימניים נוצלו.
        if (right == 0) {
            System.out.println(toPrint); // מדפיסים את הביטוי התקני שמצאנו
            return 1; // מצאנו ביטוי תקני נוסף
        }
    
        int count = 0; // משתנה לספירת הביטויים התקניים שמצאנו
    
        // הוספת סוגר שמאלי
        if (left > 0)
            count += countPairs(left - 1, right, toPrint + "("); // קריאה רקורסיבית לאחר הוספת סוגר שמאלי
    
        // הוספת סוגר ימני
        if (left < right)
            count += countPairs(left, right - 1, toPrint + ")"); // קריאה רקורסיבית לאחר הוספת סוגר ימני
    
        return count; // החזרת מספר הביטויים התקניים שמצאנו
    }
    
}
