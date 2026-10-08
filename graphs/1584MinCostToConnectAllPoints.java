class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[][][] adjList = new int[n][n-1][2];

        for( int i = 0; i<n ; i++){
            int k = 0;
            int[] p1 = points[i];
            for ( int j = 0 ; j <n ; j++){
                if(j==i) continue;
                int[] p2 = points[j];
                int dist = Math.abs(p1[0]-p2[0])+ Math.abs(p1[1]-p2[1]);
                adjList[i][k] = new int[]{j,dist};
                k++;
            }
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        Set<Integer> visitedSet = new HashSet<>();
        minHeap.offer(new int[]{0,0});
        int cost = 0;

        while(!minHeap.isEmpty()){
            int [] node = minHeap.poll();

            int n1 = node[0];
            if(visitedSet.contains(n1)) continue;
            visitedSet.add(n1);
            cost+= node[1];
            for(int i=0 ; i<n-1; i++){
                int[] node2 = adjList[n1][i];
                int n2 = node2[0];
                int d = node2[1];
                if(!visitedSet.contains(n2)){
                    minHeap.offer(new int[]{n2,d});
                }

            }

        }

        return cost;
    }
}