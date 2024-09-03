/*Prefix Sum

* 1. Range Sum Query
* 2. Even Numbers in A Range
* 3. Equilibrium index of an array
* 4. In place Prefix Sum
* */

// 1. Range Sum Query

public class Solution{
    public long[] solve(int[] A, int[][] B){
        int n = A.length;
        int m = B.length;
        int[] sum = new int[n];
        sum[0] = A[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + A[i];
        }
        long[] querySum = new long[m];
        for(int i = 0; i < m; i++){
            int l = B[i][0];
            int r= B[i][1];
            if(l > 0 ){querySum[i] = sum[r] - sum[l-1];}
            else{querySum[i] = sum[r];}
        }
        return querySum;
    }
}

//2. Even Number in a Range

public class Solution{
    public int[] solve(int[] A, int[][] B){
        int n = A.length;
        int m = B.length;
        int[] evenCountPrefix = new int[n];
        for(int i = 0; i <n; i++){
            evenCountPrefix[i+1] = evenCountPrefix[i] + (A[i] % 2 == 0 ? 1:0);
        }
        int[] result = new int[m];
        for(int i = 0; i < m; i++){
            int l = B[i][0];
            int r = B[i][1];
            result[i] = evenCountPrefix[r] + evenCountPrefix[l];
        }
        return result;
    }
}

//3. Equillibrium index

public class Solution {
    public int solve(int[] A) {
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (leftSum == totalSum - leftSum - A[i]) {
                return i;
            }
            leftSum += A[i];
        }

        return -1;
    }
}

//4. Inplace Prefix

public class Solution {
    public int[] solve(int[] A) {
        int n = A.length;

        for (int i = 1; i < n ; i++) {
            A[i] = A[i] + A[i - 1];
        }

        return A;
    }
}
