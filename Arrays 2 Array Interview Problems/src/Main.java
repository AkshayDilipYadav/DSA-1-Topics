/*Array Interview Problem
1. First Missing Integer
2. Merge Intervals
3. Merge Sorted Overlapping Intervals
4. Next Permutation
5. number of Digit one
*
* */

//1. First Missing Integer

public class Solution{
    public int solve(int[] nums){
        int n = nums.length;
        // Step 1: First pass - Place each number in its correct index if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        // Step 2: Second pass - Find the first index which does not have the correct value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // Step 3: If all indices have the correct values, then the missing integer is n + 1
        return n + 1;
    }
}

//2. Merge Intervals

public class Solution{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        int i = 0;
        int n = intervals.size();

        // Step 1: Add all intervals that come before the new interval
        while (i < n && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }

        // Step 2: Merge all overlapping intervals with the new interval
        while (i < n && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add all intervals that come after the new interval
        while (i < n) {
            result.add(intervals.get(i++));
        }

        return result;
    }
}

//3. Merge Sorted Overlapping Intervals


public class Solution {
    public Interval[] merge(Interval[] intervals) {

        if (intervals == null || intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int n = intervals.length;
        int mergedCount = 0;

        for (int i = 1; i < n; i++) {
            if (intervals[i].start <= intervals[mergedCount].end) {
                intervals[mergedCount].end = Math.max(intervals[mergedCount].end, intervals[i].end);
            } else {
                mergedCount++;
                intervals[mergedCount] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, mergedCount + 1);
    }
}

//4. Next Permutation

public class Solution{
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n = A.size();

        // Step 1: Find the first index from the end where the current number is less than the next one.
        int i = n - 2;
        while (i >= 0 && A.get(i) >= A.get(i + 1)) {
            i--;
        }

        if (i >= 0) {
            // Step 2: Find the first number from the end that is greater than A.get(i) and swap them.
            int j = n - 1;
            while (A.get(j) <= A.get(i)) {
                j--;
            }
            Collections.swap(A, i, j);
        }

        // Step 3: Reverse the numbers from i+1 to the end of the array to get the next permutation.
        Collections.reverse(A.subList(i + 1, n));

        return A;
    }
}

//5. Number of Digit One

public class Solution {
    public int solve(int A) {
        int count = 0;
        for (long i = 1; i <= A; i *= 10) {
            long divider = i * 10;
            count += (A / divider) * i + Math.min(Math.max(A % divider - i + 1, 0), i);
        }
        return count;
    }
}
