class Solution {
    public boolean isPalindrome(int x) {
        int number=x;
        int palindrome=0;
        if(x<0){
            return false;
        }
        while(number!=0){
            palindrome=palindrome*10+(number%10);
            number/=10;
        }
        return x==palindrome;
    }
}