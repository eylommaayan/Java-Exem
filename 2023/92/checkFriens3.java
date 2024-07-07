public class checkFriens3 {
  
    public static int friends3(int[][] mat) {
        return friends3(mat, 0, 1, 2, 0);
    }
    
    private static int friends3(int[][] mat, int i, int j, int k, int count) {
        int n = mat.length;
        // if we found 3 friends then we increment the counter and print them
        if (checkFriends3(mat, i, j, k)) {
            count++;
            System.out.println(i + " " + j + " " + k);
        }
        // update k, then j, then i
        if (k < n - 1)
            return friends3(mat, i, j, k + 1, count);
        if (j < n - 2)
            return friends3(mat, i, j + 1, j + 2, count);
        if (i < n - 3)
            return friends3(mat, i + 1, i + 2, i + 3, count);
        return count;
    }
    
}
