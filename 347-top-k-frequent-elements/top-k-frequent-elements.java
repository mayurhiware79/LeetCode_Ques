// this version will fail because array indices can’t be negative.

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         //finding max elem to size freq array
//         int max=0;
//         for(int num : nums){
//             if(num > max) max = num;
//         }

//         int[] freq = new int[max+1];
//         for(int num : nums){
//             freq[num]++; //count freq
//         }

//         //I will collect the k elem with highest freq
//         int ans[] = new int[k];
//         for(int i=0; i<k ; i++){
//             int maxFreq = 0;
//             int idx = -1;
//             for(int j=0; j < freq.length; j++){
//                 if(freq[j] > maxFreq){
//                     maxFreq = freq[j];
//                     idx = j;
//                 }
//             }
//             ans[i] = idx;
//             freq[idx] = 0; // So we don’t pick it again

//         }

//         return ans;
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n,0) + 1);
        }

        //min-heap based on freq
        PriorityQueue<Map.Entry<Integer, Integer>> heap = 
            new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            heap.add(entry);
            if(heap.size() > k) heap.poll();
        } 

        int res[] = new int[k];
        for(int i=k-1; i>= 0; i--){
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}



