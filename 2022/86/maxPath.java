
public class maxPath {
    
// פונקציה רקורסיבית שמחשבת את המסלול המקסימלי במטריצה
private static int maxPath(int[][] mat, int i, int j, int sum) {

    // mat - מטריצה דו-ממדית של מספרים שלמים שמייצגת את הערכים בכל תא במטריצה.
    // i - אינדקס השורה הנוכחית במטריצה.
    // j - אינדקס העמודה הנוכחית במטריצה.
    // sum - הסכום המצטבר של הערכים שביקרנו בהם עד כה במסלול הנוכחי.

    // תנאי עצירה - אם עברנו את גבולות המטריצה
    if (i > mat.length - 1 || j > mat[0].length - 1) {
        return Integer.MIN_VALUE; // מחזירים ערך מינימלי אם לא ניתן להמשיך במסלול זה
    }

    // תנאי עצירה - אם הגענו לתא האחרון במטריצה
    if ((i == mat.length - 1) && (j == mat[0].length - 1)) {
        return sum + mat[i][j]; // מחזירים את הסכום הכולל של הערכים במסלול זה
    }

    // קריאה רקורסיבית למעבר לתא הבא במטריצה לפי הכללים
    // option1 - מעבר לתא הבא לפי שארית החילוק של הערך בתא הנוכחי ב-10 כשורה, ותוצאת החילוק בעשר כעמודה
    int option1 = maxPath(mat, i + mat[i][j] % 10, j + mat[i][j] / 10, sum + mat[i][j]);
    
    // option2 - מעבר לתא הבא לפי תוצאת החילוק של הערך בתא הנוכחי בעשר כשורה, ושארית החילוק כעמודה
    int option2 = maxPath(mat, i + mat[i][j] / 10, j + mat[i][j] % 10, sum + mat[i][j]);

    // מחזירים את הערך המקסימלי בין שני המסלולים האפשריים
    return Math.max(option1, option2);
}

    }
    
    /*
     * חילוק ב-10: כאשר מחלקים מספר ב-10, מקבלים את המספר השלם שנמצא בצד שמאל
     *  של הנקודה העשרונית (לדוגמה, 23/10 נותן 2). 
     * הערך הזה מייצג את מספר העמודות שנעבור.
שארית החילוק באחוזים: כאשר מבצעים מודולו (שארית) של מספר ב-10,
 מקבלים את הספרה הימנית ביותר של המספר (לדוגמה, 23%10 נותן 3).
  הערך הזה מייצג את מספר השורות שנעבור.
     */
}
    
