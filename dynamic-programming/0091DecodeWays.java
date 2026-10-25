class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = (s.charAt(0)=='0') ? 0 : 1;

        for(int i = 1 ; i< n ; i++){
            int one = s.charAt(i)-'0';
            if(one != 0) dp[i+1] += dp[i];

            int two = Integer.parseInt(s.substring(i-1,i+1));
            if(two>=10 && two<=26) dp[i+1] += dp[i-1];

        }
        return dp[n];

    }
}