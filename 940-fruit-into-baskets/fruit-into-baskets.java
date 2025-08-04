class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left=0,max=0;

        for(int right =0;right < fruits.length; right++){
            //add curr fruit to map
            map.put(fruits[right],map.getOrDefault(fruits[right],0) +1);

            //if there are more than 2 types , shrink window
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            //update max fruits
            max = Math.max(max, right-left+1);

        }
        return max;
    }
}