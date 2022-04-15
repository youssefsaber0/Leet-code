import java.util.ArrayList;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
       
        for(int i=0;i<intervals.length;i++){
            int temp=i;
            while(i+1<intervals.length&&intervals[temp][1]>=intervals[i+1][0]){
                intervals[temp][1]=Math.max(intervals[i+1][1],intervals[temp][1]);
                  intervals[i+1]=null;
                i++;
            }
        }
    return Arrays.stream(intervals)
                .filter(s -> (s != null))
                .toArray(int[][]::new);
        // Arrays.stream(firstArray)
                     // .filter(s -> (s != null))
                     // .toArray(int[]::new);
    }
}