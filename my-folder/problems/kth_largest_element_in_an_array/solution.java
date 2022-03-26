class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());
                for(int i=0;i<nums.length;i++)
                    maxHeap.add(nums[i]);
                int ans=maxHeap.peek();
        for(int i=1;i<k;i++){
             maxHeap.poll();
            ans=maxHeap.peek();
            System.out.println(ans+" "+i);
        }
        return ans;
    }
}