

public class find {
    

    public static int find(Node root, int num) {
        // אם הצומת הנוכחי הוא null, החזר -1
        if (root == null)
            return -1;
        // אם המספר בצומת הנוכחי הוא num, החזר num
        if (root.getNumber() == num)
            return num;
        // אם המספר בצומת הנוכחי קטן מ-num
        else if (root.getNumber() < num) {
            // חפש בצד הימני של העץ
            int k = find(root.getRightSon(), num);
            // אם לא נמצא בצד הימני, החזר את המספר בצומת הנוכחי
            if (k == -1)
                return root.getNumber();
            else
                return k; // אם נמצא בצד הימני, החזר את הערך שנמצא
        }
        // אם המספר בצומת הנוכחי גדול מ-num, חפש בצד השמאלי של העץ
        else if (root.getNumber() > num)
            return find(root.getLeftSon(), num);
        // אם לא נמצא, החזר -1
        return -1;
    }
    


}
