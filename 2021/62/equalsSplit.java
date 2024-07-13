public class equalsSplit {
  
    public static boolean equalsSplit(int[] arr) {
    // קריאה לפונקציה הפרטית עם פרמטרים התחלתיים
    return equalsSplit(arr, 0, 0, 0, 0, 0);
}

// פונקציה רקורסיבית שמחשבת אם ניתן לחלק את המערך לשתי קבוצות שוות בסכום ובמספר האלמנטים
public static boolean equalsSplit(int[] arr, int i, int set1, int set2, int count1, int count2) {
    // תנאי עצירה - אם הגענו לסוף המערך
    if (i == arr.length) {
        // אם הסכום והכמות של שתי הקבוצות שווה, מחזירים true
        return set1 == set2 && count1 == count2;
    }

    // קריאה רקורסיבית עם הוספת הערך הנוכחי ל-set1 והגדלת count1
    return equalsSplit(arr, i + 1, set1 + arr[i], set2, count1 + 1, count2) ||
           // קריאה רקורסיבית עם הוספת הערך הנוכחי ל-set2 והגדלת count2
           equalsSplit(arr, i + 1, set1, set2 + arr[i], count1, count2 + 1);
}


}
