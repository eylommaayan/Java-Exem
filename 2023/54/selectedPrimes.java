public class selectedPrimes {
    

    public static int selectedPrimes(int num, int x) {
        // קריאה לפונקציה הרקורסיבית עם ערכי התחלה
        return selectedPrimes(num, x, 2, 0, 0);
    }

    public static int selectedPrimes(int num, int x, int currentPrime, int count, int power) {
        // תנאי עצירה: אם המספר הגיע ל-1
        if (num == 1) {
            if (power == x) { // אם הכוח של הגורם הראשוני שווה ל-x
                count++; // עדכון מונה הגורמים הראשוניים
                System.out.println("Prime " + count + ": " + currentPrime); // הדפסת הגורם הראשוני
            }
            return count; // החזרת המונה
        }
    
        // אם המספר מתחלק בגורם הראשוני הנוכחי
        if (num % currentPrime == 0) {
            // קריאה רקורסיבית אחרי חלוקת המספר בגורם הראשוני ועדכון הכוח
            return selectedPrimes(num / currentPrime, x, currentPrime, count, power + 1);
        }
    
        // אם הכוח של הגורם הראשוני שווה ל-x
        if (power == x) {
            count++; // עדכון מונה הגורמים הראשוניים
            System.out.println("Prime " + count + ": " + currentPrime); // הדפסת הגורם הראשוני
        }
    
        // מציאת הגורם הראשוני הבא
        int nextPrime = nextPrime(currentPrime);
        // קריאה רקורסיבית עם הגורם הראשוני הבא ואיפוס הכוח
        return selectedPrimes(num, x, nextPrime, count, 0);
    }
    

}
