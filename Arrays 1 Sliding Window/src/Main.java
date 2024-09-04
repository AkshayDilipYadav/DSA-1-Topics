/*Sliding Window

1. Maximum Sub array
2. Sum of all Sub arrays
3. Sub array with given sum and length
4. Good Sub arrays
5. Counting Sub arrays
6. Minimum Swaps
7. Sub array with least Average
* */

//1. Maximum Subarray

public class Solution{
    public int solve(int A, int B, int[] C){
        int maxSum = 0, currentSum = 0;
        int left = 0;
        for(int right = 0; right < A; right++){
            currentSum += C[right];
            while(currentSum > B){currentSum -= C[left++];}
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}

//2. Sum of All Subarrays

public class Solution {
    public long subarraySum(int[] A) {
        long sum = 0;
        int N = A.length;

        for (int i = 0; i < N; i++){
            long contribution = (long) A[i] * (i+1) * (N-i);
            sum += contribution;
        }

        return sum;

    }
}

//3. Subaray with given Sum and Length

public class Solution {
    public int solve(int[] A, int B, int C) {
        int N = A.length;
        if (B > N) return 0;
        int windowSum = 0;
        for (int i = 0; i < B; i++) {
            windowSum += A[i];
        }

        if (windowSum == C) return 1;

        for (int i = B; i < N; i++) {
            windowSum += A[i] - A[i - B];
            if (windowSum == C) return 1;
        }

        return 0;}
}

//4. Good Subarrays

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += A[end];
                int length = end - start + 1;
                if (length % 2 == 0) {
                    if (sum < B) {
                        count++;
                    }
                } else {
                    if (sum > B) {
                        count++;
                    }
                }
            }
        }

        return count;}
}

//5. Counting Subarrays

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentSum += A[end];

            while (currentSum >= B && start <= end) {
                currentSum -= A[start++];
            }

            count += (end - start + 1);
        }

        return count;
    }
}

//6. Minimum Swaps

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int countLessEqualB = 0;

        for (int num : A) {
            if (num <= B) {
                countLessEqualB++;
            }
        }

        if (countLessEqualB == 0) {
            return 0;
        }

        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < countLessEqualB; i++) {
            if (A[i] <= B) {
                currentCount++;
            }
        }

        maxCount = currentCount;

        for (int i = countLessEqualB; i < n; i++) {
            if (A[i] <= B) {
                currentCount++;
            }
            if (A[i - countLessEqualB] <= B) {
                currentCount--;
            }
            maxCount = Math.max(maxCount, currentCount);
        }

        return countLessEqualB - maxCount;
    }
}

//7. Subarray with Least Average

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;

        int currentSum = 0;
        for (int i = 0; i < B; i++) {
            currentSum += A[i];
        }

        int minSum = currentSum;
        int minIndex = 0;

        for (int i = B; i < n; i++) {
            currentSum += A[i] - A[i - B];

            if (currentSum < minSum) {
                minSum = currentSum;
                minIndex = i - B + 1;
            }
        }

        return minIndex;
    }
}