class Solution {
    private List<List<Integer>> result  = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,0,1);
        return result;
    }
    private void dfs(int k , int n, int sum, int ind){
        if(sum==n && path.size()==k){
            result.add(new ArrayList<>(path));
            return;
        }
        if(sum>n || path.size()>=k) return;

        for( int i = ind; i<=9; i++){
            path.add(i);
            dfs(k,n,sum+i,i+1);

            path.remove(path.size()-1);
            if(sum+i>n) break;
        }
    }
}