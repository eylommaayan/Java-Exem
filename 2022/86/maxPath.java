
public class maxPath {
    
    public static int cheapRt(int[] stations, int step1, int step2, int limit) {
        return cheapRt(stations, step1, step2, limit, 0, 0, 0, "");
    }
    
    private static int cheapRt(int[] stations, int step1, int step2, int limit, int i, int money, String toPrint) {
        // אם הגענו לתחנה האחרונה
        if (i == stations.length - 1) {
            money += stations[i];
            System.out.println(toPrint + i + "\t= " + money);
            return money;
        }
    
        // אם חרגנו מתחומי המערך
        if (i >= stations.length) {
            return Integer.MAX_VALUE;
        }
    
        // בדיקה של אפשרות לקחת צעד ראשון
        int option1 = cheapRt(stations, step1, step2, limit, i + step1, money + stations[i], toPrint + i + "\t");
        int option2 = Integer.MAX_VALUE;
    
        // בדיקה של אפשרות לקחת צעד שני אם המגבלה מאפשרת
        if (limit > 0) {
            option2 = cheapRt(stations, step1, step2, limit - 1, i + step2, money + stations[i], toPrint + i + "\t");
        }
    
        // החזרת הערך המינימלי בין שתי האפשרויות
        return Math.min(option1, option2);
    }
    
