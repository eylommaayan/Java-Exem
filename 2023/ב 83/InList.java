
public class InList {
    

    public class IntList {
        private IntNode _head; // משתנה פרטי שמחזיק את ראש הרשימה המקושרת
    
        public IntList() {
            _head = null; // בנאי שמאתחל את ראש הרשימה כ-null
        }
    
        public IntList(IntNode node) {
            _head = node; // בנאי שמקבל צומת ומאתחל את ראש הרשימה לצומת זה
        }
    
        public void f(int num) {
            _head = f(_head, num); // פונקציה ציבורית שמוסיפה צומת חדש לרשימה לפי הסדר המתקבל מפונקציה פרטית
        }
    
        private IntNode f(IntNode p, int num) {
            if (p == null) // אם הגענו לסוף הרשימה או אם הרשימה ריקה
                return new IntNode(num); // מחזירים צומת חדש עם הערך num
            if (p.getValue() > num) // אם הערך בצומת הנוכחי גדול מהערך num
                return new IntNode(num, p); // יוצרים צומת חדש עם הערך num ומחברים אותו לפני הצומת הנוכחי
            p.setNext(f(p.getNext(), num)); // ממשיכים לבדוק רקורסיבית את הצומת הבא ברשימה
            return p; // מחזירים את הצומת הנוכחי לאחר עדכון הקישור לצומת הבא
        }
    
        public void g(int num) {
            _head = g(_head, num); // פונקציה ציבורית שמוסיפה צומת חדש לרשימה לפי הסדר המתקבל מפונקציה פרטית
        }
    
        private IntNode g(IntNode p, int num) {
            if (p == null) // אם הגענו לסוף הרשימה או אם הרשימה ריקה
                return new IntNode(num); // מחזירים צומת חדש עם הערך num
            if (p.getValue() < num) // אם הערך בצומת הנוכחי קטן מהערך num
                return new IntNode(num, p); // יוצרים צומת חדש עם הערך num ומחברים אותו לפני הצומת הנוכחי
            p.setNext(g(p.getNext(), num)); // ממשיכים לבדוק רקורסיבית את הצומת הבא ברשימה
            return p; // מחזירים את הצומת הנוכחי לאחר עדכון הקישור לצומת הבא
        }
    
        public IntList what() {
            IntList list1 = new IntList(); // יצירת רשימה מקושרת חדשה לנתונים שעוברים את הבדיקה הראשונה
            IntList list2 = new IntList(); // יצירת רשימה מקושרת חדשה לנתונים שעוברים את הבדיקה השנייה
            IntNode ptr = _head; // מצביע לצומת הנוכחי ברשימה המקורית
    
            while (ptr != null) { // לולאה שעוברת על כל הצמתים ברשימה המקורית
                int num = ptr.getValue(); // קבלת הערך של הצומת הנוכחי
                if (num % 2 == 0) // אם הערך זוגי
                    list2.f(num); // הוספת הערך לרשימה השנייה באמצעות פונקציה f
                else // אם הערך אי-זוגי
                    list1.g(num); // הוספת הערך לרשימה הראשונה באמצעות פונקציה g
                ptr = ptr.getNext(); // מעבר לצומת הבא ברשימה המקורית
            }
    
            IntNode newHead = list1._head; // הגדרת ראש הרשימה החדשה כראש הרשימה הראשונה
            IntNode ptr1 = newHead; // מצביע לרשימה החדשה
            while (ptr1.getNext() != null) { // לולאה שעוברת על כל הצמתים ברשימה הראשונה
                ptr1 = ptr1.getNext(); // מעבר לצומת הבא ברשימה הראשונה
            }
            ptr1.setNext(list2._head); // חיבור סוף הרשימה הראשונה לתחילת הרשימה השנייה
            return new IntList(newHead); // החזרת הרשימה החדשה המורכבת
        }
    }
 
    
}
