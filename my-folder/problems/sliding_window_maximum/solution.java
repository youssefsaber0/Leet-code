class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // arr = {val, index}
        // Max heap
        Queue<int[]> priority = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        for(int i = 0; i < k; i++) {
            priority.add(new int[]{nums[i], i});
        }
        
        
        int cur = k;
        int index = 1;
        int[] ans = new int[nums.length - k + 1];
        ans[0] = priority.peek()[0];
        
        while(cur < nums.length) {
            
            
            // remove out of window elements
            while(!priority.isEmpty() && (priority.peek()[1] < cur - k + 1)) {
                priority.remove();
            }
            
            priority.add(new int[]{nums[cur], cur});
            ans[index++] = priority.peek()[0];
            cur++;
        }
        
        return ans;
    }
        
    }