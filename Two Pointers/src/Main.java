/*Two Pointers
1. Pairs With Given Sum
2. Pairs with given Difference
3. Subarray with given Sum
4. Container with most water
5. 3Sum
6. Another Count Rectangles
7. Closest pair from sorted Arrays
8. Max Continuous Series of 1's
9. Array 3 Pointers
*
* */

//1. Pairs with given Sum

public class Solution {
    public int solve(int[] A, int B) {
        int MOD = 1000000007;
        int left = 0, right = A.length - 1;
        long count = 0;

        while (left < right) {
            int sum = A[left] + A[right];

            if (sum == B) {
                if (A[left] == A[right]) {
                    // If both elements are the same, the number of pairs is (nC2) where n = right - left + 1
                    int num = right - left + 1;
                    count += (long)num * (num - 1) / 2;
                    count %= MOD;
                    break;  // As all pairs are counted, we can exit the loop
                } else {
                    // If elements are different, count the occurrences of A[left] and A[right]
                    int leftCount = 1, rightCount = 1;

                    while (left + 1 < right && A[left] == A[left + 1]) {
                        left++;
                        leftCount++;
                    }

                    while (right - 1 > left && A[right] == A[right - 1]) {
                        right--;
                        rightCount++;
                    }

                    count += (long)leftCount * rightCount;
                    count %= MOD;

                    left++;
                    right--;
                }
            } else if (sum < B) {
                left++;
            } else {
                right--;
            }
        }

        return (int)count;
    }
}


//2. Pairs with Given Difference

public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int left = 0, right = 1;
        int count = 0;

        while (right < A.length) {
            if (left == right) {
                right++;  // Move the right pointer ahead to maintain left < right
            } else {
                int diff = A[right] - A[left];

                if (diff == B) {
                    count++;
                    // Move to the next unique element for both pointers
                    while (right < A.length && A[right] == A[right - 1]) {
                        right++;
                    }
                    while (left < A.length - 1 && A[left] == A[left + 1]) {
                        left++;
                    }
                    right++;
                    left++;
                } else if (diff < B) {
                    right++;
                } else {
                    left++;
                }
            }
        }

        return count;
    }
}


//3. Subarray with given Sum

public class Solution {
    public int[] solve(int[] A, int B) {
        int start = 0;
        int currentSum = 0;

        for(int end = 0; end < A.length; end++) {
            currentSum += A[end];

            // Shrink the window as long as the current sum is greater than B
            while(currentSum > B && start <= end) {
                currentSum -= A[start];
                start++;
            }

            // If currentSum matches B, return the subarray
            if(currentSum == B) {
                return Arrays.copyOfRange(A, start, end + 1);
            }
        }

        // If no subarray is found, return [-1]
        return new int[]{-1};
    }
}


//4. Container with Most Water

public class Solution {
    public int maxArea(int[] A) {
        int left = 0;
        int right = A.length -1;
        int maxArea = 0;
        /*
        * while(){
            if(){}
            else{}
        }*/
        while(left < right){
            int height = Math.min(A[left], A[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
            if(A[left] < A[right]){left++;}
            else{right--;}
        }
        return maxArea;
    }
}


//5. 3 Sum

public class Solution {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int closestSum = A[0] + A[1] + A[2];
        for(int i = 0; i < A.length - 2; i++){
            int left = i + 1;
            int right = A.length - 1;
            /* while(){
                if(){}
                if(){}
                else if(){}
                else{}
            }*/
            while(left < right){
                int currentSum = A[i] + A[left] + A[right];
                if(Math.abs(B - currentSum) < Math.abs(B - closestSum)){
                    closestSum = currentSum;
                }
                if(currentSum < B){left++;}
                else if(currentSum > B){right--;}
                else{return currentSum;}
            }
        }
        return closestSum;
    }
}


//6. Another Count Rectangles

public class Solution {
    public int solve(int[] A, int B) {
        final int MOD = 1000000007;
        int n = A.length;
        int i = 0;
        int j = n -1;
        long count = 0;
        /*while(i <= j){
            if(){}
            else{}
        }*/
        while(i <= j){
            if((long) A[i] * A[j] < B){
                count = (count + (j - i + 1)* 2 -1)% MOD;
                i++;
            }
            else{j--;}
        }
        return (int) count;
    }
}


//7. Closest Pair from Sorted Arrays

public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length;
        int m = B.length;
        int i = 0;
        int j = m - 1;
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;
        /*  while(){
            if(){}
            else if(){
                if(){}
            }
            if(){}
            else{}
        }*/
        while(i < n && j >= 0){
            int sum = A[i] + B[j];
            int currentDiff = Math.abs(sum - C);
            if(currentDiff < minDiff){
                minDiff = currentDiff;
                result[0] = A[i];
                result[1] = B[j];
            }
            else if(currentDiff == minDiff){
                if(A[i] < result[0] || (A[i] == result[0] && B[j] < result[1])){
                    result[0] = A[i];
                    result[1] = B[j];
                }
            }
            if(sum < C){i++;}
            else{j--;}
        }
        return result;
    }
}


//8. Max Continuous Series of 1's

public class Solution {
    public int[] maxone(int[] A, int B) {

        int n = A.length;
        int start = 0, end = 0;
        int zeroCount = 0;
        int maxLen = 0;
        int bestStart = 0;
        /*while(end < n){
            if(){}
            while(){
                if(){}
            }
            if(){}
        }*/
        while(end < n){
            if(A[end] == 0){zeroCount++;}
            while(zeroCount > B){
                if(A[start] == 0){zeroCount--;}
                start++;
            }
            if(end - start + 1 > maxLen){
                maxLen = end - start +1;
                bestStart = start;
            }
            end++;
        }
        int[] result = new int[maxLen];
        for(int i = 0; i < maxLen; i++){
            result[i] = bestStart + i;
        }
        return result;

    }
}


//9. Array 3 Pointer

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        while(i < A.length && j < B.length && k < C.length){
            int maxVal =Math.max( Math.max(A[i], B[j]), C[k]);
            int minVal = Math.min(Math.min(A[i], B[j]), C[k]);
            minDiff = Math.min(minDiff, maxVal - minVal);
            if(minVal == A[i]){i++;}
            else if(minVal == B[j]){j++;}
            else{k++;}
        }
        return minDiff;
    }

}
