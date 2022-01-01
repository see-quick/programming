package io.programming.problems;

import java.util.Arrays;

/**
 * One of the technique of Dynamic Programming.
 *
 * The <b>rod-cutting problem</b> is the following. Given a rod of length n inches and a table of prices pi for i D 1; 2; : : : ; n,
 * determine the maximum revenue rn obtain- able by cutting up the rod and selling the pieces. Note that if the price pn
 * for a rod of length n is large enough, an optimal solution may require no cutting at all.
 * Consider the case when n D 4. Figure 15.2 shows all the ways to cut up a rod of 4 inches in length,
 * including the way with no cuts at all. We see that cutting a 4-inch rod into two 2-inch pieces produces revenue
 * p2 C p2 D 5 C 5 D 10, which is optimal.
 *
 * Note: Variation of the Unbounded Knapsack problem (you can make a reduction and translate this problem...)
 *
 */
public class RodCutting {

    /**
     * Top-down implementation (without using any memoization or bottom-up recursion, which could eliminate and
     * improve performance of the algorithm)
     *
     * Time complexity of such algorithm is O(nⁿ) where n is the rod size, which is exponential. That's why we often
     * use extra space for reduction time-complexity.
     */
    public static int rodCut(int[] price, int n) {
        if (n == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            // Rod of length `i` has a cost `price[i-1]`
            int cost = price[i - 1] + rodCut(price, n - i);
            if (cost > max) {
                max = cost;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] table = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        System.out.println(Arrays.toString(table));

        // f.e. for length 2 there is the best result number `5`, because you have following options:
        //  1. 1 1  -> 2
        //  2. 2    -> 5   <--- here is the winner
        System.out.println(rodCut(table, 2));

        // f.e. for length 4 is more complex there is the best result number `5`, because you have following options:
        //  1. 1 1 1 1  -> 4
        //  2. 2 1 1    -> 7
        //  3. 2 2      -> 10 <--- here is the winner
        //  4. 3 1      -> 9
        //  5. 4        -> 9

        System.out.println(rodCut(table, 4));
    }
}
