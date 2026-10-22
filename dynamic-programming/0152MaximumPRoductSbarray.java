class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr1 = 1;
        int curr2 = 1;

        for (int i = 0; i < nums.length; i++) {
            if (curr1 == 0) curr1 = 1;
            if (curr2 == 0) curr2 = 1;

            curr1 *= nums[i];
            curr2 *= nums[nums.length - 1 - i];

            max = Math.max(max, Math.max(curr1, curr2));
        }

        return max;
    }
}
