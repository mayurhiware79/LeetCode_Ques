class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] nums=new Integer[arr.length];

        //Convert int[] primitive type to Integer[]
        for(int i=0;i< arr.length;i++){
            nums[i]=arr[i];
        }

        //using custom Array.sort(nums, condition arrow func)
        Arrays.sort(nums, (a, b)->{
            int aCount = Integer.bitCount(a);
            int bCount = Integer.bitCount(b);

            if(aCount == bCount){ //we will compare no.
                return Integer.compare(a,b); //or return a- b;
            }
            return Integer.compare(aCount, bCount);
        });

        for(int i=0; i<arr.length;i++){
            arr[i]=nums[i];
        }

        return arr;
    }
}