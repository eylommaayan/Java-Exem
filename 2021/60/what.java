

public class what {
 
    
    public int what() {
        int count = 0, res = 0, m = -1;
        IntNode temp = _head;
        
        // שלב ראשון: מציאת המועמד הפוטנציאלי
        while (temp != null) {
            if (count == 0) {
                m = temp.getValue(); // אם הספירה היא 0, קובע את הערך הנוכחי כערך המועמד
                count = 1; // מתחיל לספור מופעים של המועמד
            } else {
                if(temp.getValue() == m) {
                    count++; // מגדיל את הספירה אם הערך הנוכחי שווה למועמד
                } else {
                    count--; // מקטין את הספירה אם הערך הנוכחי שונה מהמועמד
                }
            }
            res++; // מונה את מספר הצמתים
            temp = temp.getNext(); // עובר לצומת הבא ברשימה
        }
        
        // שלב שני: אימות המועמד
        count = 0;
        temp = _head;
        while (temp != null) {
            if (temp.getValue() == m) {
                count++; // מגדיל את הספירה עבור מופעים של המועמד
            }
            temp = temp.getNext(); // עובר לצומת הבא ברשימה
        }
        
        if (count > res / 2) {
            return m; // אם למועמד יש יותר ממחצית המופעים ברשימה, מחזיר אותו
        } else {
            return -9999; // אחרת, מחזיר ערך מיוחד המציין שאין מועמד
        }
    }
    
}
