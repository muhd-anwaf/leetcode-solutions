class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int max = 0;
        int [] diff = new int[n];
        for(int i = 0 ; i<n; i++){
            diff[i]= Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max,diff[i]);
        }

        long[] count = new long[max + 1];
        for (int d : diff) count[d]++;

        long k = (long) k1 + k2;

        for (int d = max; d >= 1 && k > 0; d--) {
            if (count[d] == 0) continue;
            if (k >= count[d]) {
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                count[d] -= k;
                count[d - 1] += k;
                k = 0;
            }
        }

        long result = 0;
        for (int d = 1; d <= max; d++) {
            result += count[d] * (long) d * d;
        }
        return result;
    }
}


