import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Create adjacency list
        // adj[i] contains a list of {neighbor, time}
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] meet : meetings) {
            adj[meet[0]].add(new int[]{meet[1], meet[2]});
            adj[meet[1]].add(new int[]{meet[0], meet[2]});
        }

        // Min-Heap (Priority Queue) sorted by time
        // Storing arrays of size 2: {time, person}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Person 0 and firstPerson know the secret at time 0
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{0, firstPerson});

        boolean[] vis = new boolean[n];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int person = current[1];

            if (vis[person]) {
                continue;
            }
            vis[person] = true;

            for (int[] next : adj[person]) {
                int nextPerson = next[0];
                int meetTime = next[1];

                // If not visited and meeting time is >= current time
                if (!vis[nextPerson] && meetTime >= time) {
                    pq.offer(new int[]{meetTime, nextPerson});
                }
            }
        }

        // Collect all people who know the secret
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (vis[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}