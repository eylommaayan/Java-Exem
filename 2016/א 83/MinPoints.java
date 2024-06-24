

/*
 * 
 * נתונה מטריצה של מספרים שלמים.
 *  המטרה היא למצוא מסלול מהפינה השמאלית העליונה לפינה הימנית התחתונה עם סכום מינימלי. 
 * ניתן לזוז רק ימינה או למטה בכל רגע נתון.
 * 
 * 
 * 
 * 
*/

public class MinPoints {

    // פונקציה ציבורית שמתחילה את הרקורסיה מהתא (0,0)
    public static int minPoints(int[][] m) {
        return minPoints(m, 0, 0, 0);
    }

    // פונקציה רקורסיבית שמחשבת את סכום המסלול המינימלי
    private static int minPoints(int[][] m, int i, int j, int currentSum) {
        // תנאי עצירה רע: אם חורגים מגבולות המטריצה או מגיעים לתא עם ערך שלילי
        if (i >= m.length || j >= m[0].length || m[i][j] < 0) {
            return Integer.MAX_VALUE;
        }

        // תנאי עצירה טוב: אם הגענו לתא היעד
        if (i == m.length - 1 && j == m[0].length - 1) {
            //משמש להחזיר את הסכום המצטבר הכולל של המסלול כאשר הגענו לתא היעד (התא הימני התחתון במטריצה).
            return currentSum + m[i][j];
        }

        // קריאות רקורסיביות לתזוזה למטה וימינה
        int down = minPoints(m, i + 1, j, currentSum + m[i][j]);
        int right = minPoints(m, i, j + 1, currentSum + m[i][j]);

        // החזרת הערך המינימלי בין המסלול למטה ולמסלול ימינה
        return Math.min(down, right);
    }

    // פונקציה ראשית לבדיקת הפונקציה עם מקרה מבחן יחיד
    public static void main(String[] args) {
        int[][] matrix = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };

        int result = minPoints(matrix);
        if (result == Integer.MAX_VALUE) {
            System.out.println("אין מסלול תקף.");
        } else {
            System.out.println("סכום המסלול המינימלי הוא: " + result);
        }
    }
}



/*
 *  
 * m: מטריצה של מספרים שלמים.
 * 
i: אינדקס השורה הנוכחי

j: אינדקס העמודה הנוכחי.

min: משתנה שעוקב אחר הסכום המינימלי הנדרש כדי להגיע לתא הנוכחי.

temp: משתנה שעוקב אחר הסכום המצטבר הנוכחי.

before: משתנה שעוקב אחר הערך הקודם בתא לפני ההגעה לתא הנוכחי.


 התשובה המקורית
הם עשו את החישוב עם ערך מוחלט וזה סותר את 
בדיקה אם temp שלילי: אם temp שלילי, המינימום מתעדכן עם הערך האבסולוטי של before.
  

הביטוי return Math.abs(temp + m[i][j]) + 1; בקוד שלך מחזיר את הערך האבסולוטי של הסכום המצטבר 
temp + m[i][j] בתוספת 1. זה נעשה אם הסכום המצטבר כולל הערך של התא הנוכחי m[i][j] הוא שלילי.

הבהרה למה זה נועד:
הקוד המוצע לא מתאים לדרישה שלך שאומרת כי המסלול לא צריך לכלול תאים עם ערכים שליליים. 
ולכן נתקן את הקוד כדי שיעבוד בצורה הנכונה ולא יחזיר ערך אבסולוטי ויעדיף תמיד מסלול תקף ללא תאים שליליים.

 

//  public class minPoints {
    
//     // פונקציה ציבורית שמתחילה את הרקורסיה מהתא (0,0)
//     public static int minPoints(int[][] m) {
//         return minPoints(m, 0, 0, 0, 0, 0);
//     }
 
//     // פונקציה רקורסיבית שמחשבת את סכום המסלול המינימלי
//     private static int minPoints(int[][] m, int i, int j, int min, int temp, int before) {
//         // תנאי עצירה רע: אם חורגים מגבולות המטריצה, הסימום 0 הוא בשביל שהתורים יהיו לפי השורה הראשונה'
//         if (i > m.length - 1 || j > m[0].length - 1) {
//             return Integer.MAX_VALUE;
//         }
 
//         // תנאי עצירה טוב: אם הגענו לתא היעד
//         // if (i == m.length - 1 && j == m[0].length - 1) {
//         //     // אם הסכום המצטבר כולל התא הנוכחי הוא שלילי
//         //     if (temp + m[i][j] < 0) {
//         //         // בתשובה שלהם יש ערך מוחלט אבל לא בטוח שצריך את זה
//         //         return Math.abs(temp + m[i][j]) + 1;
//         //     }
//         //     return min + 1;
//         // }



//         if (i == m.length - 1 && j == m[0].length - 1) {
//             return currentSum + m[i][j];
//         }
        
        
//         // אם הסכום הנוכחי שלילי, נוסיף את הערך האבסולוטי למינימום
//         if (temp < 0) {
//             min += Math.abs(before);
//         }
        
//         // קריאה רקורסיבית לתזוזה למטה
//         int down = minPoints(m, i + 1, j, min, temp + m[i][j], m[i][j]);
//         // קריאה רקורסיבית לתזוזה ימינה
//         int right = minPoints(m, i, j + 1, min, temp + m[i][j], m[i][j]);
        
//         // החזרת הערך המינימלי בין המסלול למטה ולמסלול ימינה
//         return Math.min(down, right);
//     }
 
    // פונקציה ראשית לבדיקת הפונקציה עם מקרה מבחן יחיד
    public static void main(String[] args) {
        int[][] matrix = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };
 
        // קריאה לפונקציה הציבורית ובדיקת התוצאה
        int result = minPoints(matrix);
        if (result == Integer.MAX_VALUE) {
            System.out.println("אין מסלול תקף.");
        } else {
            System.out.println("סכום המסלול המינימלי הוא: " + result);
        }
    }
 }
 