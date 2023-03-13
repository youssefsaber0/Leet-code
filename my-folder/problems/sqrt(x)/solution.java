class Solution {
    public int mySqrt(int x) {
        double left = 0;
        double right =(double) x/2.0;
        double mid =(right + left)/2;
        if(x==1){
            return 1;
        }
        while(left <right){
          mid =(right + left)/2;
          if((long)(mid*mid)==(long)x){
              return (int)mid;
          }
          else if(mid*mid > x){
              right = mid;
          }
          else{
              left = mid;
          }  
        }
        return (int)mid;
    }
}