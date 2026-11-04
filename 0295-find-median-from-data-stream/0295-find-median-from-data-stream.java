class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap; 

    public MedianFinder() {
        maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxheap.isEmpty() || num <= maxheap.peek()) {
            maxheap.add(num);
        }
        else {
            minheap.add(num);
        }

        if (maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        }

        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if (maxheap.size() > minheap.size()) {
            return (double) maxheap.peek();
        }
        return (double) ((maxheap.peek() + (double) minheap.peek()) / 2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */