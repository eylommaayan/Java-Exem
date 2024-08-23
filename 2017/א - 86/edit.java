// פונקציה ראשית שמתחילה את תהליך החישוב
public static int edit(String str1, String str2) {
    // קריאה לפונקציה רקורסיבית עם התחלה של שני המחרוזות והאינדקסים ההתחלתיים 0, וספירה של פעולות עריכה (count) המתחילה מ-0
    return edit(str1, str2, 0, 0, 0);
}

// פונקציה רקורסיבית למציאת מספר מינימלי של פעולות עריכה הנדרשות להפוך את str1 ל-str2
private static int edit(String str1, String str2, int i, int j, int count) {
    // אם הגענו לסוף של str1, ועדיין יש תווים ב-str2, מוסיפים את כמות התווים שנותרו ב-str2 ל-count
    if (i == str1.length() && j < str2.length()) {
        return count += (str2.length() - j);
    }
    
    // אם הגענו לסוף של str2, ועדיין יש תווים ב-str1, מוסיפים את כמות התווים שנותרו ב-str1 ל-count
    if (j == str2.length() && i < str1.length()) {
        return count += (str1.length() - i);
    }
    
    // אם הגענו לסוף של שתי המחרוזות בו-זמנית, מחזירים את מספר פעולות העריכה שביצענו עד כה
    if (i == str1.length() && j == str2.length()) {
        return count;
    }
    
    // אם התווים הנוכחיים ב-str1 ו-str2 זהים, ממשיכים לרוץ על המחרוזות בלי להגדיל את ה-count
    if (str1.charAt(i) == str2.charAt(j)) {
        return edit(str1, str2, i + 1, j + 1, count);
    } 
    
    // אם התווים שונים, מבצעים קריאה רקורסיבית עם הגדלה של count, ומחזירים את המינימום בין האפשרויות השונות
    // האפשרויות כוללות הכנסה של תו חדש, מחיקה של תו, או החלפה של תו
    else {
        return Math.min(edit(str1, str2, i + 1, j, count + 1),   // אפשרות 1: מחיקה ב-str1
                        edit(str1, str2, i, j + 1, count + 1)); // אפשרות 2: הוספה ב-str2
    }
}
