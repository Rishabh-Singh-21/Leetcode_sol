class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minLandFinish = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLandFinish = Math.min(minLandFinish,landStartTime[i] + landDuration[i]);
        }
        int minWaterFinish = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minWaterFinish = Math.min(minWaterFinish,waterStartTime[j] + waterDuration[j]);
        }
        long ans = Long.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            long finish =Math.max(minLandFinish, waterStartTime[j])+ waterDuration[j];
            ans = Math.min(ans, finish);
        }
        for (int i = 0; i < n; i++) {
            long finish =Math.max(minWaterFinish, landStartTime[i])+ landDuration[i];
            ans = Math.min(ans, finish);
        }
        return (int) ans;
    }
}