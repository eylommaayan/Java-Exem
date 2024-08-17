public static void f (Node t) {
    f(null, t);
}

private static void f (Node p, Node t) {
    if (t == null)
        return; 
    // אם הצומת הנוכחי (t) הוא ריק, יש לעצור את הפעולה (חזרה).
    
    if (t.getLeftSon() == null && t.getRightSon() == null) {
        // בודקים אם ל-t אין בנים (אם הוא עלה)
        
        if (p.getLeftSon() == t)
            p.setLeftSon(null);
        // אם t הוא הבן השמאלי של p, מוחקים אותו על ידי הגדרת הבן השמאלי של p ל-null.
        
        else if (p.getRightSon() == t)
            p.setRightSon(null);
        // אם t הוא הבן הימני של p, מוחקים אותו על ידי הגדרת הבן הימני של p ל-null.
    } else {
        f (t, t.getLeftSon());
        f (t, t.getRightSon());
        // אם ל-t יש בנים, ממשיכים לקרוא לפונקציה עבור הבן השמאלי והימני של t.
    }
}


// (i) כיצד יראה עץ השורש לאחר שהופעלה השיטה BinaryTree.f(root)?

// 300
// /    \
// 125     400
// /
// 190


// (ii) השיטה מוחקת את כל העלים בעץ. במקרה כזה: בעץ בעל צומת אחת התוצאה שתישאר ריקה.