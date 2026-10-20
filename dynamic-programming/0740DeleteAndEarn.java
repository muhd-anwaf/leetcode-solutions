class Solution {
    public int deleteAndEarn(int[] nums) {

        //edge case containing 1 or 2 elements
        if(nums.length==1) return nums[0];

        // maximum of the array
        int max = 0;
        for(int num: nums) max = Math.max(max,num);

        // creating a array to memmoization
        int[] numPoints = new int[max+1];
        for(int num: nums) numPoints[num]+=num;

        //bottom up approch of dp
        for(int i =2; i<numPoints.length ; i++){
            numPoints[i] = Math.max(numPoints[i]+numPoints[i-2],numPoints[i-1]);
        }
        return numPoints[numPoints.length-1];
    }
}