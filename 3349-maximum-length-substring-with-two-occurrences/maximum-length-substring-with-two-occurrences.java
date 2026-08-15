class Solution {
    public int maximumLengthSubstring(String s) {
        //gen all substrings
        //cnt freq of char
        //if no. of 2 freq char max return size of that substring

        int n = s.length();
        int maxLen = 0;

        //gen all substrings
        for(int i=0; i<n;i++){

            int freq[]=new int[26];
            for(int j=i;j<n;j++){

                char ch = s.charAt(j);
                freq[ch - 'a']++;

                if(freq[ch - 'a'] > 2){
                    break;
                }

                maxLen = Math.max(maxLen, j-i+1);
            }
        }

        return maxLen;
    }
}