class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task: tasks){
            count[task-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        for(int i  = 0; i < 26; i++){
            if(count[i] != 0){
                maxHeap.offer(count[i]);
            }
        }

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            if(maxHeap.isEmpty() && !q.isEmpty()) time = q.peek()[1];
            else {
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0) q.offer(new int[]{cnt, time + n});
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
