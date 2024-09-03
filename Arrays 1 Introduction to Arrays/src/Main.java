/*Introduction to Arrays

* 1. Count Factors
* 2. IsPrime
* 3. Find Perfect Number
* 4. Count of Primes
* 5. Good Pair
* 6. Reverse in a Range
* 7. Array Rotation
* 8. Max Min of an Array
* 9. Linear Search
* 10. Time to Equality
* 11. Count of Elements
* 12. Second Largest
* */

// 1. Count Factors

public class Solution{
    public int solve(int N){
        int ans = 0;
        for(int i = 1; i *i <= N; i++){
            if(N % i == 0){
                if(i == N/i){ans++;}
                else{ans+= 2;}
            }
        }
        return ans;
    }
}

//2. IsPrime

public class Solution{
    public int solve(int A){
     if(A <= 1){return 0;}
     for(int i = 2; i * i<= A; i++){
         if(A%i == 0){return 0;}
     }
     return 1;
    }
}

//3. Is Perfect Number

public class Solution{
    public int solve(int N){
        if(N <= 1){return 0;}
        int ans = 1;
        for(int i = 2; i*i <= N; i++){
            if(N % i == 0){
                ans+= i + N/i;
            }
        }
        if(ans == N){return 1;}
        else{return 0;}
    }
}

//4. Count Prime

public class Solution{
 public int solve(int A){
     int count  = 0;
     for(int i = 2; i <= A; i++){
         if(isPrime(i)){count++;}
     }
     return count;
 }
 public boolean isPrime(int N){
     if(N <= 1){return false;}
     for(int i = 2; i*i <= N; i++){
         if(N % i == 0){return false;}
     }
     return true;
 }
}

// 5. Good Pair

public class Solution{
    public int solve(int[] A, int B){
     HashSet<Integer> set = new HashSet<>();
     for(int i = 0; i < A.length; i++){
         if(set.contains(B - A[i])){return 1;}
         set.add(A[i]);
     }
     return 0;
    }
}

//6. Reverse in a Range

public class Solution{
    public int[] solve(int[] A, int B, int C) {
       while(B < C){
           int temp = A[B];
           A[B] = A[C];
           A[C] = temp;
           B++;
           C--;
       }
       return A;
    }
}

//7. Array Rotation

public class Solution{
    public int[] solve(int[] A, int B){
        int N = A.length;
        B = B % N;
        int[] result = new int[N];
        for(int i = 0; i < N; i++){
            int nIndex = (i+B)%N;
            result[nIndex] = A[i];
        }
        return result;
    }
}

// 8. Max Min of an Array

public class Solution {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + max;
    }
}

//9. Linear Search

public class Solution {
    public int solve(int[] A, int B) {
        int count = 0;
        for (int i=0;i<A.length; i++) {

            if (A[i] == B) {
                count++;
            }
        }
        return count;
    }
}

// 10. Time to Equality

public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        int max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        int totalTime = 0;
        for (int i =0; i< A.length; i++) {
            totalTime += max - A[i];
        }
        return totalTime;
    }
}

//11. Count of Elements

public class Solution {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE;
        int count =0;
        for (int i = 0; i < A.length; i++){
            if (A[i]> max){
                max = Math.max(max, A[i]);
            }
        }
        for (int i = 0; i < A.length; i++){
            if (A[i] < max){count++;}
        }
        return count;
    }
}

//12. Second Largest

public class Solution {
    public int solve(int[] A) {
        if (A.length < 2){return -1;}
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int n = A.length;
        for (int i = 0; i < n; i++){
            int num = A[i];
            if (num > largest){
                secondLargest = largest;
                largest = num;
            }
            else if (num> secondLargest && num != largest){secondLargest = num;}

        }
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
}
