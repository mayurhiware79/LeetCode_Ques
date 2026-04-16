class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // map value -> indices
        // 1 ->[0,2,4]
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        // processing queries - checks all idxs of - queries[i] for value
        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);

            if (list.size() == 1) {
                res.add(-1);
                continue;
            }

            // Binary search position
            int pos = Collections.binarySearch(list, q);
            int size = list.size();

            // neighbors (circular in list)
            int left = list.get((pos - 1 + size) % size);
            int right = list.get((pos + 1) % size);

            int dist1 = Math.abs(q - left);
            dist1 = Math.min(dist1, n - dist1);

            int dist2 = Math.abs(q - right);
            dist2 = Math.min(dist2, n - dist2);

            res.add(Math.min(dist1, dist2));
        }

        return res;

    }    
}




















//BRUTE-FORCE APPROACH WITH two For Loops My approach

// class Solution {
//     public List<Integer> solveQueries(int[] nums, int[] queries) {
//         int n=nums.length;
//         // int[] result=new int[queries.length];
//         List<Integer> res= new ArrayList<>();

//         for(int i=0; i< queries.length;i++){
//             int idx = queries[i];
//             int minDist=Integer.MAX_VALUE;

//             for(int j=0; j<n; j++){
//                 if(j != idx && nums[j] == nums[idx]){
//                     int diff = Math.abs(j-idx);
//                     int dist = Math.min(diff, n-diff);

//                     minDist = Math.min(dist, minDist);
//                 }
//             }

//             if(minDist == Integer.MAX_VALUE){
//                 res.add(-1);
//             }else {
//                 res.add(minDist);
//             }
//         }
//         return res;
//     }
// }