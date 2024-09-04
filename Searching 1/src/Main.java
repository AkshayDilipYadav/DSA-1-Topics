/*Searching 1
1. Sorted Insert Position
2. Search for a Range
3. Find a Peak Element
4. Single Element in Sorted Array
5. Matrix Search
6. Minimum Difference
7. Maximum Height of Staircase
*
* */

//1. Sorted Insert Position

public class Solution {
    public int searchInsert(int[] A, int B) {
        int left = 0;
        int right = A.length -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid] == B){return mid;}
            else if(A[mid] < B){left = mid + 1;}
            else{right = mid -1;}
        }
        return left;
    }
}


//2. Search for a Range

public class Solution {
    public int[] searchRange(final int[] A, int B) {
        int left = findIndex(A, B, true);
        int right = findIndex(A, B, false);
        return new int[]{left, right};

    }
    public static int findIndex(int[] A, int B, boolean isLeft){
        int low = 0, high = A.length - 1;
        int bound = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(A[mid] == B){
                bound = mid;
                if(isLeft){high = mid -1;}
                else{low = mid + 1;}
            }
            else if(A[mid] < B){low = mid + 1;}
            else{high = mid - 1;}
        }
        return bound;
    }
}

//3. Find a Peak Element

public class Solution {
    public int solve(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(A[mid] < A[mid + 1]){left = mid + 1;}
            else{right = mid;}
        }
        return A[left];
    }
}

//4. Single Element in Sorted Array

public class Solution {
    public int solve(int[] A) {
        int left = 0;
        int right = A.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid % 2 == 1) {
                mid--;
            }

            if (A[mid] == A[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return A[left];
    }
}

//5. Matrix Search

public class Solution {
    public int searchMatrix(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;

        int low = 0, high = N * M - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = A[mid / M][mid % M];

            if (midElement == B) {
                return 1;
            } else if (midElement < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }
}


//6. Minimum Difference

public class Solution {
    public int solve(int A, int B, int[][] C) {
        // Sort each row of the matrix
        for (int i = 0; i < A; i++) {
            Arrays.sort(C[i]);
        }

        int minCost = Integer.MAX_VALUE;

        // Iterate over rows starting from the second row
        for (int i = 1; i < A; i++) {
            int localMinCost = Integer.MAX_VALUE;

            // Check all pairs between the current row and the previous row
            for (int j = 0; j < B; j++) {
                for (int k = 0; k < B; k++) {
                    int diff = Math.abs(C[i][j] - C[i - 1][k]);
                    localMinCost = Math.min(localMinCost, diff);
                }
            }

            // Update the global minimum cost
            minCost = Math.min(minCost, localMinCost);
        }

        return minCost;
    }
}


//7. Maximum Height of Staircase

public class Solution {
    public int solve(int A) {
        if (A == 0) return 0;

        int low = 1, high = (int) Math.sqrt(2 * (long) A);
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long blocksUsed = (long) mid * (mid + 1) / 2;

            if (blocksUsed <= A) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
