class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return new ArrayList<>(List.of(0));
        List<Integer> result = new ArrayList<>();
        int count = n;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0 ; i<n ;i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            adjList.get(n1).add(n2);
            adjList.get(n2).add(n1);
        }
        Queue<Integer> leaves = new LinkedList<>();
        Map<Integer,Integer> countN = new HashMap<>();
        for(int i =0 ; i<n ; i++){
            int length = adjList.get(i).size();
            if(length==1) leaves.offer(i);
            countN.put(i,length);
        }
        int layer = leaves.size();
        while(!leaves.isEmpty()){
            if(count<=2){
                result = new ArrayList<>(leaves);

            }

            for(int i = 0 ; i<layer; i++){
                int node = leaves.poll();
                count--;
                for(int nei : adjList.get(node)){
                    countN.put(nei,countN.get(nei)-1);
                    if(countN.get(nei)==1) leaves.add(nei);
                }


            }
            layer = leaves.size();

        }
        return result;

    }
}