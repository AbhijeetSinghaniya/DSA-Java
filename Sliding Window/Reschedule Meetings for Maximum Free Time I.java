class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        int[] intervals = new int[n+1];

        for(int i=0;i<n-1;i++) {
            intervals[i+1] = startTime[i+1] - endTime[i];
        }
        intervals[0] = startTime[0];
        intervals[n] = eventTime - endTime[n-1];

        int winSize = k + 1;
        
        int st = 0, end = 0, ans = 0, curr = 0;
        while(end <= n) {
            // System.out.println("curr : " + curr);
            if(end - st + 1 <= winSize) {
                curr += intervals[end++];
                ans = Math.max(ans, curr);
                continue;
            }
            curr -= intervals[st++];
            curr += intervals[end++];

            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
