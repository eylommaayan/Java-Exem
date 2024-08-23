
public class findFactors {
    

    public static void findFactors(int n) {
        // הגדרת המשתנים התחתון והעליון והאמצעי לשם חיפוש מחלקים
        int low = 2, high = n, mid;
        
        // לולאת חיפוש בינארי למציאת המחלקים המתאימים
        while (low < high) {
            mid = (low + high) / 2;
            
            // בדיקה אם האמצעי הוא מחלק מתאים
            if (isHighFactorInRange(n, low, mid)) {
                high = mid; // אם כן, מחלקים בין האמצעי והעליון
            } else {
                low = mid + 1; // אחרת, מחלקים בין התחתון לאמצעי
            }
        }
        
        // הדפסת המחלקים המתאימים
        System.out.println("q=" + high + " " + "p=" + n / low);
    }
    
    // חישוב של פונקציית מחלקים גבוהים בטווח מסוים
    public static boolean isHighFactorInRange(int n, int low, int high) {
        // מגדירה מחלק גבוה בטווח שמעל 2
        for (int i = high; i > low; i--) {
            if (n % i == 0) {
                return true; // אם נמצא מחלק גבוה, הפונקציה מחזירה אמת
            }
        }
        return false; // אם לא נמצא מחלק גבוה, הפונקציה מחזירה שקר
    }
    

}
