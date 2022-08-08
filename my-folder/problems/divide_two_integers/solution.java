class Solution {
    public int divide(int dividend, int divisor) {
        long l= Long.valueOf(dividend); 
        long l2=Long.valueOf(divisor);  
        long ans =l/l2;
        if(ans>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(ans<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)ans;
    }
}