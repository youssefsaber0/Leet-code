   class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stk = new Stack<>();
            HashSet<Integer> stackElements= new HashSet<>();
            int j = 0;
            for(int i = 0; i < popped.length; i++){
                if(!stk.isEmpty()&&stackElements.contains(popped[i]) && stk.peek() != popped[i]){
                    return false;
                }
                else if( !stk.isEmpty()&&stk.peek() == popped[i]){
                    int temp = stk.pop();
                    // stackElements.remove(temp);
                }
                else{
                    while(pushed[j] != popped[i]){
                        stk.push(pushed[j]);
                        stackElements.add(pushed[j]);
                        j++;
                    }
                    j++;
                }
            }
            return true;
        }
    }