/*Sorting
1. Factors Sort
2. B closest Points to Origin
3. Sort 01
4. Partition Index
5. Quick Sort
6. Wave Array
7. Tens Digit Sorting
8. Sort By Color
9. Largest Number
*
* */

//1. Factors Sort

public class Solution {
    public static int countFactors(int A){
        /* Process -
         */
        int count = 0;
        for(int i =1; i*i <= A; i++){
            if(A % i == 0){
                if(i * i == A){count++;} // i = A / J = count increases to one
                else{
                    count += 2; // else there are two element counted that divides A
                }
            }
        }
        return count;
    }
    public int[] solve(int[] A) {
        int[] factorCount = new int[A.length];
        for(int i = 0; i < A.length; i++){factorCount[i] = countFactors(A[i]);}

        Integer[] indices = new Integer[A.length];
        for(int i = 0; i < A.length; i++){indices[i] = i;}

        Arrays.sort(indices, (i, j) -> {
            if(factorCount[i] != factorCount[j]){return factorCount[i] - factorCount[j];}
            else{ return A[i] - A[j];}
        });

        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++){result[i] = A[indices[i]];}
        return result;
    }
}


//2. B Closest Points to Origin

public class Solution {
    public int[][] solve(int[][] A, int B) {
        quickselect(A, 0, A.length - 1, B);

        // Extract the first B points
        int[][] result = new int[B][2];
        for (int i = 0; i < B; i++) {
            result[i] = A[i];
        }

        return result;
    }

    private void quickselect(int[][] A, int left, int right, int B) {
        if (left < right) {
            int pivotIndex = partition(A, left, right);
            if (pivotIndex == B - 1) {
                return;  // We've found the B closest points
            } else if (pivotIndex < B - 1) {
                quickselect(A, pivotIndex + 1, right, B);
            } else {
                quickselect(A, left, pivotIndex - 1, B);
            }
        }
    }

    private int partition(int[][] A, int left, int right) {
        int[] pivot = A[right];
        int pivotDist = distanceSquared(pivot);
        int i = left;

        for (int j = left; j < right; j++) {
            if (distanceSquared(A[j]) <= pivotDist) {
                swap(A, i, j);
                i++;
            }
        }
        swap(A, i, right);
        return i;
    }

    private int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] A, int i, int j) {
        int[] temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

//3. Sort 01

public class Solution {
    public int[] sort01(int[] A) {
        int n = A.length;

        int count0 = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                count0++;
            }
        }

        for (int i = 0; i < count0; i++) {
            A[i] = 0;
        }
        for (int i = count0; i < n; i++) {
            A[i] = 1;
        }

        return A;
    }
}

//4. Patition Index

public int partition(int[] A) {
            /* Initialization-
        initialise the pivot point as the last element
        and i as -1
         */

    int pivot = A[A.length - 1];
    int i = -1;

    /* Process -
     */
    for(int j = 0; j < A.length - 1; j++){
        if(A[j ] < pivot){
            i++;
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
    int temp = A[i + 1];
    A[i + 1] = A[A.length - 1];
    A[A.length - 1] = temp;
    return i + 1;
}

//5. Quick Sort

public class Solution {
    public int[] solve(int[] A) {

        if(A == null || A.length == 0){return A;}
        quickSort(A, 0 , A.length - 1);
        return A;

    }
    public static void quickSort(int[] A, int low, int high){

        if(low < high){
            int partitionIndex = partition(A, low, high);
            quickSort(A, low, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, high);
        }

    }

    public static int partition(int[] A, int low, int high){

        int pivot = A[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(A[j] < pivot){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i+1] = A[high];
        A[high] = temp;
// Result -
        return i + 1;
    }
}

//6. Wave Array

public class Solution {
    public int[] wave(int[] A) {

        Arrays.sort(A);

        for(int i = 0 ; i < A.length - 1; i += 2){
            int temp = A[i];
            A[i] = A[i+1];
            A[i+1] = temp;
        }
        return A;
    }
}


//7. Tens Digit Sorting

public class Solution {
    public int[] solve(int[] A) {

        Integer[] arr = new Integer[A.length];
        for(int i = 0 ; i < A.length; i++){arr[i] = A[i];}

        Arrays.sort(arr, (a, b) -> {
            int tensA = (a/10)%10;
            int tensB = (b/10)%10;
            if(tensA != tensB){return Integer.compare(tensA, tensB);}
            else{return Integer.compare(b, a);
            }
        });
        for(int i = 0; i < A.length; i++){
            A[i] = arr[i];
        }
// Result -
        return A;
    }
}


// 8. Sort By Color

public class Solution {
    public int[] sortColors(int[] A) {

        int l = 0,  m = 0, h = A.length -1;

        while(m <= h){
            if(A[m] == 0){
                swap(A, l, m);
                l++;
                m++;
            }
            else if(A[m] == 1){m++;}
            else{swap(A, m, h);
                h--;
            }
        }
        return A;
    }

    public static void swap(int[] A, int i , int j){

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

    }
}

//9. Largest Number

public class Solution {
    public String largestNumber(int[] A) {
        String[] nums = Arrays.stream(A)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y);
            }
        });

        if (nums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
