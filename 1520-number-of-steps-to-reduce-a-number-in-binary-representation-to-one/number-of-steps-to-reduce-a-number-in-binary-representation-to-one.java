class Solution {
    public int numSteps(String s){

        int steps=0;
        int carry=0;

        //traverse from right to left (ignore MSB at index 0)
        for(int i=s.length()-1;i > 0;i--){
            int bit = s.charAt(i)-'0';

            if(bit + carry == 1){
                // Odd -> add 1 (steps++)
                //then divide by 2 (steps++)
                steps +=2;
                carry = 1;
            }else{
                //even -> just divide by 2 (remove last bit)
                steps += 1;
            }
        }
        // If carry remains at MSB
        return steps+carry;
    }
}


// RUN-TIME ERROR

// class Solution {
//     public int numSteps(String s) {
//         int num=Integer.parseInt(s,2);
//         int count=0;
//         while(num > 1){
//             if(num % 2 == 0){ // if even then divide by 2
//                 num = num / 2;
//                 count++;
//             }else {
//                 num += 1;
//                 count++;
//             }
//         }
//         return count;
//     }
// }

