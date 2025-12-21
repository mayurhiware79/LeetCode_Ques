class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int deletions = 0;
        //sorted[i] means strs[i] < strs[i+1] already confirmed
        boolean[] sorted = new boolean[n-1];
        
        for(int col=0; col < m; col++){
            boolean badCol = false;

            //check if this column violates order
            for(int i=0; i< n-1; i++){
                if(!sorted[i]){
                    char a = strs[i].charAt(col);
                    char b = strs[i+1].charAt(col);
                    if(a > b){
                        badCol = true;
                        break;
                    }
                }
            }

            if(badCol){
                deletions++;
                continue;
            }

            //otherwise, update sorted pairs
            for(int i=0; i< n-1; i++){
                if(!sorted[i]){
                    char a = strs[i].charAt(col);
                    char b = strs[i+1].charAt(col);
                    if(a < b){
                        sorted[i] = true;
                    }
                }
            }
        }

        return deletions;
    }
}