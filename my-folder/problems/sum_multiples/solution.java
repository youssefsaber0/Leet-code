class Solution {
    boolean isDiv(int i){
        return (i % 3 ==0)||(i % 7 ==0)||(i % 5 ==0);
    }
    public int sumOfMultiples(int n) {
        int ans = 0;
        for(int i = 1; i<= n;i++ ){
            if(isDiv(i)){
                ans += i;
            }
        }
        return ans;
    }
}