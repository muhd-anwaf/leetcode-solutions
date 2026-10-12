class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,result,curr,visited);
        return result;

    }
    private void dfs( int[] nums,List<List<Integer>> result, List<Integer> curr , boolean[] visited){
        if(curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i =0; i<nums.length;i ++){
            if(visited[i]) continue;
            else{
                visited[i]=true;
                curr.add(nums[i]);
                dfs(nums,result,curr,visited);
                visited[i]=false;
                curr.remove(curr.size()-1);
            }
        }

    }
}