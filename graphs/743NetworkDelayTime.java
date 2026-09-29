class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //adj list
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++) adjList.add(new ArrayList<>());
        for( int [] arr : times){
            int source = arr[0] , target = arr[1] , wieght = arr[2];
            adjList.get(source).add(new int[]{target,wieght});
        }

        //min heap for short path
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        q.offer(new int[]{0,k});

        //set for tracking visited
        boolean[] visited = new boolean[n+1];
        visited[0]=true;
        //tracking minimum time
        int t = 0;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int path = arr[0] , node = arr[1];


            if(visited[node]) continue;
            else visited[node]=true;
            t = Math.max(path,t);

            for(int[] arr1 : adjList.get(node)){
                int node1 = arr1[0] , path1 = arr1[1];

                if(!visited[node1]){
                    q.offer(new int[]{path+path1,node1});
                }
            }
        }
        for(int i = 1 ; i<=n ; i++) if(!visited[i]) return -1;
        return t;

    }
}