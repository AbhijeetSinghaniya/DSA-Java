class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[1],b[1]));

        int n = events.length;
        int[][] dp = new int[n+1][k+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=k;j++) {
                // fetching right most end time smaller than current start time
                int prev = binarySearch(events, events[i-1][0]);

                dp[i][j] = Math.max(dp[prev+1][j-1] + events[i-1][2], dp[i-1][j]);
            }
        }
        return dp[n][k];
    }

    private int binarySearch(int[][] events, int currentStart) {
        int lo = 0, hi = events.length - 1;
        int res = -1;

        while(lo <= hi) {
            int mid = (hi-lo)/2 + lo;

            if(events[mid][1] < currentStart) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}
