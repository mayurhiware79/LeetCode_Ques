class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because problem uses 1-based indexing
                return new int[]{left + 1, right + 1};
            } 
            else if (sum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        // Problem guarantees exactly one solution
        return new int[]{-1, -1};
    }
}