class Solution {
    public int minFlips(String s) {
        int n=s.length();
        s = s + s;

        // s1 =01010101
        // s2 =10101010
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        // s+s karan to use type-1 --> max we can use 5 time
        for(int i=0;i< 2*n;i++){
            if(i%2 == 0){
                s1.append('0');
                s2.append('1');
            }else{
                s1.append('1');
                s2.append('0');
            }
        }

        int flip1 = 0;
        int flip2 = 0;
        int result= Integer.MAX_VALUE;
        int i=0,j=0;

        //kandani sliding window approach
        while( j < 2*n){
            if(s.charAt(j) != s1.charAt(j)){
                flip1++;
            }

            if(s.charAt(j) != s2.charAt(j)){
                flip2++;
            }

            if(j-i+1 > n){ // shrink the window from left
                if(s.charAt(i) != s1.charAt(i)){
                    flip1--;
                }
                if(s.charAt(i) != s2.charAt(i)){
                    flip2--;
                }
                i++;
            }

            if(j-i+1 == n){
                result= Math.min(result, Math.min(flip1, flip2));
            }

            j++;  
        }

        return result;
    }
}