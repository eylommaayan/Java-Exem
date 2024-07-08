
public class selectedPrimes {


    public static int selectedPrimes(int num, int x) {
        return selectedPrimes(num, x, 2); // קריאה לפונקציה הרקורסיבית עם currentPrime התחלתי של 2
    }

    private static int selectedPrimes(int num, int x, int currentPrime) {
        if (currentPrime > num) // אם המספר הראשוני הנוכחי גדול מהמספר num, אין יותר מספרים ראשוניים לבדוק
            return 0; // מחזירים 0 שמציין שלא מצאנו מספר ראשוני מתאים
    
        int currentPrimeToX = (int) Math.pow(currentPrime, x); // מחשבים את currentPrime בחזקת x
        int currentPrimeToXPlus1 = currentPrime * currentPrimeToX; // מחשבים את currentPrime בחזקת x+1
        if (num % currentPrimeToX == 0 && num % currentPrimeToXPlus1 != 0) { // בודקים אם currentPrime בחזקת x מחלק את num ו-currentPrime בחזקת x+1 לא מחלק את num
            System.out.println(currentPrime); // מדפיסים את המספר הראשוני שמצאנו
            return 1 + selectedPrimes(num, x, nextPrime(currentPrime)); // מוסיפים 1 וממשיכים לבדוק את המספר הראשוני הבא
        }
    
        // אם לא מצאנו מספר ראשוני מתאים, נמשיך לבדוק את המספר הראשוני הבא
        return selectedPrimes(num, x, nextPrime(currentPrime));
    }
    
       
}
