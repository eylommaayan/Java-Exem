

public class IntListTwo {
    public class IntListTwo {
        private IntNodeTwo _head, _tail;
    
        // בנאי שמאתחל רשימה ריקה
        public IntListTwo() {
            _head = null;
            _tail = null;
        }
    
        // בנאי שמקבל צומת ומאתחל את הרשימה כך שתתחיל מהצומת הזה
        public IntListTwo(IntNodeTwo node) {
            _head = node;
            _tail = node;
            // מעבר עד סוף הרשימה כדי לעדכן את _tail לצומת האחרון
            while (_tail.getNext() != null)
                _tail = _tail.getNext();
        }
    
        // פונקציה שמבצעת משהו עם צומת מסוים ומחזירה רשימה חדשה
        public IntListTwo something(IntNodeTwo p) {
            int num = p.getNum(); // קבלת המספר מהצומת
            IntNodeTwo head = null, tail = null, ptr = null;
            
            // יצירת צומת חדש עם הספרה האחרונה של המספר
            ptr = new IntNodeTwo(num % 10, tail, head);
            head = ptr;
            tail = ptr;
            num = num / 10; // הסרת הספרה האחרונה
            
            // חזרה על כל הספרות הנותרות של המספר
            while (num > 0) {
                ptr = new IntNodeTwo(num % 10, head, null); // יצירת צומת חדש עם הספרה האחרונה
                head.setPrev(ptr); // עדכון הקישור הקודם של ראש הרשימה הנוכחית
                head = ptr; // עדכון ראש הרשימה
                num = num / 10; // הסרת הספרה האחרונה
            }
            
            return new IntListTwo(head); // החזרת רשימה חדשה שמתחילה בראש החדש
        }
    
        // פונקציה שמבצעת פעולה סודית ומחזירה רשימה חדשה
        public IntListTwo secret() {
            IntNodeTwo ptr = _head; // התחלת מעבר מהראש של הרשימה הנוכחית
            IntNodeTwo p1 = null, p2 = new IntNodeTwo(0); // יצירת צומת התחלה חדש
            while (ptr != null) {
                IntListTwo curr = something(ptr); // יצירת רשימה חדשה מהצומת הנוכחי
                if (p1 == null)
                    p1 = curr._head; // אם זו ההתחלה, קביעת הראש החדש של הרשימה הסודית
                p2.setNext(curr._head); // קביעת הקישור הבא של הצומת האחרון ברשימה הסודית
                p2 = curr._tail; // עדכון הצומת האחרון ברשימה הסודית
                ptr = ptr.getNext(); // מעבר לצומת הבא ברשימה המקורית
            }
            return new IntListTwo(p1); // החזרת הרשימה הסודית החדשה
        }


    }
    
}
