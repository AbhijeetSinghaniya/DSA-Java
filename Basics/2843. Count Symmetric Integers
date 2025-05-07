class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        for(int i=low;i<=high;i++) {
            String s = Integer.toString(i);
            int len = s.length();

            if(len % 2 == 0) {
                int sumLeft = 0, sumRight = 0;
                int mid = len / 2;

                for(int j = 0;j < mid;j++) sumLeft += s.charAt(j) - '0';

                for(int j = mid;j < len;j++) sumRight += s.charAt(j) - '0';
                
                ans += (sumLeft == sumRight) ? 1 : 0;
            }
        }
        return ans;
    }
}
