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