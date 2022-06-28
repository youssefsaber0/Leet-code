import java.awt.Point;
class Solution {
        static int binarySearch(Point arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid].x == x)
                return mid;
            if (arr[mid].x > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Point index[] = new Point[n];
        for(int i=0;i<n;i++){
            index[i]=(new Point(nums[i],i));
        }
Arrays.sort(index, new Comparator<Point>() {
   public int compare(Point a, Point b) {
        int xComp = Integer.compare(a.x, b.x);
        if(xComp == 0)
            return Integer.compare(a.y, b.y);
        else
            return xComp;
    }
});
        for(int i=0;i<n;i++){
            int j =binarySearch(index,0,n-1,target-index[i].x);
            if(j!=-1){
                if(i==j){
                if(i-1>=0){
                    if(index[i].x==index[i-1].x){
                        return new int []{index[i].y,index[i-1].y};
                    }
                }
                if(i+1<n){
                if(index[i].x==index[i+1].x){
                        return new int []{index[i].y,index[i+1].y};
                    }
                }
                    else continue;
                }
                return new int []{index[i].y,index[j].y};
            }        
        }
        return new int[0];
    }
}