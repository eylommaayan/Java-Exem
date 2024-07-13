

public class IntList {
 
    private IntNode _head; // משתנה המצביע על ראש הרשימה

    // בנאי ברירת מחדל - יוצר רשימה ריקה
    public IntList() {
        _head = null;
    }



    // פונקציה לבדיקת שוויון בין שתי רשימות
    public boolean what1(IntList list) {
        IntNode h1 = _head; // משתנה המצביע על ראש הרשימה הנוכחית
        IntNode h2 = list._head; // משתנה המצביע על ראש הרשימה השנייה
        // לולאה שרצה כל עוד לא הגענו לסוף אחת מהרשימות
        while ((h1 != null) && (h2 != null)) {
            // אם הערכים של האיברים הנוכחיים אינם שווים, מחזירים false
            if (h1.getValue() != h2.getValue())
                return false;
            h1 = h1.getNext(); // מעבר לאיבר הבא ברשימה הנוכחית
            h2 = h2.getNext(); // מעבר לאיבר הבא ברשימה השנייה
        }
        return true; // אם כל האיברים שווים, מחזירים true
    }
}




