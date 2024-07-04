public static boolean searchCircularMatrix(int[][] mat, int num) {
    int row = 0, col = 0; // Left upper corner
    int n = mat.length; // Length of square

    while (n > 1) {
        // We do not check square number 1 because we do not need to move the corner

        // Check square number 2 פינה שמאלית עליונה ופינה שמאלית תחתונה של רובע 
        if (mat[row][col + n / 2] <= num && num <= mat[row + n / 2 - 1][col + n / 2]) {
            col = col + n / 2;// התור משתנה
        }
        // Check square number 3
        else if (mat[row + n / 2][col] <= num && num <= mat[row + n / 2 + n / 2 - 1][col + n / 2]) {
            row = row + n / 2;  // עדכון פינה שמאלית
            col = col + n / 2;
        }
        // Check square number 4 פינה שמאלית עליונה ותחתונה
        else if (mat[row + n / 2][col] <= num && num <= mat[row + n / 2 + n / 2 - 1][col]) {
            row = row + n / 2;
        }
        n /= 2; // Reduce the size of the matrix
    }

    // The square is of size 1 now
    if (mat[row][col] == num) {
        System.out.println("row = " + row + "\ncol = " + col);
        return true;
    }

    // The element is not in the matrix
    return false;
}
