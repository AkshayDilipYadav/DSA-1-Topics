/* Searching 3
1. Painter's Partition Problem
2. Aggressive Cows
3. Allocate Books
4. Special Integer
*
* */

//1. Painter's Partition Problem

public class Solution {
    private static final int MOD = 10000003;

    public int paint(int A, int B, int[] C) {
        int N = C.length;

        // Edge case: If there are more painters than boards, reduce painters to the number of boards
        if (A > N) {
            A = N;
        }

        // Binary Search initialization
        int low = findMax(C); // max element in C
        int high = findSum(C); // sum of all elements in C

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPaint(C, A, B, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Calculate result using modular arithmetic
        return (int)((result * (long)B) % MOD);
    }

    // Helper function to check if a given time is feasible
    private boolean canPaint(int[] C, int A, int B, int maxTime) {
        int painterCount = 1;
        int currentSum = 0;

        for (int length : C) {
            if (currentSum + length > maxTime) {
                painterCount++;
                currentSum = length;
                if (painterCount > A) {
                    return false;
                }
            } else {
                currentSum += length;
            }
        }
        return true;
    }

    // Helper function to find maximum element in the array
    private int findMax(int[] C) {
        int max = C[0];
        for (int i = 1; i < C.length; i++) {
            if (C[i] > max) {
                max = C[i];
            }
        }
        return max;
    }

    // Helper function to find sum of all elements in the array
    private int findSum(int[] C) {
        int sum = 0;
        for (int length : C) {
            sum += length;
        }
        return sum;
    }
}


//2. Aggressive Cows

public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int low = 1;
        int high = A[A.length - 1] - A[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(A, B, mid)) {
                result = mid;
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }

        return result;
    }

    private boolean canPlaceCows(int[] A, int B, int minDist) {
        int cowsPlaced = 1;
        int lastPos = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] - lastPos >= minDist) {
                cowsPlaced++;
                lastPos = A[i];
                if (cowsPlaced == B) {
                    return true;
                }
            }
        }

        return false;
    }
}


//3. Allocate Books

public class Solution {
    public int books(int[] A, int B) {
        int n = A.length;

        // If students are more than books, it's impossible to allocate.
        if (B > n) return -1;

        int low = getMax(A);
        int high = getSum(A);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(A, B, mid)) {
                result = mid;
                high = mid - 1; // Try for a smaller max
            } else {
                low = mid + 1; // Increase the allowed maximum pages
            }
        }

        return result;
    }

    private int getMax(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        return sum;
    }

    private boolean isPossible(int[] A, int B, int maxPages) {
        int studentsRequired = 1;
        int currentSum = 0;

        for (int pages : A) {
            if (currentSum + pages > maxPages) {
                studentsRequired++;
                currentSum = pages;
                if (studentsRequired > B) {
                    return false;
                }
            } else {
                currentSum += pages;
            }
        }

        return true;
    }
}


//4. Special Integer

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;
        int low = 1, high = n;
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(A, B, mid)) {
                answer = mid;
                low = mid + 1; // Try for a larger K
            } else {
                high = mid - 1; // Try for a smaller K
            }
        }

        return answer;
    }

    private boolean isValid(int[] A, int B, int K) {
        long sum = 0;
        // Calculate the sum of the first K elements
        for (int i = 0; i < K; i++) {
            sum += A[i];
        }

        // If the sum of the first K elements is greater than B, return false
        if (sum > B) return false;

        // Use sliding window to check other subarrays of length K
        for (int i = K; i < A.length; i++) {
            sum += A[i] - A[i - K];
            if (sum > B) return false;
        }

        return true;
    }
}
