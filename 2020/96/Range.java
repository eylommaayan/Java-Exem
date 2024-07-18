public class Range {
    public class Range {
        private int _small, _big;
    
        // בנאי שמקבל שני פרמטרים, התוחמים את הטווח
        public Range(int s, int b) {
            _small = s; // הגדרת הערך הקטן בטווח
            _big = b; // הגדרת הערך הגדול בטווח
        }
        // פונקציה שמחזירה את הערך הקטן בטווח
        public int getSmall() {
            return _small;
        }
        // פונקציה שמחזירה את הערך הגדול בטווח
        public int getBig() {
            return _big;
        }
    }
    // פונקציה שמחזירה את המספר החיובי הקטן ביותר שלא נמצא בטווחים הנתונים
    public static int minimalPositive (Range[] rangeA) {
        int low = 0, high = rangeA.length - 1, mid;
    
        // מציאת המספר החיובי הקטן ביותר באמצעות חיפוש בינארי
        while (low < high) {
            mid = (low + high) / 2;
            if (rangeA[mid].getBig() <= 0) {
                low = mid + 1; // אם המספר הגדול בטווח קטן או שווה ל-0, נזיז את הגבול התחתון למעלה
            } else {
                high = mid; // אחרת, נזיז את הגבול העליון למטה
            }
        }
        // לאחר סיום הלולאה, מציאת המספר החיובי הקטן ביותר מתוך הטווחים
        low = rangeA[high].getSmall(); // הגדרת הגבול התחתון כמספר הקטן בטווח
        high = rangeA[high].getBig(); // הגדרת הגבול העליון כמספר הגדול בטווח
    
        while (low < high) {
            mid = (low + high) / 2;
            if (mid < 1) {
                low = mid + 1; // אם האמצע קטן מ-1, נזיז את הגבול התחתון למעלה
            } else {
                high = mid; // אחרת, נזיז את הגבול העליון למטה
            }
        }
        if (high < 1) {
            return -1; // אם הגבול העליון קטן מ-1, אין מספר חיובי בטווחים הנתונים
        } else {
            return high; // אחרת, נחזיר את הערך של הגבול העליון שהוא המספר החיובי הקטן ביותר שלא נמצא בטווחים
        }
    }
    
}
