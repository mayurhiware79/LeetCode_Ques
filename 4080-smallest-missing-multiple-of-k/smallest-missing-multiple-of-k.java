class Solution {

    public int missingMultiple(int[] nums, int k) {
        // my appraoch
        // sort nums array
        Arrays.sort(nums);

        
        // then loop from i=k;i<=100;i+=k
        // for(int i=k;i<=100;i+=k){
        //     if(!binarySearch(nums,i)){
        //         return i;
        //     }
        // }
        int i = k;

        while (true) {
            if (!binarySearch(nums, i)) {
                return i;
            }
            i += k;
        }
    }

    boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}