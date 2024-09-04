/* Sorting
1.Merge Two Sorted Array
2. Inversion Count in An Array
3. Count Sort
4. Merge Sort
5. Smallest Number
6. Sort subarray with left and right index
7. Minimum Absolute Difference
8. Max Chunks to make Sorted
*
* */

//1. Merge Two Sorted Array

public class Solution{
    public int[] solve(final int[] A, final int[] B) {
        int al = A.length;
        int bl = B.length;
        int[] result = new int[al + bl];
        int i = 0, j = 0, k =0;
//3 while loop
        while(i < al && j < bl){
            if(A[i] <= B[j]){
                result[k++] = A[i++];
            }
            else{
                result[k++] = B[j++];
            }
        }
        while(i < al){result[k++] = A[i++];}

        while(j < bl){result[k++] = B[j++];}

        return result;
    }
}

//2. Inversion count in an Arary

public class Solution{

    private static final int MOD = 1000000007;

    public int solve(int[] A){
        if(A == null || A.length < 2){return 0;}
        int[] B = new int[A.length];
        return fun1(A, B, 0, A.length -1);
    }

    private static int fun1(int[] A, int[] B, int l, int r){
        if(l >= r){return 0;}
        int mid = (l + r)/2;
        int lcount = fun1(A, B, l, mid);
        int rcount = fun1(A, B, mid + 1, r);
        int mergeCount = fun2(A, B, l, mid, r);
        return (lcount + rcount + mergeCount)% MOD;
    }

    private static int fun2(int[] A, int[] B, int l, int mid, int r){
        for(int i = l; i <= r; i++){
            B[i] = A[i];
        }
        int i = l, j = mid +1, k = l;
        int count = 0;

        while(i <= mid && j <= r){
            if(B[i] <= B[j]){A[k++] = B[i++];}
            else{
                A[k++] = B[j++];
                count = (count +(mid - i + 1))% MOD;
            }
        }
        while(i <= mid){A[k++] = B[i++];}
        while(j <= r){A[k++] = B[j++];}
        return count;
    }
}

//3. Count Sort

public class Solution{
    public int[] solve(int[] A){
        if(A == null || A.length == 0){return new int[0];}
//1. Finding Maximum
        int max = 0;
        for(int num : A){if(num > max){max = num;}}

//2. Counting Occurences
        int[] count = new int[max+1];
        for(int num : A){count[num]++;}

//3. Cumulative Count
        for(int i = 1; i <= max; i++){count[i] += count[i-1];}

// 4. Placing Elements in the sorted Array
        int[] sortedArray = new int[A.length];
        for(int i = A.length-1; i >= 0; i--){
            sortedArray[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }
        return sortedArray;
    }
}

//4. Merge Sort

public class Solution {
    public int[] solve(int[] A) {
           /* Process -
        if(A is null or A length is less than 2){return A}
        create a array aux of A.length to assist merging process
        call the halfer function with inputs as Array A, Array Aux, 0 as left, right as A.length - 1
         */
        if(A == null || A.length < 2){return A;}
        int[] aux = new int[A.length];
        halfer(A, aux, 0, A.length -1);
        return A;

// Result -

    }
    public static void halfer(int[] A, int[] aux, int left, int right){
        /* Process -
        halfer function recursively divides the array A into smaller subarrays until each subarray has only one element
        merge function is called to sort and merge the halved arrays recursively
         */
        if(left < right){
            int middle = (left + right) / 2;
            halfer(A, aux, left, middle);
            halfer(A, aux, middle+1, right);

            merge(A,aux, left, middle, right);
        }

// Result -

    }
    public static void merge(int[] A, int[] aux, int left, int middle, int right){
        /* Process -
        for(i = left to right){ Populate the aux Array with Array A elements}
        initialise the i to left j to middle + 1 k to left
        while( i <= middle && j <= right){
        if(){}
        else{}
        }
        while(){}
         */
        for(int i = left; i <= right; i++){aux[i] = A[i];}
        int i = left, j = middle + 1, k = left;
        while(i <= middle && j <= right){
            if(aux[i] <= aux[j]){
                A[k] = aux[i];
                i++;
            }
            else{
                A[k] = aux[j];
                j++;
            }
            k++;
        }
        while(i <= middle){
            A[k] = aux[i];
            i++;
            k++;
        }
    }
}


//5. Smallest Number

public class Solution {
    public int[] smallestNumber(int[] A) {
             /* Process -
        1. Initialise the Count Array
        2. counting occurences of each digit
        for(){}
        3. initialise the index value with 0 value and array result of A.length
        4. populating the result array with the sorted array

         */
        int[] count = new int[10];
        for(int num : A){count[num]++;}
        int index = 0;
        int[] result = new int[A.length];
        for(int digit = 0; digit < 10; digit++){
            while(count[digit]>0){
                result[index++] = digit;
                count[digit]--;
            }
        }
        return result;
    }
}


//6. Sort Subarray with Left and Right Index

public class Solution {
    public int[] sortSubarray(int[] A, int B, int C) {
                /* Process -
        1. create a array subarray of length from B to C
        2. call the halfer function with inputs as subarray of length b to c, 0 as left, subarray.length -1  as right
        3. after all process populate the array A with the values from sorted subarray
        4. return A
         */
        int[] bToC = Arrays.copyOfRange(A, B, C+1);
        halfer(bToC, 0 , bToC.length - 1);
        for(int i = B; i <=C; i++){A[i] = bToC[i-B];}
        return A;
    }
    public static void halfer(int[] btoc, int left, int right){
        /* Process -
         */
        if(left < right){
            int mid = (left + right ) / 2;
            halfer(btoc, left, mid);
            halfer(btoc, mid + 1, right);

            sortMerge(btoc, left, mid, right);
        }

// Result -

    }
    public static void sortMerge(int[] btoc, int left, int mid, int right){
        /* Process -
         */
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(btoc, left, L, 0 , n1);
        System.arraycopy(btoc, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){btoc[k++] = L[i++];}
            else{btoc[k++] = R[j++];}
        }
        while(i < n1){btoc[k++] = L[i++];}
        while(j < n2){btoc[k++] = R[j++];}
    }
}


//7. Minimum Absolute Difference

public class Solution {
    public int solve(int[] A) {
                /* Process -
        1. Sort the array
        2. initialise the minimum difference with the Max Value
        3. iterating the array A find the minimum difference
        4. return the minDifference
         */
        Arrays.sort(A);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++){
            int diff = A[i] - A[i - 1];
            if(diff < minDiff){minDiff = diff;}
        }
        return minDiff;
    }
}

//8. Max Chunks to make Sorted

public class Solution {
    public int solve(int[] A) {
                /* Initialization-
        maxChunks = 0 =
        maxSo Far
         */
        int maxChunks = 0;
        int maxSoFar = 0;
        /* Process -
        for(int i = 0 to A.length){
        maxSoFar = Max of maxSoFar or Array A element at index
        if(maxSoFar == at index value){
        it indicates that all elements from index 0 to i can be valid chunks because the maximum value in the range 0 to i matches the length of this range
        increment maxChunk value
        }
        }
         */
        for(int i = 0; i < A.length; i++){
            maxSoFar = Math.max(maxSoFar, A[i]);
            if(maxSoFar == i){maxChunks++;}
        }
        return maxChunks;
    }
}
