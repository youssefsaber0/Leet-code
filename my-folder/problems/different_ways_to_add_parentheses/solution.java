class Solution {
    Map<String, List<Integer>> m = new HashMap<>();
    boolean isOperation(char c){
        return c == '+'||c == '-'||c == '*';
    }
    List<Integer> compineTwoLIst(List<Integer> l,List<Integer> r,char c){
        List<Integer> ans = new ArrayList<>();
        for(Integer i:l){
            for(Integer j:r){
                switch(c){
                    case '+':
                        ans.add(i + j);
                        break;
                    case '-':
                        ans.add(i - j);
                        break;   
                    case '*':
                        ans.add(i * j);
                        break;       
                }
            }
        }
        return ans;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans =m.get(expression); 
        if(ans != null){
            return ans;
        }
        ans = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(isOperation(c)){
                List<Integer> l = diffWaysToCompute(expression.substring(0, i));
                List<Integer> r = diffWaysToCompute(expression.substring(i+1));
                ans.addAll( compineTwoLIst(l, r, c));
                m.put(expression, ans);
            }
        }
        if(ans.size() == 0){
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}