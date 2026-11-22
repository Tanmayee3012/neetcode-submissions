class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            adj.get(time[0]).add(new int[]{time[1], time[2]});    
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int w = node[1];
            for(int[] edge: adj.get(u)){
                int edgeWeight = edge[1];
                int adjNode = edge[0];

                if(w + edgeWeight < dist[adjNode]){
                    dist[adjNode] = w + edgeWeight;
                    pq.add(new int[]{adjNode, dist[adjNode]});
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}