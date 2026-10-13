class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0,subset,nums,set);
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> res : set) result.add(res);
        return result;


    }
    private void dfs(int index , List<Integer> subset, int[] nums, Set<List<Integer>> set){
        set.add(new ArrayList<>(subset));
        if(index>=nums.length) return;


        subset.add(nums[index]);
        dfs(index+1,subset,nums,set);
        subset.remove(subset.size()-1);
        dfs(index+1,subset,nums,set);

    }
}