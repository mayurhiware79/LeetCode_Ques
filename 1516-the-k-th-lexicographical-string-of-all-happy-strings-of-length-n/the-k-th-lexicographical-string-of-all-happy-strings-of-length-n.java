//get all generated possible strings - using recursive Backtracking
//check isHappyStr() ifs[i] != s[i + 1] or charAt(n-1) != c then count++;
// don't store just return if count == k
// return ans

class Solution {

    int count=0;
    String ans="";

    public String getHappyString(int n, int k) {
        
        generate(n,k, new StringBuilder());
        return ans;
    }

    private void generate(int n, int k, StringBuilder sb){
        //base case
        //if length == n, we got valid happy string
        if(sb.length()==n){
            count++;

            if(count == k){ //we found kth string
                ans =sb.toString();
            }
            return;
        }

        //now gen valid strings
        for(char c: new char[]{'a','b','c'}){

            if(sb.length()>0 && sb.charAt(sb.length()-1) == c){
                continue;
            }

            sb.append(c);
            //explore next -recursion
            generate(n,k, sb);

            //backtrack : remove last character
            sb.deleteCharAt(sb.length()-1);

            if(!ans.equals("")){ // jr we already got kth str
                return;
            }
        }

    }
}