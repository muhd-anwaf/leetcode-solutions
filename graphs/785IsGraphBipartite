class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] odd = new int[n];

        for(int i = 0 ; i<n ; i++){
            if(odd[i]==0){
                if(!bfs(graph,odd,i)) return false;
            }
        }
        return true;

    }
    private boolean bfs(int[][] graph ,int[] odd, int node ){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        odd[node]=-1;
        while(!q.isEmpty()){
            int n = q.poll();

            for(int n2 :graph[n]){
                if(odd[n2]==0){
                    q.offer(n2);
                    odd[n2] = -1 * odd[n];
                    continue;
                }
                if(odd[n2]!=odd[n]*-1) return false;


            }
        }
        return true;
    }
}