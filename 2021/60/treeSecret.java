
public class treeSecret {

    
    public static boolean treeSecret(Node ptr) {
        // אם המצביע הוא null, כלומר הגענו לסוף הענף, נחזיר true
        if (ptr == null)
            return true;
        
        // אם המצביע הוא עלה, כלומר אין לו בנים, נחזיר true
        if (ptr.getLeftSon() == null && ptr.getRightSon() == null)
            return true;
        
        // אם יש לו רק בן ימין
        if (ptr.getLeftSon() == null)
            // נבדוק שההפרש בין המספר של האב למספר של בן ימין קטן או שווה ל-1
            // ונמשיך לבדוק רקורסיבית את תת-העץ הימני
            return (Math.abs(ptr.getNumber() - ptr.getRightSon().getNumber()) <= 1) &&
                   treeSecret(ptr.getRightSon());
        
        // אם יש לו רק בן שמאל
        if (ptr.getRightSon() == null)
            // נבדוק שההפרש בין המספר של האב למספר של בן שמאל קטן או שווה ל-1
            // ונמשיך לבדוק רקורסיבית את תת-העץ השמאלי
            return (Math.abs(ptr.getNumber() - ptr.getLeftSon().getNumber()) <= 1) &&
                   treeSecret(ptr.getLeftSon());
        
        // אם יש לו שני בנים, נבדוק שההפרש בין המספר של האב למספר של כל אחד מהבנים
        // קטן או שווה ל-1 ונמשיך לבדוק רקורסיבית את תת-העץ הימני והשמאלי
        return Math.abs(ptr.getNumber() - ptr.getLeftSon().getNumber()) <= 1 &&
               Math.abs(ptr.getNumber() - ptr.getRightSon().getNumber()) <= 1 &&
               treeSecret(ptr.getLeftSon()) &&
               treeSecret(ptr.getRightSon());
    }

    
}
