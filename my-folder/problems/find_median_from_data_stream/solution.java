class MedianFinder {
	private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
	
	public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            if (minHeap.isEmpty() || num >= minHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else if (minHeap.size() > maxHeap.size()) {
            if (num >= minHeap.peek()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(num);
            }
        } else {
            if (minHeap.isEmpty() || num >= minHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() == 0) {
            return -1;
        }

        if (minHeap.size() == maxHeap.size()) {
            return (maxHeap.peek() - minHeap.peek()) / 2.0 + minHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }}
