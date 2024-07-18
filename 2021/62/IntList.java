
public class IntList {
    

    public int f() {
        IntNode temp = _head;  // מצביע על הראש של הרשימה
        int c = 0;  // מונה את מספר הצמתים
        while (temp != null) {  // לולאה עד סוף הרשימה
            c++;  // מגדיל את המונה
            temp = temp.getNext();  // עובר לצומת הבא
        }
        return c;  // מחזיר את מספר הצמתים
    }
    
    public int secret2021B62(int x) {
        int curr = 0, result = f() + 1;  // מחשב את מספר הצמתים + 1
        int temp1 = 0, temp2 = 0;
        IntNode ptr1 = _head, ptr2 = _head;  // מצביעים על הראש של הרשימה
        while (ptr2 != null) {
            while (curr <= x && ptr2 != null) {
                curr += ptr2.getValue();  // מוסיף את ערך הצומת הנוכחי למשתנה curr
                ptr2 = ptr2.getNext();  // עובר לצומת הבא
                temp2++;  // מגדיל את המונה temp2
            }
            while (curr > x && ptr1 != null) {
                if (temp2 - temp1 < result)  // בודק אם האורך הנוכחי קטן מהאורך המינימלי שנמצא עד כה
                    result = temp2 - temp1;  // מעדכן את האורך המינימלי
                curr -= ptr1.getValue();  // מוריד את ערך הצומת הנוכחי מהמשתנה curr
                ptr1 = ptr1.getNext();  // עובר לצומת הבא
                temp1++;  // מגדיל את המונה temp1
            }
        }
        return result;  // מחזיר את האורך המינימלי
    }
    
}
