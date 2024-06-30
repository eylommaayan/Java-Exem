public class InyLisut_4 {
    

    public void what(IntNode innerNode) {
        IntNode tmp = _head; // משתנה זמני שמתחיל מהראש של הרשימה
        int f = 1; // מונה למיקום שמתחיל ב-1 (מתחיל לספור מהראש)
        
        // לולאה למציאת המיקום של הצומת innerNode בתוך הרשימה
        while (tmp != innerNode) {
            f++; // מגדיל את המונה f בכל פעם שמתקדם לצומת הבא
            tmp = tmp.getNext(); // מעביר את tmp לצומת הבא ברשימה
        }
        
        int c = 1; // מונה לספירת הצמתים לאחר innerNode, מתחיל ב-1
        
        // בדיקה אם הצומת tmp הוא הצומת הבא של עצמו (מצב קצה שבו הצומת מצביע על עצמו)
        if (tmp == tmp.getNext()) {
            c = 1; // במצב כזה, יש רק צומת אחד אחרי innerNode
        } else {
            tmp = tmp.getNext(); // מעביר את tmp לצומת הבא
            // לולאה לספירת מספר הצמתים אחרי innerNode עד שחוזרים ל-innerNode
            while (tmp != innerNode) {
                c++; // מגדיל את המונה c בכל פעם שמתקדם לצומת הבא
                tmp = tmp.getNext(); // מעביר את tmp לצומת הבא ברשימה
            }
        }
        
        IntNode curr = innerNode.getNext(); // מצביע על הצומת הבא אחרי innerNode
        innerNode.setNext(null); // ניתוק הקשר של innerNode עם הצומת הבא
        
        IntList innerList = secret(); // יצירת רשימה הפוכה של הצמתים אחרי innerNode
        
        int s = 0; // מונה לספירת הצמתים ברשימה מהצומת curr
        tmp = curr; // מאתחל את tmp מחדש לצומת curr
        
        // לולאה לספירת מספר הצמתים הכולל ברשימה מהצומת curr
        while (tmp != null) {
            tmp = tmp.getNext(); // מעביר את tmp לצומת הבא ברשימה
            s++; // מגדיל את המונה s בכל פעם שמתקדם לצומת הבא
        }
        
        // עדכון ראש הרשימה הראשית לראש הרשימה ההפוכה שנוצרה
        _head = (innerList.secret())._head;
        
        // חיבור הצומת innerNode לצומת הבא ברשימה שהופרדה
        innerNode.setNext(curr);
        
        tmp = _head; // מאתחל את tmp מחדש לראש הרשימה המעודכנת
        int pos = (f + s - c) / 2; // חישוב המיקום הממוצע לשילוב מחדש של innerNode
        
        tmp = _head; // מאתחל שוב את tmp לראש הרשימה
        // לולאה למציאת המיקום הממוצע ברשימה לשילוב מחדש של innerNode
        for (int i = 1; i < pos + c; i++) {
            tmp = tmp.getNext(); // מעביר את tmp לצומת הבא ברשימה
        }
        
        tmp.setNext(null); // ניתוק הקשר של הצומת שנמצא במיקום הממוצע מהצומת הבא שלו
    }
    
}
