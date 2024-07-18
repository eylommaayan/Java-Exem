
public class calc {
    
    public static int calc(int num, int result, int maxOp) {
        return calc(num, result, maxOp, num, ""); // קריאה לפונקציה הרקורסיבית עם הערכים ההתחלתיים
    }

    private static int calc(int num, int result, int maxOp, int currentResult, String toPrint) {
        if (currentResult == result) { // אם התוצאה הנוכחית שווה לתוצאה הרצויה
            System.out.println(num + toPrint); // מדפיסים את הביטוי שמצאנו
            return 1; // מחזירים 1 שמציין שמצאנו ביטוי תקני
        }
        if (maxOp == 0) { // אם לא נותרו לנו פעולות לבצע והתוצאה הנוכחית לא שווה לתוצאה הרצויה
            return 0; // מחזירים 0 שמציין שלא מצאנו ביטוי תקני
        }
    
        int count = 0; // משתנה לספירת הביטויים התקניים שמצאנו
    
        // בדיקה של כל פעולה: +, -, *, /  maxOp -1  הכוונה כמות הפעולות הנותרת
        count += calc(num, result, maxOp - 1, currentResult + num, toPrint + " + " + num); // קריאה רקורסיבית לאחר הוספת פעולה של חיבור
        count += calc(num, result, maxOp - 1, currentResult - num, toPrint + " - " + num); // קריאה רקורסיבית לאחר הוספת פעולה של חיסור
        count += calc(num, result, maxOp - 1, currentResult * num, toPrint + " * " + num); // קריאה רקורסיבית לאחר הוספת פעולה של כפל
        count += calc(num, result, maxOp - 1, currentResult / num, toPrint + " / " + num); // קריאה רקורסיבית לאחר הוספת פעולה של חילוק
    
        return count; // החזרת מספר הביטויים התקניים שמצאנו
    }
    

}
