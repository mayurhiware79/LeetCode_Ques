class Solution {
    public int maxProduct(int n) {
        int largest = 0;
        int secLarge = 0;
        // if(n<=0)return 0;

        while(n > 0){
            int lastDigit = n % 10;
            if(lastDigit > largest){
                secLarge=largest;
                largest=lastDigit;
            }else if(lastDigit > secLarge){
                secLarge=lastDigit;
            }
            n = n / 10;
        }

        return largest*secLarge;
        
    }
}