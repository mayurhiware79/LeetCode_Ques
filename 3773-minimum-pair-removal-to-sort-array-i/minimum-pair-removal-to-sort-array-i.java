class Solution {

    boolean isSorted(List<Integer> list){
        for(int i=1; i< list.size(); i++){
            if(list.get(i) < list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        
        //add nums elem into ArrayList
        List<Integer> list = new ArrayList<>();
        for(int x: nums) list.add(x);
    
        int operations = 0;

        while(!isSorted(list)){
            int minSum = Integer.MAX_VALUE;
            int idx=0;

            //finding leftmost adj pair with min sum
            for(int i=0; i<list.size()-1; i++){
                int sum = list.get(i)+list.get(i+1);
                if(sum < minSum){
                    minSum=sum;
                    idx=i;
                }
            }

            //replacing pair with minSum
            list.remove(idx+1);
            list.set(idx, minSum);

            operations++;
        }
        return operations;
    }
}