// M-I - Recursion

class Solution {
    public char solve(int n, long k, int[] ops) {
        if(n == 1 && k == 1) {
            return 'a';
        }

        long mid =  1L << (n - 2);
        System.out.println("mid : " + mid + "  k : " + k + "  n : " + n);

        if(k <= mid) {
            char prev = solve(n-1, k, ops);
            return prev;
        }
        else {
            char prev = solve(n-1, k-mid, ops);
            if(ops[n-2] == 1) {
                return (prev == 'z') ? 'a' : (char)(prev + 1);
            } else {
                return prev;
            }
        }
    }

    public char kthCharacter(long k, int[] ops) {
        long x = 1;
        int n = 1;
        while(x < k) {
            x = x << 1;
            n++;
        }
        System.out.println("n : " + n + "  k : " + k);

        return solve(n, k, ops);
    }
}
// M-II - Use Array

public class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        long[] lengths = new long[n + 1];
        lengths[0] = 1; // Initial word = "a"

        // Step 1: Compute lengths[i] after each operation
        for (int i = 0; i < n; i++) {
            lengths[i + 1] = lengths[i] * 2;
            // early break if length exceeds k (no need to go further)
            if (lengths[i + 1] >= k) {
                n = i + 1;
                break;
            }
        }

        int shift = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k > lengths[i]) {
                k -= lengths[i];
                if (operations[i] == 1) {
                    shift++;
                }
            }
        }

        // Final character is 'a' shifted `shift` times
        return (char) ((('a' - 'a') + shift) % 26 + 'a');
    }
}
