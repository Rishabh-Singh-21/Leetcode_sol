class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        long lo = 0, hi = 0;
        for (int x : nums) hi = Math.max(hi, x);

        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2;
            if (countGe(nums, mid) >= k) lo = mid;
            else hi = mid - 1;
        }

        long T = lo;
        long[] cs = countAndSumGe(nums, T + 1);
        return cs[1] + (k - cs[0]) * T;
    }

    private long countGe(int[] a, long thr) {
        int n = a.length;
        long cnt = 0;
        int[] maxDq = new int[n], minDq = new int[n];
        int mxH = 0, mxT = 0, mnH = 0, mnT = 0, l = 0;

        for (int r = 0; r < n; r++) {
            while (mxH < mxT && a[maxDq[mxT - 1]] <= a[r]) mxT--;
            maxDq[mxT++] = r;

            while (mnH < mnT && a[minDq[mnT - 1]] >= a[r]) mnT--;
            minDq[mnT++] = r;

            while (l < r) {
                int nxMx = (maxDq[mxH] == l)
                        ? (mxH + 1 < mxT ? a[maxDq[mxH + 1]] : a[r])
                        : a[maxDq[mxH]];

                int nxMn = (minDq[mnH] == l)
                        ? (mnH + 1 < mnT ? a[minDq[mnH + 1]] : a[r])
                        : a[minDq[mnH]];

                if ((long) (nxMx - nxMn) >= thr) {
                    if (maxDq[mxH] == l) mxH++;
                    if (minDq[mnH] == l) mnH++;
                    l++;
                } else {
                    break;
                }
            }

            if ((long) (a[maxDq[mxH]] - a[minDq[mnH]]) >= thr) {
                cnt += (l + 1);
            }
        }

        return cnt;
    }

    private long[] countAndSumGe(int[] a, long thr) {
        int n = a.length;

        long[] mxV = new long[n + 1], mxC = new long[n + 1];
        int mxSz = 0;

        long[] mnV = new long[n + 1], mnC = new long[n + 1];
        int mnSz = 0;

        long sumMxAll = 0, sumMnAll = 0;

        int[] maxDq = new int[n], minDq = new int[n];
        int mxH = 0, mxT = 0, mnH = 0, mnT = 0, l = 0;

        long totalCnt = 0, totalSum = 0;

        for (int r = 0; r < n; r++) {

            long addMx = 1;
            while (mxSz > 0 && mxV[mxSz - 1] <= a[r]) {
                sumMxAll -= mxV[mxSz - 1] * mxC[mxSz - 1];
                addMx += mxC[mxSz - 1];
                mxSz--;
            }

            mxV[mxSz] = a[r];
            mxC[mxSz] = addMx;
            mxSz++;

            sumMxAll += (long) a[r] * addMx;

            long addMn = 1;
            while (mnSz > 0 && mnV[mnSz - 1] >= a[r]) {
                sumMnAll -= mnV[mnSz - 1] * mnC[mnSz - 1];
                addMn += mnC[mnSz - 1];
                mnSz--;
            }

            mnV[mnSz] = a[r];
            mnC[mnSz] = addMn;
            mnSz++;

            sumMnAll += (long) a[r] * addMn;

            while (mxH < mxT && a[maxDq[mxT - 1]] <= a[r]) mxT--;
            maxDq[mxT++] = r;

            while (mnH < mnT && a[minDq[mnT - 1]] >= a[r]) mnT--;
            minDq[mnT++] = r;

            while (l < r) {
                int nxMx = (maxDq[mxH] == l)
                        ? (mxH + 1 < mxT ? a[maxDq[mxH + 1]] : a[r])
                        : a[maxDq[mxH]];

                int nxMn = (minDq[mnH] == l)
                        ? (mnH + 1 < mnT ? a[minDq[mnH + 1]] : a[r])
                        : a[minDq[mnH]];

                if ((long) (nxMx - nxMn) >= thr) {
                    if (maxDq[mxH] == l) mxH++;
                    if (minDq[mnH] == l) mnH++;
                    l++;
                } else {
                    break;
                }
            }

            int B = -1;

            if ((long) (a[maxDq[mxH]] - a[minDq[mnH]]) >= thr) {
                B = l;
            }

            if (B < 0) continue;

            totalCnt += (B + 1);

            long tailMx = 0;
            long tailMn = 0;

            long tailSize = r - B;

            long rem = tailSize;

            for (int i = mxSz - 1; i >= 0 && rem > 0; i--) {
                long take = Math.min(rem, mxC[i]);
                tailMx += mxV[i] * take;
                rem -= take;
            }

            rem = tailSize;

            for (int i = mnSz - 1; i >= 0 && rem > 0; i--) {
                long take = Math.min(rem, mnC[i]);
                tailMn += mnV[i] * take;
                rem -= take;
            }

            long sumMxB = sumMxAll - tailMx;
            long sumMnB = sumMnAll - tailMn;

            totalSum += sumMxB - sumMnB;
        }

        return new long[]{totalCnt, totalSum};
    }
}