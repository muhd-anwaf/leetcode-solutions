class Solution {
    public boolean canPartition(int[] nums) {
        //finding the sum
        int sum = 0;
        for(int num : nums) sum+=num;

        //if sum is odd
        if(sum%2 ==1) return false;

        //if sum is even
        int target = sum/2;

        //bottom up memmoization of sum using set
        Set<Integer> setSum = new HashSet<>();
        setSum.add(0);
        Iterator<Integer> it;
        Set<Integer> setTemp = new HashSet<>();

        for(int num : nums){

            it = setSum.iterator();
            while(it.hasNext()){
                int n = it.next();

                int nSum = n+num;
                if(nSum==target) return true;
                if(nSum<target) setTemp.add(n+num);
            }
            setSum.addAll(setTemp);
            setTemp.clear();

        }
        return false;



    }
}