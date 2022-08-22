class Solution {
    class Pair{
         int key;
         int freq;
         Pair(int key,int freq){
            this.key=key;
            this.freq=freq;
        }
    }
    public Map <Integer ,Integer >setMap(int[] nums){
        Map <Integer,Integer> map=new HashMap<>();
        for(Integer i:nums){
            map.put(i, map.getOrDefault(i, 0) + 1);

        }

        return map;
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer ,Integer> map = setMap(nums);
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((x,y)->Integer.compare(y.freq,x.freq));
       for(Map.Entry<Integer,Integer> pair : map.entrySet()){
           pQueue.add(new Pair(pair.getKey(),pair.getValue()));
       }
        int arr[] = new int[k];
        for(int i = 0;i < k; i++){
            arr[i] = pQueue.poll().key;
        }
        return arr;
}
}