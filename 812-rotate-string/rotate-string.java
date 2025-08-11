class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        return (s + s).contains(goal);
    }
}


// Time complexity: O(n) because buid-in Boyer–Moore–Horspool algorithm or simmilar
// [1] [2] [3] [4] [5]

// Space complexity: O(n)