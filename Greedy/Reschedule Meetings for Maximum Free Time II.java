class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int[] intervals = new int[n+1];
        for(int i=0;i<n-1;i++) {
            intervals[i+1] = startTime[i+1] - endTime[i];
        }
        intervals[0] = startTime[0];
        intervals[n] = eventTime - endTime[n-1];

        int[] right = new int[n+1];
        for(int i=n-1;i>=0;i--) right[i] = Math.max(right[i+1],intervals[i+1]);

        int ans = 0, maxLeft = 0;
        for(int i=1;i<=n;i++) { 
            if(maxLeft >= endTime[i-1] - startTime[i-1] ||
               endTime[i-1] - startTime[i-1] <= right[i]) {
                    ans = Math.max(ans, endTime[i-1] - startTime[i-1] 
                    + intervals[i-1] + intervals[i]);
            }
            // System.out.println("i : " + i + "  intervals[i-1] : " + intervals[i-1] + 
            // "  intervals[i] : " + intervals[i]);

            ans = Math.max(ans, intervals[i-1] + intervals[i]);
            maxLeft = Math.max(maxLeft, intervals[i-1]);
        }
        return ans;
    }
}
