class Solution {

    class Point{
        int[] point;
        int distance; 
        
        Point(int[] point){
            this.point = point;
            this.distance = (point[0] * point[0]) + (point[1] * point[1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2) -> (Integer.compare(p2.distance , p1.distance)));
        for(int[] point: points){
            minHeap.offer(new Point(point));
            if(minHeap.size() > k) minHeap.poll();
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!minHeap.isEmpty()){
            res[i++] = (minHeap.poll().point);
        }
        return res;
    }
}