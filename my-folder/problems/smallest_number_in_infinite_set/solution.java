class SmallestInfiniteSet {
    int nums[] = new int[1001];
    int small = 1;
    public SmallestInfiniteSet() {
       Arrays.fill(nums,1);
       nums[0] = 0;
    }
    
    public int popSmallest() {
        int pop=small;
         nums[small]=0;
        for(int i = small; i< 1001;i++){
            if(nums[i] == 1){
                small = i;
                break;
            }
        }
        return pop;
    }
    
    public void addBack(int num) {
       nums[num] = 1;
        if(num < small) small = num;        // System.out.println(Arrays.toString(nums));
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */