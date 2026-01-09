class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        int n = columnNumber;
        while(n>0){
            n--;
            result.append((char) ('A'+ n %26));
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }
}