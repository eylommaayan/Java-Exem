

public class printSecret {
  
    public static boolean printSecret(Node node, int target) {
        // אם הצומת הנוכחי הוא null, כלומר, אם הגעת לסוף ענף בעץ ואין עוד צמתים לבדוק
        if (node == null)
            return false; // מחזיר false כי לא מצאנו את הערך המבוקש
    
        // אם הערך של הצומת הנוכחי שווה לערך המבוקש
        if (node.getNumber() == target)
            return true; // מחזיר true כי מצאנו את הערך המבוקש
    
        // בדיקה רקורסיבית של הצמתים השמאלי והימני
        // אם מצאנו את הערך המבוקש באחד הענפים (שמאלי או ימני)
        if (printSecret(node.getLeftSon(), target) || printSecret(node.getRightSon(), target)) {
            System.out.print(node.getNumber() + " "); // מדפיס את הערך של הצומת הנוכחי
            return true; // מחזיר true כי מצאנו את הערך המבוקש
        }
    
        return false; // אם לא מצאנו את הערך המבוקש באף ענף, מחזיר false
    }
    
    
}
