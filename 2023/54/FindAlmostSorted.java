public class FindAlmostSorted {
    public static int findAlmostSorted(int[] arr, int num) {
        int low = 0, high = arr.length - 1; // גבולות התחלה וסוף המערך
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // חישוב אמצע המערך
            
            // אם המספר באמצע הוא המספר המבוקש, מחזירים את האינדקס שלו
            if (arr[mid] == num) {
                return mid;
            }
            
            // בדיקת השכן השמאלי של האמצע אם הוא המספר המבוקש
            // mid > low מוודא שהאינדקס mid-1 לא מחוץ לתחום המערך
            if (mid > low && arr[mid - 1] == num) {
                return mid - 1;
            }
            
            // בדיקת השכן הימני של האמצע אם הוא המספר המבוקש
            // mid < high מוודא שהאינדקס mid+1 לא מחוץ לתחום המערך
            if (mid < high && arr[mid + 1] == num) {
                return mid + 1;
            }
            
            // אם המספר באמצע קטן מהמספר המבוקש, מעדכנים את הגבול התחתון
            if (arr[mid] < num) {
                low = mid + 2; // מדלגים שני איברים קדימה
            } else { // אם המספר באמצע גדול מהמספר המבוקש, מעדכנים את הגבול העליון
                high = mid - 2; // מדלגים שני איברים אחורה
            }
        }
        
        return -1; // אם המספר לא נמצא במערך, מחזירים -1
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 20, 40, 50, 70, 80};
        int num = 40;
        int index = findAlmostSorted(arr, num); // קריאה לפונקציה לחיפוש מספר במערך כמעט ממוין
        System.out.println("Index of " + num + " is: " + index); // פלט התוצאה

        int[] arr2 = {10, 3, 40, 20, 50, 80, 70};
        int num2 = 60;
        int index2 = findAlmostSorted(arr2, num2); // קריאה לפונקציה לחיפוש מספר שלא קיים במערך
        System.out.println("Index of " + num2 + " is: " + index2); // פלט התוצאה
    }
}
