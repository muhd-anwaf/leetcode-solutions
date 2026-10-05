class Solution {
    private class DisjointSet {
        int[] parent;
        int[] size;

        DisjointSet (int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i<n; i++){
                size[i] = 1;
                parent[i] = i;
            }

        }

        int find(int i ){
            if(parent[i]==i) return i;


            return parent[i] = find(parent[i]);
        }

        void union( int a , int b ){
            a = find(a);
            b = find(b);
            if(a==b) return;
            if(size[a] > size[b]){
                int temp = a;
                a =b ;
                b =temp;
            }
            parent[a] = b;
            size[b]+=size[a];
        }

    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet dsu = new DisjointSet(n);
        int red = 0;
        boolean[] connected = new boolean[n];
        for(int[] connection : connections){
            int c1 = connection[0] , c2 = connection[1];
            connected[c1]=true;
            connected[c2]=true;

            if(dsu.find(c1)!= dsu.find(c2) )dsu.union(c1,c2);
            else red++;
        }

        int components = 0;
        for(int i = 0 ; i<n ; i++){
            if(dsu.parent[i]==i) components++;
        }

        if(red >= components - 1)
            return components - 1;

        return -1;



    }
}
