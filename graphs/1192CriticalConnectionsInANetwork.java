class Solution {
    private int timer = 0;
    private int[] tin ;
    private int[] low ;
    private List<List<Integer>> adjList = new ArrayList<>();
    private boolean[] visited;
    private List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //trojans bridge algorithm
        tin = new int[n];
        low = new int[n];

        for(int i = 0 ; i < n  ; i++) adjList.add(new ArrayList<>());

        for(List<Integer> connection : connections){
            int c1 = connection.get(0);
            int c2 = connection.get(1);
            adjList.get(c1).add(c2);
            adjList.get(c2).add(c1);
        }

        visited = new boolean[n];

        result = new ArrayList<>();
        dfs(0,-1);
        return result;





    }
    private void dfs(int node, int parent ){

        visited[node]=true;

        tin[node] = low[node] = timer++;

        for(Integer nei : adjList.get(node)){

            if(nei==parent) continue;

            if(visited[nei]) low[node] = Math.min(low[nei],low[node]); //code

            else{
                dfs(nei , node );

                low[node] = Math.min(low[nei],low[node]);

                if(low[nei]> tin[node]) result.add(List.of(node,nei));

            }
        }


    }
}