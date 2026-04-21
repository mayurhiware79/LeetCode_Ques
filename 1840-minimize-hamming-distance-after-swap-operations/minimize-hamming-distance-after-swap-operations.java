class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        
        // Step 1: union
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        
        // Step 2: group indices
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }
        
        int result = 0;
        
        // Step 3: process each group
        for (List<Integer> group : groups.values()) {
            Map<Integer, Integer> count = new HashMap<>();
            
            // count source values
            for (int idx : group) {
                count.put(source[idx], count.getOrDefault(source[idx], 0) + 1);
            }
            
            // match target values
            for (int idx : group) {
                if (count.getOrDefault(target[idx], 0) > 0) {
                    count.put(target[idx], count.get(target[idx]) - 1);
                } else {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    class UnionFind {
        int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }
        
        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) {
                parent[pa] = pb;
            }
        }
    }
}