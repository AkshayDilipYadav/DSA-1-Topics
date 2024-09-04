/*2D Matrix
1. Column Sum
2. Main Diagonal Sum
3. Anti Diagonals
4. Matrix Transpose
5. Rotate Matrix
6. Row Sum
7. Minor Diagonal Sum
8. Matrix Scaler Product
9. Add the Matrices
*
* */

//1. Column Sum

public class Solution {
    public int[] solve(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0){
            return new int [0];
        }
        int n = A.length;
        int m = A[0].length;

        int [] columnSums = new int [m];
        for (int j = 0; j < m; j++){
            for (int i = 0; i < n; i++){
                columnSums[j] += A[i][j];
            }
        }
        return columnSums;
    }
}

//2. Main Diagonal Sum

public class Solution {
    public int solve(final int[][] A) {
        int sum = 0;
        int n = A.length;
        for (int i  = 0; i < n; i++){
            sum += A[i][i];
        }
        return sum;
    }
}

//3. Anti Diagonals

public class Solution {
    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int [][] result = new int [2* n-1][n];
        for (int d = 0; d < n; d++){
            int r = 0; int c = d;
            int index =0;
            while(c >= 0){
                result[d][index] = A[r][c];
                r++;
                c--;
                index++;
            }
        }
        for (int d  = n; d < 2* n -1; d++){
            int r = d - n +1;
            int c = n-1;
            int index =0;
            while (r < n){
                result[d][index] = A[r][c];
                r++;
                c--;
                index++;
            }
        }
        return result;

    }

}

//4. Matrix Transpose

public class Solution {
    public int[][] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = A[i][j];
            }
        }

        return transpose;
    }
}

//5. Rotate Matrix

public class Solution {
    public void solve(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n - 1 - j];
                A[i][n - 1 - j] = temp;
            }
        }
    }
}

//6. Row Sum

public class Solution {
    public int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[] result = new int[rows];

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                sum += A[i][j];
            }
            result[i] = sum;
        }

        return result;
    }
}


//7. Minor Diagonal Sum

public class Solution {
    public int solve(final int[][] A) {
        int n = A.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i][n - i - 1];
        }

        return sum;
    }
}

// 8. Matrix Scalar Product

public class Solution {
    public int[][] solve(int[][] A, int B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] * B;
            }
        }

        return result;
    }
}

//9. Add the Matrices

public class Solution {
    public int[][] solve(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }
}