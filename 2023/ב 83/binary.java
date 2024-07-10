public class  binary {

    public static boolean what(Node node) {
        // אם הצומת הוא null, מחזירים false
        if (node == null)
            return false;
        // אם לצומת אין ילדים (גם שמאלי וגם ימני), מחזירים true
        if (node.getLeftSon() == null && node.getRightSon() == null)
            return true;
        // אחרת, מחזירים false
        return false;
    }

    
    public static boolean secret(Node node) {
        int res1; // משתנה לאחסון הערך של הצומת השמאלי
        int res2; // משתנה לאחסון הערך של הצומת הימני
    
        // אם הצומת הוא null או שהפונקציה what מחזירה true, מחזירים true
        if (node == null || what(node))
            return true;
    
        // בודקים רקורסיבית את התנאי על הצמתים השמאלי והימני
        if (secret(node.getLeftSon()) && secret(node.getRightSon())) {
            // חישוב res1
            if (node.getLeftSon() == null) {
                res1 = 0; // אם אין צומת שמאלי, הערך הוא 0
            } else if (what(node.getLeftSon())) {
                res1 = node.getLeftSon().getNumber(); // אם הצומת השמאלי הוא עלה, הערך הוא המספר בצומת
            } else {
                res1 = 2 * node.getLeftSon().getNumber(); // אם הצומת השמאלי הוא לא עלה, הערך הוא פי 2 מהמספר בצומת
            }
    
            // חישוב res2
            if (node.getRightSon() == null) {
                res2 = 0; // אם אין צומת ימני, הערך הוא 0
            } else if (what(node.getRightSon())) {
                res2 = node.getRightSon().getNumber(); // אם הצומת הימני הוא עלה, הערך הוא המספר בצומת
            } else {
                res2 = 2 * node.getRightSon().getNumber(); // אם הצומת הימני הוא לא עלה, הערך הוא פי 2 מהמספר בצומת
            }
    
            // אם סכום הערכים של הצומת הנוכחי שווה לסכום res1 + res2, מחזירים true
            if (node.getNumber() == res2 + res1)
                return true;
            else
                return false;
        }
        return false;
    }
    

}