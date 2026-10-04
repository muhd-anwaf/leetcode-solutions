class Solution {
    private class DisjointSet {
        private int[] parent;
        private DisjointSet(int size){
            parent = new int[size];
            for(int i = 0; i<size ; i++) parent [i] = i;
        }
        private int find(int i ){
            if(parent[i]==i) return i;
            return parent[i] = find(parent[i]);
        }
        private void union(int i , int j){
            int irep = find(i);
            int jrep = find(j);
            parent[irep] = jrep;
        }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet dsu = new DisjointSet(n);

        TreeMap<String,Integer> treeMap = new TreeMap<>();

        for(int i = 0 ; i<n; i++){

            List<String> account = accounts.get(i);
            int m = account.size();

            for(int j = 1; j<m ; j++){

                String mail = account.get(j);
                if(!treeMap.containsKey(mail)) treeMap.put(mail , i);
                else {
                    int value = treeMap.get(mail);
                    dsu.union(i,value);
                }

            }
        }
        Map<Integer,List<String>> map = new HashMap<>();

        for(Map.Entry<String,Integer> entry : treeMap.entrySet()){

            int key = dsu.find(entry.getValue());
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
                map.get(key).add(accounts.get(key).get(0));
            }
            map.get(key).add(entry.getKey());


        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> value : map.values()){
            result.add(value);
        }
        return result;

    }

}
