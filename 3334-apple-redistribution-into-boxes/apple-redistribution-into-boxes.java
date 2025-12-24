class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        //calc sum of all apples
        int appleSum =0;
        for(int a : apple){
            appleSum += a;
        }

        //sort capacity
        Arrays.sort(capacity);

        int currCapacity = 0;
        int count = 0;

        //loop for(applesum > accumulated capacity from end to start) add count
        for(int i = capacity.length - 1; i >= 0; i--){
            currCapacity += capacity[i];
            count++;
            
            if(currCapacity >= appleSum){
                return count;
                // return count;
            }
        }
        return count;
    }
}