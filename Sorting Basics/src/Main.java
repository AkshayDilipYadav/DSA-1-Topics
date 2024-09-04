/*Sorting Basics
1. Elements Removal
2. Noble Integer
3. Kth Smallest Element
4. Arithmetic Progression?
*
* */

//1. Elements Removal

public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        Arrays.sort(A);

        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            totalCost += A[i]*(n-i);
        }

        return totalCost;
    }
}

//2. Noble Integer

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        for(int i = 0; i< A.length; i++){
            if(A[i] == n - i -1){
                if(i == n-1 || A[i] != A[i+1]){return 1;}
            }
        }
        return -1;
    }
}

//3. Kth Smallest Element

public class Solution {
    public int kthsmallest(final int[] A, int B) {
        Arrays.sort(A);
        return A[B-1];
    }
}

//4. Arithmetic Prograssion

import java.util.Arrays;

public class Solution {
    public int solve(int[] A) {
        int n = A.length;

        Arrays.sort(A);

        int commonDiff = A[1] - A[0];

        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] != commonDiff) {
                return 0;
            }
        }

        return 1;
    }
}