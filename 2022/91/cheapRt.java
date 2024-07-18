public class cheapRt {
    
// פונקציה רקורסיבית שעוברת על התחנות ומחשבת את המסלול הזול ביותר
private static int cheapRt(int[] stations, int step1, int step2, int limit, int i, int sum, String s) {

    // stations - מערך של מספרים שלמים שמייצג את התחנות והעלויות שלהן.
    // step1 - מספר התחנות שאפשר לדלג קדימה בצעד הראשון.
    // step2 - מספר התחנות שאפשר לדלג קדימה בצעד השני.
    // limit - מספר הפעמים שמותר להשתמש בצעד השני (step2).
    // i - אינדקס המיקום הנוכחי במערך התחנות.
    // sum - הסכום המצטבר של העלויות של התחנות שביקרנו בהן עד כה.
    // s - מחרוזת שמיועדת להדפסת המסלול לצורכי בדיקה וניפוי שגיאות.

    // תנאי עצירה - אם עברנו את תחנות המטרות או מיצינו את כמות ה-step2
    if (i > stations.length - 1 || limit < 0) {
        return Integer.MAX_VALUE; // מחזירים ערך מקסימלי אם לא ניתן להמשיך במסלול זה
    }

    // תנאי עצירה - אם הגענו לתחנה האחרונה
    if (i == stations.length - 1) {
        int sumTotal = sum + stations[i];
        System.out.println(s + i + "\t" + "=" + sumTotal); // הדפסה לצורך בדיקה
        return sumTotal; // מחזירים את הסכום הכולל של התחנות במסלול זה
    }

    // קריאה רקורסיבית למעבר בצעד step1
    int opt1 = cheapRt(stations, step1, step2, limit, i + step1, sum + stations[i], s + i + "\t");
    
    // קריאה רקורסיבית למעבר בצעד step2 (ומפחיתים את limit)
    int opt2 = cheapRt(stations, step1, step2, limit - 1, i + step2, sum + stations[i], s + i + "\t");

    // מחזירים את הערך המינימלי בין שני המסלולים האפשריים
    return Math.min(opt1, opt2);
}

    }
    