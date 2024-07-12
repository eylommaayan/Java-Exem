
public class longestSubarray {

    public static int longestSubarray(int[] a) {
        // הגדרות משתנים התחלתיים
        int i = 0, indexT1 = 0, indexT2 = 0, indexStart = 0, indexEnd = 0;
        // לולאה שעוברת על כל האלמנטים במערך
        while (i < a.length) {
            // אם יש שינוי בסימן בין שני אלמנטים סמוכים, עדכון indexT2
            if (i < a.length - 1 && a[i] * a[i + 1] < 0) {
                indexT2 = i + 1;
            } else if (indexEnd - indexStart < indexT2 - indexT1) {
                // אם האורך הנוכחי של התת-מערך הוא הגדול ביותר שנמצא עד כה, עדכון indexEnd ו-indexStart
                indexEnd = indexT2;
                indexStart = indexT1;
                indexT1 = i;
                indexT2 = i + 1;
            } else {
                // עדכון indexT1 לתחילת הקטע הבא
                indexT1 = i + 1;
            }
            i++;
        }
        // הדפסת המיקומים ההתחלתיים והסופיים של התת-מערך הארוך ביותר
        System.out.println("Starting index = " + indexStart + " " + "Ending index = " + indexEnd);
        // החזרת האורך של התת-מערך הארוך ביותר
        return indexEnd - indexStart + 1;
    }
    
    
}
