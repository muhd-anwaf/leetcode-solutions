class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] odd = new int[n+1];
        for(int i = 0 ; i<=n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] dislike : dislikes){
            int d1 = dislike[0], d2 = dislike[1];
            graph.get(d1).add(d2);
            graph.get(d2).add(d1);
        }

        for(int i = 1; i<=n; i++){
            if(odd[i]==0){
                if(!bfs(i,graph,odd)) return false;
            }
        }
        return true;



    }
    private boolean bfs(int node ,List<List<Integer>> graph ,int[] odd ){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        odd[node]=-1;
        while(!q.isEmpty()){
            int n = q.poll();

            for(int n2 : graph.get(n)){
                if(odd[n2] == 0){
                    q.offer(n2);
                    odd[n2]=-1*odd[n];
                }
                else {
                    if(odd[n2] != -1 * odd[n]) return false;
                }
            }
        }
        return true;
    }
}