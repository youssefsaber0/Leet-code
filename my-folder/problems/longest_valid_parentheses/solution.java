class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int ans=0;
        stk.push(-1);
        for(int i=0;i<s.length();i++){ 

         if( s.charAt(i)=='('){
              System.out.println("hi");
                stk.push(i);
            }
            else{
                stk.pop();
                
                
                if(stk.empty()){
                    stk.push(i);
                    continue;
                }
                ans=Math.max(ans,i-stk.peek());
            }

        }
        return ans;
    }
}