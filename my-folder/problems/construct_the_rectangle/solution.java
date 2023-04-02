class Solution {
    boolean isPerfectSquareByUsingSqrt(int n) {
    if (n <= 0) {
        return false;
    }
        double squareRoot = Math.sqrt(n);
        long tst = (long)(squareRoot + 0.5);
        return tst*tst == n;
    }
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        if(isPerfectSquareByUsingSqrt(area)){
             ans[0] = (int)Math.sqrt(area);
             ans[1] = ans[0];
             return ans;
        }
        int width = (int) Math.sqrt(area);

        while (area % width > 0)
        --width;

        return new int[] {area / width, width};
    }
}