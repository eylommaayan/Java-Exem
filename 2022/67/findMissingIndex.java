public class findMissingIndex {
 
    public static int findMissingIndex(int[] a) {
        // הגדרות משתנים התחלתיים
        int low = 0, high = a.length - 1, mid = 0, distance = a[1] - a[0], distanceTotal = 0;
        // בודקים אם הערך החסר הוא במקום השני (מיקום 1)
        if (a[2] - a[1] < distance) {
            return 1;
        }
        // לולאה שממשיכה עד שנמצא את הערך החסר או עד שהגבולות נפגשים
        while (low < high) {
            mid = (low + high) / 2; // חישוב האמצע
            distanceTotal = (mid * distance) + a[0]; // חישוב הערך המצופה במיקום האמצעי
            // בודקים אם הערך במיקום האמצעי לא תואם את הציפייה ויש הבדל במיקום הקודם
            if (distanceTotal != a[mid] && distanceTotal - distance == a[mid - 1]) {
                return mid; // מחזירים את המיקום החסר
            }
            // אם הערך במיקום האמצעי תואם את הציפייה, ממשיכים לחלק השני של המערך
            if (distanceTotal == a[mid]) {
                low = mid + 1;
                // אם המיקום הנמוך והגבוה נפגשים, מחזירים את המיקום
                if (low == high) {
                    return low;
                }
            } else {
                // אם הערך במיקום האמצעי לא תואם את הציפייה, עוברים לחלק הראשון של המערך
                high = mid - 1;
            }
        }
        // אם לא נמצא ערך חסר, מחזירים את גודל המערך
        return a.length;
    }
      

}
