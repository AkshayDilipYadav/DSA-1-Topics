/*Array : One Dimentional
* 1. Max Sum  Contiguous Subarray
* 2. Continuous Sum Query
* 3. Rain Water Trapped
* 4. Add One to Number
* 5. Flip
* */

// 1. Max Sum Contiguous Subarray
/** Kadane's Algorithm
 */
public class Solution {
    public int maxSubArray(final int[] A) {
        int n = A.length;
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
        for (int i = 1; i < n; i++){
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}

//2. Continuous Sum Query (Beggar's Donation)

public class Solution {
    public int[] solve(int A, int[][] B) {
        int [] pots = new int [A];
        for (int[] donation : B){

            int L = donation[0] - 1;
            int R = donation[1] - 1;
            int P = donation[2];
            pots[L] += P;
            if (R+1 < A){pots[R+1] -= P;}
        }
        for (int i = 1; i < A; i++){
            pots[i] += pots[i-1];
        }

        return pots;
    }
}

//3. Rain Water Trapped

public class Solution{
    public int solve(int[] A){
        if(A == null || A.length < 3){return 0;}
        int  l = 0;
        int r = A.length -1;
        int lMax = 0;
        int rMax = 0;
        int waterTrapped = 0;

        while(l < r){
            if(A[l] < A[r]){
                if(A[l] > lMax){lMax = A[l];}
                else{waterTrapped += lMax - A[l]; }
                l++;
            }
            else{
                if(A[r] > rMax){rMax = A[r];}
                else{waterTrapped += rMax - A[r];}
                r--;
            }
        }
        return waterTrapped;
    }
}

// 4. Add One to Number

public class Solution{
    public int[] solve(int[] digits){
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return removeLeadingZeros(digits);
            }
            digits[i] = 0;
        }

        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    private int[] removeLeadingZeros(int[] digits) {
        int startIndex = 0;
        while (startIndex < digits.length && digits[startIndex] == 0) {
            startIndex++;
        }
        if (startIndex == digits.length) {
            return new int[] {0};
        }
        return Arrays.copyOfRange(digits, startIndex, digits.length);
    }
    }
}

//5. Flip

public class Solution {
    public int[] flip(String A) {
        int n = A.length();
        int left =-1, right = -1, maxOnes =0, onesSoFar = 0, leftCandidate= -1;
        for (int i = 0; i<n; i++){
            if (A.charAt(i)=='0'){
                onesSoFar++;
                if (leftCandidate == -1){leftCandidate = i;}
            }else{ onesSoFar--;
                if (onesSoFar<0){onesSoFar =0; leftCandidate = i+1;}
            }

            if (onesSoFar > maxOnes){
                maxOnes = onesSoFar;
                left = leftCandidate;
                right = i;
            }
        }
        return maxOnes == 0? new int []{}:new int [] {left+1, right+1};
    }
}
