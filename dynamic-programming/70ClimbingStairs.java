class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] arr = new int[3];
        arr[0]=1;
        arr[1]=2;
        for(int i = 2; i<n; i++){
            arr[2] = arr[1]+arr[0];

            arr[0]= arr[1];
            arr[1]=arr[2];
        }
        return arr[2];

    }
}