class Solution {
    public int longestCycle(int[] edges) {

        int result =-1;
        int n = edges.length;

        int[] visitedStep = new int[n];
        int currentTime = 1;

        for(int i = 0; i<n ; i++){
            if(visitedStep[i]!=0) continue;
            int node = i;
            int start = currentTime;
            while(node!=-1){
                if(visitedStep[node]!=0){
                    if(visitedStep[node] >= start){
                        result = Math.max(result,currentTime-visitedStep[node]);
                    }
                    break;

                }
                visitedStep[node]=currentTime++;
                node=edges[node];
            }
        }
        return result;

    }
}