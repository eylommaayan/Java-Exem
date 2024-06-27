public class IntNode {
    private int _value; // משתנה פרטי המחזיק את הערך של הצומת
    private IntNode _next; // משתנה פרטי המחזיק את ההפניה לצומת הבא

    // קונסטרקטור של המחלקה
    public IntNode(int val, IntNode n) {
        _value = val; // אתחול הערך של הצומת
        _next = n; // אתחול ההפניה לצומת הבא
    }

    // שיטה המחזירה את הערך של הצומת
    public int getValue() {
        return _value;
    }

    // שיטה המחזירה את ההפניה לצומת הבא
    public IntNode getNext() {
        return _next;
    }

    // שיטה המגדירה את הערך של הצומת
    public void setValue(int v) {
        _value = v;
    }

    // שיטה המגדירה את ההפניה לצומת הבא
    public void setNext(IntNode node) {
        _next = node;
    }
}


public class IntList {
    private IntNode _head; // משתנה פרטי המחזיק את הראש של הרשימה

    // קונסטרקטור של המחלקה
    public IntList() {
        _head = null; // אתחול הראש של הרשימה כ-null
    }

    // שיטה המחשבת ערך כלשהו על שתי רשימות מקושרות
    public double what(IntList other) {
        int c = 0;
        IntNode cu = _head;
        // ספירת מספר האיברים ברשימה הנוכחית
        while (cu != null) {
            cu = cu.getNext();
            c++;
        }

        cu = other._head;
        // ספירת מספר האיברים ברשימה השנייה
        while (cu != null) {
            cu = cu.getNext();
            c++;
        }

          // הגדרת מצביעים לתחילת שתי הרשימות
        IntNode cu1 = _head;
        IntNode cu2 = other._head;
  // חישוב מיקום האמצע של הרשימה המאוחדת
        int m = c / 2;
        if (c % 2 == 1) // אם מספר האיברים אי זוגי, מתקנים את המיקום האמצעי
            m++;

        int count = 1; // משתנה לספירת המיקום הנוכחי באיחוד הרשימות
   
        
        // לולאה לאיחוד ומיון שתי הרשימות
        while (cu1 != null && cu2 != null) {
            if (count == m) { // אם הגענו למיקום האמצעי
                if (c % 2 == 1) { // אם מספר האיברים אי זוגי
                    if (cu1.getValue() < cu2.getValue())
                        return cu1.getValue();
                    else
                        return cu2.getValue();
                } else { // אם מספר האיברים זוגי
                    if (cu1.getValue() < cu2.getValue()) {
                        // אם יש צומת הבא ב-cu1 והערך שלו קטן מ-cu2
                        if (cu1.getNext() != null && cu1.getNext().getValue() < cu2.getValue())
                            // מחזירים את הממוצע של הערכים של cu1 ו-cu1 הבא
                            return (cu1.getValue() + cu1.getNext().getValue()) / 2.0;
                        else
                            // מחזירים את הממוצע של הערכים של cu1 ו-cu2
                            return (cu1.getValue() + cu2.getValue()) / 2.0;
                    } else {
                        // אם יש צומת הבא ב-cu2 והערך שלו קטן מ-cu1
                        if (cu2.getNext() != null && cu2.getNext().getValue() < cu1.getValue())
                            // מחזירים את הממוצע של הערכים של cu2 ו-cu2 הבא
                            return (cu2.getValue() + cu2.getNext().getValue()) / 2.0;
                        else
                            // מחזירים את הממוצע של הערכים של cu1 ו-cu2
                            return (cu1.getValue() + cu2.getValue()) / 2.0;
                    }
                }
            }

            // מעבר לצומת הבא לפי הערך הקטן ביותר
            if (cu1.getValue() < cu2.getValue())
                cu1 = cu1.getNext();
            else
                cu2 = cu2.getNext();
            count++; // הגדלת הספירה
        }

        IntNode newCu;
        if (cu1 != null) // אם cu1 לא הגיע לסוף הרשימה
            newCu = cu1;
        else // אם cu2 לא הגיע לסוף הרשימה
            newCu = cu2;

        // המשך בספירה עד למיקום האמצעי
        while (count != m) {
            newCu = newCu.getNext(); // מעבר לצומת הבא
            count++; // הגדלת הספירה
        }

        // החזרת הערך האמצעי או ממוצע שני הערכים האמצעיים
        if (c % 2 == 1)
            return newCu.getValue();
        else
            return (newCu.getValue() + newCu.getNext().getValue()) / 2.0;
    }
}