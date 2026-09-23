class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        Set<Integer> cycle = new HashSet<>();
        Set<Integer> safeNodeSet = new HashSet<>();

        for(int i =0; i<graph.length; i++){
            if(dfs(i,graph,cycle,safeNodeSet)){
                safeNodes.add(i) ;
                safeNodeSet.add(i);
            }
        }
        return safeNodes;

    }
    private boolean dfs (int node , int[][] graph ,Set<Integer> cycle,Set<Integer> safeNodeSet){
        if(cycle.contains(node) ) return false;
        if(safeNodeSet.contains(node)) return true;
        cycle.add(node);

        for(int adjNode : graph[node]){
            if(!dfs(adjNode,graph,cycle,safeNodeSet)){
                cycle.remove(adjNode);
                return false;
            }
        }
        cycle.remove(node);
        safeNodeSet.add(node);
        return true;


    }
}