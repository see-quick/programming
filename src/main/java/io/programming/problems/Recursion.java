package io.programming.problems;

public class Recursion {

    /**
     * Recursive method getReverseString, print input string in a reverse order. Using classic top-down recursive technique.
     *
     * <h4>Complexity analysis:</h4>
     *   As you can see, the function would be recursively invoked n times, where n is the size of the input string.
     *   At the end of each recursion, we simply print the leading character, therefore the time complexity of
     *   this particular operation is constant, i.e. {\mathcal{O}(1)}. O(getReverseString) =n * O(1) = O(n).
     *   This algorithm has O(n) time complexity (linear).
     *
     * @param inputString string, which gonna be printed in a reverse order
     */
    public static String getReverseString(String inputString) {
        // stop point of the recursive algorithm
        if (inputString.length() == 0) {
            return "";
        }

        return inputString.charAt(inputString.length() - 1) + getReverseString(inputString.substring(0, inputString.length() - 1));
    }

    /**
     * Classic Fibonacci (without Memoization/Caching...) - Head recursive algorithm
     *
     * <h4>Complexity analysis:</h4>
     *  Time complexity of this particular algorithm is O(2^n), which is exponential. It's because in the execution
     *  tree of this recursive function it will form a n-nary tree with n as a number of times recursion appears in the
     *  recurrence relation.
     *
     *  i.e. for the n = 5 is result 8 because 3 + 5 is 8 (1 1 2 3 5 8 13)
     *
     * @param n input number
     * @return specific number of fib sequence
     */
    public static int fibonacci(int n) {
        // indexed from 0
        if (n <= 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Tail-recursive algorithm because the <b>recursive call is the last thing executed by the method</b> itself.
     *
     * @param n from which number we want to start printing n, n-1, ... etc.
     */
    public static void printIntegers(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printIntegers(n - 1);
    }

    /**
     * Head-recursive algorithm because the recursive call is not the last thing executed by the method
     *
     * @param n input number to be computed
     * @return value of n!
     */
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    /**
     * Tail-recursive algorithm compared to the head-recursive {@link #fact(int)}. It needs helper method for its
     * execution {@link #helperFact(int, int)}. Benefits of this type of algorithm is that we usually reduce space-complexity
     * and in that case we reduce it from O(n) to O(1).
     *
     * @param n input number
     * @return value of n!
     */
    public static int tailFact(int n) {
        return helperFact(n, 1);
    }

    /**
     *
     * @param n input number
     * @param a accumulator
     * @return value of n!
     */
    public static int helperFact(int n, int a) {
        if (n <= 1) {
            return a;
        }
        return helperFact(n - 1, n * a);
    }

    public static void main(String[] args) {
        System.out.println(getReverseString("hello"));
        System.out.println(fibonacci(5));
        printIntegers(5);
        System.out.println(tailFact(5));
    }

}
