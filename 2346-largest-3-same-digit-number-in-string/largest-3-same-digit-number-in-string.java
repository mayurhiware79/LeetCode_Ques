class Solution {
    public String largestGoodInteger(String num) {
        int result =-1;
        for(int i=0; i + 2 < num.length(); i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i)==num.charAt(i+2)){
                result = Math.max(result, num.charAt(i)-'0');
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i=0;i<3;i++){
            builder.append((char)(48+ result));
        }
        return result ==-1  ? "" : builder.toString();
    }
}


// BRUTE FORCE
// class Solution {
//     public String largestGoodInteger(String num) {
        
//         for(int d =9; d >= 0; d--){
//             String pattern = ""+d+d+d;
//             if(num.contains(pattern)){
//                 return pattern;
//             }
//         }
//         return "";
//     }
// }