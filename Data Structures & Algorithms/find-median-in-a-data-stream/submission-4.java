class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int n;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {     
        if(!maxHeap.isEmpty() && num >= maxHeap.peek()){
            minHeap.add(num);
        }
        else{
            maxHeap.add(num);
        }
        while(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
        while(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        }
        return (double)maxHeap.peek();
    }
}
