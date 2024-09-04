/*Sub array
1. Closest MinMax
2. Sub array in given Range
3. Generate all Sub arrays
4. Special Subsequences
5. count sub arrays
6. Best Time to buy and sell stocks
7. Pick from both sides
8. Leaders in an array
* */

//1. Closest MinMax

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        if (n == 0) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : A) {
            if (i < min) min = i;
            if (i > max) max = i;
        }

        int minIndex = -1;
        int maxIndex = -1;
        int minLength = n;

        for (int i = 0; i < n; i++) {
            if (A[i] == min) minIndex = i;
            if (A[i] == max) maxIndex = i;

            if (minIndex != -1 && maxIndex != -1) {
                int currentLength = Math.abs(minIndex - maxIndex) + 1;
                minLength = Math.min(minLength, currentLength);
            }
        }

        return minLength;
    }
}

//2. Sub array in Given Range

public class Solution{
    public int[] solve(int[] A, int B, int C){
        int subarrayLength = C-B+1;
        int[] result = new int[subarrayLength];
        for(int i = 0; i < subarrayLength; i++){
            result[i] = A[B+i];
        }
        return result;
    }
}

//3. Generate all Subarrays

public class Solution{
    public int[][] solve(int[] A){
        int n = A.length;
        int totalSubarrays = n *(n+1)/2;
        int[][] result = new int[totalSubarrays][];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int  subarrayLength = j - i + 1;
                int[] subarray = new int[subarrayLength];
                for(int k = 0; k < subarrayLength; k++){
                    subarray[k] = A[i + k];
                }
                result[index++] = subarray;
            }
        }
        return result;
    }
}

//4. Special Subsequences "AG"

public class Solution{
    public int solve(String A){
        int MOD = 1000000007;
        int countA = 0;
        int result = 0;
        for(char c : A.toCharArray()){
            if(c == 'A'){countA = (countA += 1)% MOD;}
            else if(c == 'G'){result = (result + countA)%MOD;}
        }
        return result;
    }
}

//5. Count Subarrays with unique Elements

public class Solution {
    public int solve(int[] A) {
        int MOD = 1000000007;
        int n = A.length;
        int left = 0;
        long count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (set.contains(A[right])) {
                set.remove(A[left]);
                left++;
            }
            set.add(A[right]);
            count = (count + (right - left + 1)) % MOD;
        }

        return (int) count;
    }
}

//6. Best Time to Buy and Sell Stocks

public class Solution {
    public int maxProfit(final int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : A) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

//7. Pick from both Sides

public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length;

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= B; i++) {
            int sum = 0;

            for (int j = 0; j < i; j++) {
                sum += A[j];
            }

            for (int j = n - 1; j >= n - (B - i); j--) {
                sum += A[j];
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}

//8. Leaders in an Array

public class Solution {
    public int[] solve(int[] a) {
        int n = a.length;
        int[] tempLeaders = new int[n];
        int count = 0;
        int maxRight = a[n - 1];
        tempLeaders[count++] = maxRight;

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > maxRight) {
                maxRight = a[i];
                tempLeaders[count++] = maxRight;
            }
        }

        int[] leaders = new int[count];
        for (int i = 0; i < count; i++) {
            leaders[i] = tempLeaders[count - 1 - i];
        }

        return leaders;
    }
}
