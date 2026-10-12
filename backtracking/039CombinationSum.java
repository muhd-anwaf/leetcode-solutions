class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();
        dfs(0,0,target,curr,candidates,result);
        return result;




    }
    private void dfs(int index ,  int total, int target , List<Integer> curr,int[] candidates,List<List<Integer>> result){


        if(total==target){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(index>=candidates.length || total > target) return;
        curr.add(candidates[index]);
        dfs(index,total+candidates[index],target,curr,candidates,result);
        curr.remove(curr.size()-1);
        dfs(index+1,total,target,curr,candidates,result);


    }
}