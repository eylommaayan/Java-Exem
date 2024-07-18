

public class smallestSub {
    

    public static int smallestSub(int[] a, int k) {
        // אתחול מצביעים וערכים
        int i = 0, j = 0, sum = 0, min = a.length + 1;
        
        // לולאה למציאת תת-המערך הראשון שסכומו גדול מ-k
        while (i < a.length && j < a.length) {
            if (sum <= k) {
                // הרחבת תת-המערך ע"י הוספת איבר חדש
                sum += a[j];
                j++;
            } else {
                // עדכון האורך המינימלי אם הסכום גדול מ-k
                min = Math.min(min, j - i);
                // כיווץ תת-המערך ע"י הסרת האיבר הראשון
                sum -= a[i];
                i++;
            }
        }
        
        // לולאה נוספת להבטחת כיווץ תת-המערך למינימום אם הסכום עדיין גדול מ-k
        while (sum > k && i < a.length) {
            // עדכון האורך המינימלי
            min = Math.min(min, j - i);
            // הסרת האיבר הראשון
            sum -= a[i];
            i++;
        }
        
        // החזרת האורך המינימלי שנמצא
        return min;
    }
    

}
