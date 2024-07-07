public class prince {

public static int prince(int[][] drm, int i, int j) {
    return prince(drm, i, j, drm[i][j]);
}

private static int prince(int[][] drm, int i, int j, int prev) {
    if (i < 0 || j < 0 || i >= drm.length || j >= drm[0].length || drm[i][j] == -100) { // bad - we went out of bounds
        return -1;
    }
    if (drm[i][j] == -1) { // good - we reached the destination
        return 1;
    }
    if (!(prev - 2 <= drm[i][j] && drm[i][j] <= prev + 1)) { // bad - the prince made an illegal move
        return -1;
    }

    // change temporary the value of drm[i][j] - to prevent cycles in the path
    // יוצרים משתנה לא הגיוני ושמית אותו למעלה בתנאים האוסרים לכן כאשר נדרוך במשבצת שהיינו
    // נקבל שגיאה
    int temp = drm[i][j];
    drm[i][j] = -100;
    // check the 4 options and choose the lowest
    int option1 = prince(drm, i - 1, j, temp); // up
    int option2 = prince(drm, i + 1, j, temp); // down
    int option3 = prince(drm, i, j - 1, temp); // left
    int option4 = prince(drm, i, j + 1, temp); // right
    drm[i][j] = temp; // חוזרים על התא שוב  

    return 1+priceMin(option1, option2, option3, option4);
}
 // return the min element that is not -1 
 // בחירת המספר הכי נמוך של משבצות 
 // בשביל מסלול הכי קטן
private int priceMin(int a, int b, int c, int d){
if(a == -1 && b== -1 && c == -1 && d == -1){
  return -1;
  int best = Math.max(Math.min(a,b), Math.min(c,d));
    if(a >= 0)
      best = Math.min(best, a);
    if(a >= 0)
      best = Math.min(best, b);
    if(a >= 0)
      best = Math.min(best, c);
    if(a >= 0)
      best = Math.min(best, d);
    return best;
}

