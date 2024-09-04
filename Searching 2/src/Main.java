/*Searching 2
1. Rotated Sorted Arrays Search
2. Ath Magical Number
3. Square Root of Integer
4. Add or Not
5. Find Smallest Again
6. Matrix Median
*
* */

//1. Rotated Sorted Arrays Search

public class Solution {
    public int search(final int[] A, int B) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (A[mid] == B) {
                return mid;
            }

            if (A[left] <= A[mid]) {
                if (A[left] <= B && B < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < B && B <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}


//2. Ath Magical Number

public class Solution {
    private static final int MOD = 1000000007;

    public int solve(int A, int B, int C) {
        long left = 1, right = (long) A * Math.max(B, C);

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(mid, B, C) < A) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int)(left % MOD);
    }

    private long count(long x, int B, int C) {
        return (x / B) + (x / C) - (x / lcm(B, C));
    }

    private long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


//3. Square Root of Integer

public class Solution {
    public int sqrt(int A) {
        if (A == 0 || A == 1) {
            return A;
        }

        int left = 1;
        int right = A;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquared = (long) mid * mid;

            if (midSquared == A) {
                return mid;
            } else if (midSquared < A) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}


//4. ADD or NOT

public class Solution {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        int[] sortedA = Arrays.copyOf(A, n);
        Arrays.sort(sortedA);

        int maxOccurrences = 0;
        int resultValue = Integer.MAX_VALUE;

        int l = 0;
        long currentOperations = 0;

        for (int r = 0; r < n; r++) {
            // Add operations needed to make all elements between l and r equal to sortedA[r]
            if (r > 0) {
                currentOperations += (long) (sortedA[r] - sortedA[r - 1]) * (r - l);
            }

            // Adjust left pointer while operations exceed B
            while (currentOperations > B) {
                currentOperations -= (sortedA[r] - sortedA[l]);
                l++;
            }

            // Calculate current frequency of sortedA[r]
            int currentFrequency = r - l + 1;

            if (currentFrequency > maxOccurrences) {
                maxOccurrences = currentFrequency;
                resultValue = sortedA[r];
            } else if (currentFrequency == maxOccurrences) {
                resultValue = Math.min(resultValue, sortedA[r]);
            }
        }

        return new int[] { maxOccurrences, resultValue };
    }
}


//5. Find Smallest Again

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;

        // Sorting the array to facilitate triplet sum calculations
        Arrays.sort(A);

        // Determine the possible range of triplet sums
        int low = A[0] + A[1] + A[2];
        int high = A[n - 1] + A[n - 2] + A[n - 3];

        // Binary search to find the B-th smallest sum
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countTripletsLessThanOrEqual(A, mid) < B) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Function to count the number of triplets with sum <= x
    private int countTripletsLessThanOrEqual(int[] A, int x) {
        int n = A.length;
        int count = 0;

        // Count triplets using a two-pointer approach
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum <= x) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }
}


//6. Matrix Median

public class Solution {
    public int findMedian(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int totalElements = N * M;
        int medianIndex = totalElements / 2;

        // Determine the min and max value in the matrix
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            minVal = Math.min(minVal, A[i][0]);
            maxVal = Math.max(maxVal, A[i][M - 1]);
        }

        // Perform binary search to find the median
        while (minVal < maxVal) {
            int mid = minVal + (maxVal - minVal) / 2;
            if (countLessEqual(A, mid) <= medianIndex) {
                minVal = mid + 1;
            } else {
                maxVal = mid;
            }
        }

        return minVal;
    }

    // Count elements less than or equal to x
    private int countLessEqual(int[][] A, int x) {
        int count = 0;
        for (int[] row : A) {
            count += countInRow(row, x);
        }
        return count;
    }

    // Count elements <= x in a sorted row
    private int countInRow(int[] row, int x) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;  // Low is the count of elements <= x
    }
}
