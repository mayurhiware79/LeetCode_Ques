class Solution {
    public int myAtoi(String s) {
        //storing string into char arr c
        char[] c = s.toCharArray();
        int i=0;
       

        // skipping whitespaces
        while(i < c.length && c[i] == ' ' ){
            ++i;
        }

        int sign = 1;

        // if(c[i] == '+'){
        //     ++i;
        // }else if(c[i] == '-'){
        //     sign = -1;
        //     ++i;
        // }

        if(i == c.length) return 0;

        // using ascii values of '+'43 & '-'45
        if(c[i] == '+' || c[i] == '-'){
            sign = 44 - c[i];
            ++i;
        }

        //skipping leading zeros
        while(i < c.length && c[i] == '0') ++i;

        //read number from char[] 
        long num=0;
        while(i < c.length && c[i] >= '0' && c[i] <= '9'){
            num = num * 10 + ( c[i] - '0');

            if(num * sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(num * sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }   
            ++i;
        }

        

        return (int)(num * sign);
    }
}