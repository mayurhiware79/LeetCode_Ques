import java.util.Arrays;

class Solution {

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long gcdSum(int[] nums) {
        int max = 0;

        // Construct prefixGcd in-place
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            nums[i] = gcd(nums[i], max);
        }

        Arrays.sort(nums);

        long ans = 0;

        // Pair smallest with largest
        int left = 0, right = nums.length - 1;
        while (left < right) {
            ans += gcd(nums[left], nums[right]);
            left++;
            right--;
        }

        return ans;
    }
}