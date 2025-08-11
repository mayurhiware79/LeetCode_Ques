class Solution {
    int MOD = (int)(1e9 + 7);
    public int[] productQueries(int n, int[][] queries) {
        // most imp part for this problem is to create power array
        // power array is made BY FOLLOW STEPS
        // convert n into binary repres check 32 bits with != 0 then add into power array(2^0,2^1,...)
        List<Long> powers = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i < 31; i++){
            if((n & (1 << i)) != 0 ){
                // powers.add((long) (1 << i));
                powers.add((long)Math.pow(2,i));
            }
        }

        // then it is very easy to return product of indices in powers array based on query
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];

            long product = 1;
            for(int i = start ; i <= end ; i++){
                product = (product * powers.get(i)) % MOD;
            }

            ans.add((int)product);
        }

        // converting ans AL to int array
        return ans.stream().mapToInt(i -> i).toArray();
    }
}