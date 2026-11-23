class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket: tickets){
            adj.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        dfs(adj, "JFK", res);
        Collections.reverse(res);
        return res;
    }

    public void dfs(Map<String, PriorityQueue<String>> adj, String src, List<String> res){
        PriorityQueue<String> q = adj.get(src);
        while(q != null && !q.isEmpty()){
            String dst = q.poll();
            dfs(adj, dst, res);
        }
        res.add(src);
    }
}
