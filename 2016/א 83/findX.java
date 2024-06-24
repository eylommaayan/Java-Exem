/*
 * 
 * הפונקציה findX מחפשת זוג איברים עוקבים במערך a שסכומם שווה ל- x.
 *  הפונקציה משתמשת באלגוריתם בינארי כדי למצוא את הזוג הנכון.

 * 
 */

 public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 3, 6, 10, 9};
        int x = 10;
        System.out.println(findX(a, x));
    }

    public static boolean findX(int[] a, int x) {
        int low = 0, high = a.length - 1, mid = 0;
        if (a.length == 1) {
            return false;
        }
        while (low < high) {
            mid = (low + high) / 2;
            if (a[mid] + a[mid + 1] == x) {
                return true;
            }
            if (a[mid] + a[mid + 1] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return false;
    }
}


/*
 * הסבר:
אתחול משתנים:

low - מצביע לתחילת המערך (אינדקס 0).
high - מצביע לסוף המערך (אינדקס a.length - 1).
mid - משתנה עזר לחישוב אמצע המערך.
בדיקה ראשונית:

אם המערך מכיל איבר אחד בלבד (a.length == 1), הפונקציה תחזיר false כי לא ניתן למצוא זוג איברים במערך כזה.
לולאת while:

כל עוד low קטן מ-high, מבוצעות הפעולות הבאות:
חישוב אינדקס אמצע המערך: mid = (low + high) / 2.
בדיקה אם סכום האיבר באינדקס mid והאיבר הבא אחריו (a[mid] + a[mid + 1]) שווה ל- x. אם כן, הפונקציה תחזיר true.
אם הסכום קטן מ- x, מעדכנים את low להיות mid + 1.
אם הסכום גדול מ- x, מעדכנים את high להיות mid.
החזרת false:

אם לולאת ה-while מסתיימת ללא מציאת זוג איברים שסכומם שווה ל- x, הפונקציה תחזיר false.
סיבוכיות זמן:
סיבוכיות זמן: 
𝑂
(
log
⁡
𝑛
)
O(logn) - כל השוואה מקצצת את המערך בחצי.
סיבוכיות מקום: 
𝑂
(
1
)
O(1) - האלגוריתם משתמש במספר קבוע של משתנים נוספים בלבד.
 */