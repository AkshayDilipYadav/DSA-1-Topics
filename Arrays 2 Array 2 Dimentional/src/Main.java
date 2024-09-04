/*Array 2 Dimentional
1. Spiral Order Matrix
2. Search in a row wise and column wise sorted matrix
3. sum of all submatrices
4. Row with maximum number of ones
5. Minimum Swaps
*
* */

//1. Spiral Order Matrix

public class Solution {
    public int [][] generateMatrix(int A){
        int [][] matrix = new int [A][A];
        int num =1;
        int topRow =0, bottomRow = A-1, leftColumn =0, rightColumn= A-1;
        int t= A*A;
        while (t>=0){
            for (int i = leftColumn; i <= rightColumn; i++){matrix [topRow][i] = num++;} topRow++; t--;
            for (int i = topRow; i <= bottomRow; i++){matrix [i][rightColumn] = num++;} rightColumn--; t--;
            for (int i = rightColumn; i >= leftColumn; i--){matrix [bottomRow][i] = num++;} bottomRow--; t--;
            for (int i = bottomRow; i >= topRow; i--){matrix [i][leftColumn] = num++;} leftColumn++; t--;

        }
        return matrix;
    }
}

//2. Search in a row wise and column wise sorted Matrix

public class Solution{
    public int solve(int[][] matrix, int B){
        int N = matrix.length;
        if (N == 0) return -1;
        int M = matrix[0].length;
        if (M == 0) return -1;

        int row = 0;
        int col = M - 1;
        int smallestPosition = Integer.MAX_VALUE;

        while (row < N && col >= 0) {
            if (matrix[row][col] == B) {
                int position = (row + 1) * 1009 + (col + 1);
                if (position < smallestPosition) {
                    smallestPosition = position;
                }
                col--;
            } else if (matrix[row][col] > B) {
                col--;
            } else {
                row++;
            }
        }

        return (smallestPosition == Integer.MAX_VALUE) ? -1 : smallestPosition;
    }
}

//3. Sum of all SubMatrices

public class Solution {
    public int solve(int[][] A) {
        int n = A.length;
        int sum =0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sum += A[i][j] * (i +1) * (j+1)* (n-i)* (n-j);
            }
        }
        return sum;
    }
}

//4. Row with Maximum number of ones

public class Solution{
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int maxOnesRowIndex =0;

        int i = 0, j = m-1;
        while (i < n && j >= 0){
            if (A[i][j]==1){maxOnesRowIndex= i; j--;}
            else {i++;}
        }
        return maxOnesRowIndex;
    }
}

//5. Minimum Swaps

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++){
            if (A[i] <= B){count++;}
        }

        for (int i =0; i < count; i++){
            if (A[i] <= B){maxCount++;}
        }

        int swaps = count - maxCount;

        for (int i = count; i < n; i++){
            if (A[i - count] <= B){maxCount--;}
            if (A[i] <= B){maxCount++;}
            swaps = Math.min(swaps, count - maxCount);
        }
        return swaps;
    }
}
