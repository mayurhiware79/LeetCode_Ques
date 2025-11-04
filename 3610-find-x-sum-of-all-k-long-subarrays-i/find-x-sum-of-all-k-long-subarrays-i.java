class Solution {

    private int findTopXSum(Map<Integer, Integer> map, int x){

        //constructing min-heap (using priority queue)
        //freq sort karaychi min to max jr same tr smaller value pahile
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]
        );

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int val = entry.getKey();
            pq.offer(new int[]{freq, val});

            // jar heap chi size x peksha jast zali tar remove smaller val
            if (pq.size() > x) pq.poll();
        }

        // Ata heap madhe top x frequent elements aahet
        // tyanchya freq * value cha sum kadhaycha
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            sum += pair[0] * pair[1];
        }

        return sum;


    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n= nums.length;

        //sliding window sathi ek freq map
        Map<Integer, Integer> map = new HashMap<>();

        //Final ans store karayla list
        List<Integer> result = new ArrayList<>();

        int i =0, j=0; //window ptrs

        //sliding window logic suru
        while(j < n){

            //right side cha element window madhe add karaycha
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            //jr window size k zali tr
            if(j - i + 1 == k){

                //curr window cha x-sum calc karo
                result.add(findTopXSum(map,x));

                //remove left side elem
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0) map.remove(nums[i]); // zero freq asel tr
                i++; // window right la shift
            }

            j++; //right pt pudhe
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}