class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap; 

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() && maxHeap.isEmpty()){
            minHeap.offer(num);
        } else if(!minHeap.isEmpty() && num > minHeap.peek()){
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        if(minHeap.size() - maxHeap.size() > 1){
            maxHeap.offer(minHeap.poll());
        } else if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        return minHeap.peek();
    }
}
