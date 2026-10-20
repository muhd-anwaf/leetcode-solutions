class Solution {
    public int tribonacci(int n) {
        if(n<=2) return (n+1)/2;
        int[] arr = new int[3];
        for(int i = 0; i<3 ; i++) arr[i] = (i+1)/2;
        for(int i =3; i<=n; i++){
            int temp = arr[0];
            arr[0]= arr[1];
            arr[1]= arr[2];
            arr[2]= temp+arr[0]+arr[1];
        }
        return arr[2];

    }
}