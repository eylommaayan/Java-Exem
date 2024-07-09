

public class palindrome {
    

    public static int longestAlmostPalindrome(int[] arr) {
        // בדיקה אם המערך ריק או null
        if (arr == null || arr.length == 0) return 0;
        // התחלת החיפוש אחרי הרצף הארוך ביותר שהוא כמעט פלינדרום באורך 2 ומעלה
        return longestAlmostPalindrome(arr, 2, 1, 0, 1);
    }


     private static int longestAlmostPalindrome(int[] arr, int size, int max, int i, int j) {
    // אם גודל הרצף הנוכחי גדול מאורך המערך, החזרה של הערך המקסימלי שנמצא עד כה
    if (size > arr.length) {
        return max;
    }

    // אם האינדקס j חורג מגבולות המערך, הגדלת גודל הרצף והתחלה מחדש
    if (j >= arr.length) {
        return longestAlmostPalindrome(arr, size + 1, max, 0, size);
    }

    // אם הערכים באינדקסים i ו-j שווים, בדיקת אם הרצף הוא כמעט פלינדרום
    if (arr[i] == arr[j]) {
        int temp = checkPalindrome(arr, size, false, i + 1, j - 1);
        // אם הרצף הנוכחי ארוך יותר מהרצף המקסימלי שנמצא עד כה, עדכון המקסימום
        if (temp > max) {
            max = temp;
        }
    }

    // המשך החיפוש על ידי הגדלת האינדקסים i ו-j
    return longestAlmostPalindrome(arr, size, max, i + 1, j + 1);
}


private static int checkPalindrome(int[] arr, int size, boolean hasMismatched, int i, int j) {
    // מקרה בסיס: אם הרצף מכיל ערך אחד בלבד, החזרת אורכו
    if (j - i == 0) {
        return size + 1;
    }

    // מקרה בסיס: אם i גדול מ-j, החזרת הגודל הנוכחי של הרצף
    if (i > j) {
        return size;
    }

    // אם הערכים באינדקסים i ו-j שווים, המשך ההתקדמות פנימה
    if (arr[i] == arr[j]) {
        return checkPalindrome(arr, size + 2, hasMismatched, i + 1, j - 1);
    }

    // אם לא היה חוסר התאמה עד כה, ניסיון לדלג על i או j למציאת כמעט פלינדרום
    if (!hasMismatched) {
        int skipI = checkPalindrome(arr, size + 1, true, i + 1, j); // דילוג על i
        int skipJ = checkPalindrome(arr, size + 1, true, i, j - 1); // דילוג על j
        // החזרת האורך הגדול מבין שני הרצפים
        return Math.max(skipI, skipJ);
    }

    // אם כבר היה חוסר התאמה, הרצף הנוכחי לא יכול להיות כמעט פלינדרום
    return -1;
}

}
