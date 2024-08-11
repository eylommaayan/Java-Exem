public class shortestRoad {

    public static int shortestRoad(int[] road1, int[] road2) {
        // הגדרת משתנים לאחסון סכום האלמנטים בכל מסלול
        int sum1 = 0, sum2 = 0, min1, min2;
        
        // לולאה לחישוב סכום האלמנטים בכל אחד מהמסלולים
        for (int i = 0; i < road1.length; i++) {
            sum1 += road1[i]; // הוספת האלמנט הנוכחי ממסלול 1 לסכום
            sum2 += road2[i]; // הוספת האלמנט הנוכחי ממסלול 2 לסכום
        }
        
        // אתחול הערכים המינימליים לערכי הסכום הכוללים של כל מסלול
        min1 = sum1;
        min2 = sum2;
        
        // אתחול משתנים שמייצגים את הקטעים הראשונים של המסלולים
        int segment1 = road1[0];
        int segment2 = road2[0];
        
        // לולאה שמתחילה מהאלמנט השני במערכים (אינדקס 1)
        for (int i = 1; i < road1.length; i++) {
            // אם הערך המינימלי של מסלול 1 גדול מהערך המחושב, עדכן את min1
            if (min1 > (sum2 - segment2) + segment1) {
                min1 = (sum2 - segment2) + segment1;
            }
            
            // אם הערך המינימלי של מסלול 2 גדול מהערך המחושב, עדכן את min2
            if (min2 > (sum1 - segment1) + segment2) {
                min2 = (sum1 - segment1) + segment2;
            }
            
            // עדכון הערך של הקטע הנוכחי במסלול 1
            segment1 += road1[i];
            // עדכון הערך של הקטע הנוכחי במסלול 2
            segment2 += road2[i];
        }
        
        // החזרת הערך המינימלי בין שני המסלולים
        return Math.min(min1, min2);
    }
    
}