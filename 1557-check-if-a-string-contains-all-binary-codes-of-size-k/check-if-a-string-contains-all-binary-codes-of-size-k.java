class Solution {
    public boolean hasAllCodes(String s, int k) {
        // 140 TestCase / 201 passed
        // return s.length() != Math.pow(2,k);

        Set<String> set=new HashSet<>();

        //collect all unique substrings of k size
        for(int i=0; i<= s.length()-k ;i++){
            set.add(s.substring(i,i+k));
        }

        return set.size() == Math.pow(2,k);
    }
}