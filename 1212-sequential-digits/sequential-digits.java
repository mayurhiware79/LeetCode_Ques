class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        // length of sequential number
        for (int len = 2; len <= 9; len++) {

            // possible starting digit
            for (int start = 1; start <= 10 - len; start++) {

                int num = 0;

                // build the number
                for (int d = start; d < start + len; d++) {
                    num = num * 10 + d;
                }

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}