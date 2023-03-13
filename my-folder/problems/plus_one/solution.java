class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        Stack<Integer> stk= new Stack<>();
        int reminder = (digits[length-1]+1)/10;
        stk.push((digits[length-1]+1) % 10);
        int i=length-2;
        for( i=length-2;i >= 0;i--){
            if(reminder == 0){
                stk.push(digits[i]);
                continue;
            }
            reminder = (digits[i]+reminder)/10;
            stk.push((digits[i]+1) % 10);
        }
        if(reminder != 0){
            stk.push(reminder);
        }
        int[] ans = new int[stk.size()];
        for( i = 0; i < ans.length; i++){
            ans[i] = stk.pop();
        } 
        return ans;
    }
}