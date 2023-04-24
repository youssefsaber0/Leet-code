class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size() > 1){
            int big = pq.poll();
            int secBig = pq.poll();
            if(big != secBig){
                pq.add(big - secBig);
            }
        }
        if(pq.size()==0){
            return 0;
        }
        return pq.poll();
    }
}