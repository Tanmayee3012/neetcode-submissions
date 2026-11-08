class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        if(q.size() == 0) return new int[0];

        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans[i++] = node;

            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return i == numCourses ? ans : new int[0];
    }
}