//Brute Force Approach TC: O(n * 2^n)
// we will generate the all keys and store in hashset
// check iteratively in nums array if(!containsKey) return nums[i]

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        // store all existing strings
        HashSet<String> set = new HashSet<>();
        for (String s : nums) {
            set.add(s);
        }

        // generate all possible binary strings n? --> 2^n
        for (int i = 0; i < (1 << n); i++) {
            String binary = Integer.toBinaryString(i);

            // pad with leading zeros
            while (binary.length() < n) {
                binary = "0" + binary;
            }

            if (!set.contains(binary)) {
                return binary;
            }
        }

        return "";
    }
}