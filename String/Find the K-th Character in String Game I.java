class Solution {
    public char solve(int n, int k) {
        if(n == 1 && k == 1) {
            return 'a';
        }

        int mid =  1 << (n - 2);
        System.out.println("mid : " + mid);

        if(k <= mid) {
            char prev = solve(n-1, k);
            return prev;
        }
        else {
            char prev = solve(n-1, k-mid);
            return (prev == 'z') ? 'a' : (char)(prev + 1);
        }
    }

    public char kthCharacter(int k) {
        int x = 1;
        int n = 1;
        while(x < k) {
            x = x << 1;
            n++;
        }
        System.out.println("n : " + n + "  k : " + k);

        return solve(n, k);
    }
}
