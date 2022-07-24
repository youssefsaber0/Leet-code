class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        else if(n==1){
            return x;
        }
        else if(n==-1){
            return 1/x;
        }
        double pow=myPow( x,  n/2);
        if(n%2==0) return pow *pow;
      return  (n>0) ? pow*pow*x: pow*pow*1/x; 
        }
}