

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


    public boolean what2(IntList list) {
        IntNode h1 = _head; // Pointer to the head of the current list
    
        // Outer loop runs as long as h1 is not null (i.e., we haven't reached the end of the current list)
        while (h1 != null) {
            boolean found = false; // Flag to indicate if a matching value is found in the second list
            IntNode h2 = list._head; // Pointer to the head of the second list
    
            // Inner loop runs as long as h2 is not null and the found flag is false
            while ((h2 != null) && (!found)) {
                // If the values of the current nodes are equal, set the found flag to true
                if (h1.getValue() == h2.getValue())
                    found = true;
                // Move to the next node in the second list
                h2 = h2.getNext();
            }
    
            // If no matching value is found in the second list, return false
            if (!found)
                return false;
            
            // Move to the next node in the current list
            h1 = h1.getNext();
        }
    
        // If all nodes are found in the second list, return true
        return true;
    }
    
}




