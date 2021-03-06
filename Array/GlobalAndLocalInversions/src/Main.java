
/*

https://leetcode.com/problems/global-and-local-inversions/description/

We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

Return true if and only if the number of global inversions is equal to the number of local inversions.

Example 1:

Input: A = [1,0,2]
Output: true
Explanation: There is 1 global inversion, and 1 local inversion.
Example 2:

Input: A = [1,2,0]
Output: false
Explanation: There are 2 global inversions, and 1 local inversion.
Note:

A will be a permutation of [0, 1, ..., A.length - 1].
A will have length in range [1, 5000].
The time limit for this problem has been reduced.

 */

public class Main {

    public static void main(String[] args) {
        int[] A = {2,0,3,1};
        System.out.println(isIdealPermutation(A));
    }

    // time complexity O(N)
    // local inventions equal to global inventions means that all global inventions is
    // local inventions, because global inventions is superset of local inventions.
    // so that means none A[i + 2(> 2)] > A[i], if has i let A[i + 2(> 2)] > A[i], will
    // cause one global invention is not local invention, so return false.

    public static boolean isIdealPermutation(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length - 2; ++i) {
            max = Math.max(max, A[i]);
            if (max > A[i + 2]) return false;
        }
        return true;
    }
}
