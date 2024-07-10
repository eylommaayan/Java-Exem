package 2023.79;

public class BinaryTree {
    
    public class BinaryTree {
        // פונקציה שמחזירה את הערך המקסימלי בתת-העץ שמתחיל בצומת t
        public static int secret(Node t) {
            int val = t.getNumber(); // קבלת המספר בצומת הנוכחי
    
            // אם הצומת הנוכחי הוא עלה, מחזירים את הערך שלו
            if (t.getLeftSon() == null && t.getRightSon() == null)
                return val;
    
            // אם יש בן שמאלי, מחשבים את הערך המקסימלי בתת-העץ השמאלי
            if (t.getLeftSon() != null)
                val = Math.max(val, secret(t.getLeftSon()));
    
            // אם יש בן ימני, מחשבים את הערך המקסימלי בתת-העץ הימני
            if (t.getRightSon() != null)
                val = Math.max(val, secret(t.getRightSon()));
    
            return val; // מחזירים את הערך המקסימלי שנמצא
        }
    
        // פונקציה שבודקת אם כל ערך מקסימלי בתת-העץ השמאלי של כל צומת קטן או שווה לערך המקסימלי בתת-העץ הימני שלו
        public static boolean what(Node t) {
            // אם הצומת הוא עלה או שיש לו רק בן אחד, מחזירים true
            if (t.getLeftSon() == null || t.getRightSon() == null)
                return true;
    
            // אם הערך המקסימלי בתת-העץ השמאלי גדול מהערך המקסימלי בתת-העץ הימני, מחזירים false
            if (secret(t.getLeftSon()) > secret(t.getRightSon()))
                return false;
    
            // בדיקה רקורסיבית על תתי-העצים השמאלי והימני
            return what(t.getLeftSon()) && what(t.getRightSon());
        }
    }
    
}
