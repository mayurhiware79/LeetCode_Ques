class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long MOD = 1_000_000_007;

        //adding boundaries
        int[] h = new int[hFences.length+2];
        int[] v = new int[vFences.length+2];

        h[0] = 1;
        v[0] = 1;
        h[h.length-1] = m;
        v[v.length-1] = n;

        for(int i=0; i< hFences.length; i++){
            h[i+1] = hFences[i];
        }
        for(int i=0; i< vFences.length; i++){
            v[i+1] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        //store all vertical distances(heights)
        HashSet<Integer> heights = new HashSet<>();
        for(int i=0; i< h.length; i++){
            int sum=0;
            for(int j=i+1; j< h.length; j++){
                sum = h[j]-h[i];
                heights.add(sum);
            }
        }

        // Find max common width
        long ans = -1;
        for (int i = 0; i < v.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < v.length; j++) {
                sum = v[j] - v[i];
                if (heights.contains(sum)) {
                    ans = Math.max(ans, (long) sum * sum);
                }
            }
        }

        if (ans == -1) return -1;
        return (int) (ans % MOD);


    }
}