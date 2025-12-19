class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        //base profit
        long baseProfit =0;
        for(int i=0;i<n;i++){
              baseProfit +=(long) strategy[i]*prices[i];
        }

        //prefix sum
        long[] prefixSP = new long[n+1]; // strategy[i]*prices[i]
        long[] prefixP = new long[n+1]; // prices[i]

        for(int i =0;i< n;i++){
            prefixSP[i+1]= prefixSP[i]+(long) strategy[i]*prices[i];
            prefixP[i+1] = prefixP[i]+prices[i];
            
        }

        //sliding window
        long maxGain = Long.MIN_VALUE;
        for(int i=0; i+k <= n; i++){
            long oldSum = prefixSP[i+k]-prefixSP[i];
            long newSum = prefixP[i+k]-prefixP[i+k/2]; //last k/2 prices
            long gain = newSum - oldSum;
            maxGain = Math.max(maxGain, gain);
        }
        return baseProfit + Math.max(0, maxGain);
    }
}