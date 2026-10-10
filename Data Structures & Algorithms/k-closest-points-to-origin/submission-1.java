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
        PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2) -> (Integer.compare(p1.distance , p2.distance)));
        for(int[] point: points){
            minHeap.offer(new Point(point));
        }

        int[][] res = new int[k][2];
        for(int i = 0; i< k; i++){
            res[i] = minHeap.poll().point;
        }
        return res;
    }
}