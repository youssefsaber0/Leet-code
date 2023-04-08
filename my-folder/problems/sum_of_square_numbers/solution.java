class Solution {
    private boolean isPerfectSquare(int num) {
        int sqrt =(int) Math.sqrt(num);
        return sqrt*sqrt == num;
    }
    public boolean judgeSquareSum(int c) {
    long  st = 0;
    long  end = (long )Math.sqrt(c);
    long  mid ;
    while(st<= end)
    {
        mid = st*st + end * end;
        if(mid == c)
            return true;
        else if(mid > c)
            end--;
        else
            st++; 
    }
    return false;
    }
}