class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);


        //track first n last pos of each char
        for(int i=0; i<n;i++){
            int c= s.charAt(i) - 'a';
            if(first[c] == -1){
                first[c]=i;
            }
            last[c]=i;
        }

        int result = 0;

        // for each char acts as boundaries of palindrome X_X
        for(int c=0;c<26;c++){
            if(first[c] != -1 && first[c] < last[c]){
                //tracking unique chars between l n r
                boolean[] seen = new boolean[26];

                for(int i=first[c]+1; i<last[c]; i++){
                    seen[s.charAt(i)-'a'] = true;
                }

                //count unique mid chars --> result++
                for(boolean x : seen){
                    if(x){
                        result++;
                    }
                }
            }
        }

        return result;
    }
}