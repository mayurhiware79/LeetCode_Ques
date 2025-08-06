class Solution {
    public int[] shortestToChar(String s, char c) {
        // we will use two lists
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> sol = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c ) {
                indexes.add(i);
            }
        }

        for(int i=0; i< s.length(); i++){
            int min_dist = Integer.MAX_VALUE;
            for(int j : indexes){
                min_dist = Math.min(min_dist, Math.abs(j - i));
            }
            sol.add(min_dist);
        }

        int result[] = new int[s.length()];
        int j =0;
        for(int i : sol){
            result[j] = i;
            j++; 
        }
        return result;
    }
}

// APPROACH 2 : JUST USING SINGLE ARRAY - first check Left-right nearest dist and then right-left dist 

// class Solution {
//     public int[] shortestToChar(String s, char c) {
//         int[] res = new int[s.length()];
//         int n = s.length();
//         int k = Integer.MIN_VALUE/2;

//         for(int i=0; i<n; i++){
//             if(s.charAt(i) == c){
//                 k = i;
//             }
//             res[i] = i-k;
//         }

//         k = Integer.MAX_VALUE/2;
//         for(int i=n-1; i>=0; i--){
//             if(s.charAt(i) == c){
//                 k = i;
//             }
//             res[i] = Math.min(res[i], k-i);
//         }

//         return res;
//     }
// }