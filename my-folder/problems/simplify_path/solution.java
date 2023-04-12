class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/",-1);
        Stack<String> stk= new Stack<>();    
        // Iterate through the parts and add non-empty values to the list
        for (String part : parts) {
            if (!part.isEmpty() && !part.equals(".")) {
                stk.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while(!stk.isEmpty()){
            while(!stk.isEmpty()&&stk.peek().equals("..")){
                stk.pop();
                if(!stk.isEmpty()){
                    if(stk.peek().equals("..")){
                        flag++;
                    }
                    else{
                          stk.pop();
                          break;
                    }
                }
            }

            if(!stk.isEmpty()&&!stk.peek().equals("..")){
                if(flag != 0){
                  stk.pop(); 
                  flag--; 
                }
                else sb.insert(0,"/" + stk.pop());
            }
        }
        if(sb.length() != 0&&sb.charAt(0) == '/'){
            return sb.toString();
        }
        return "/"+sb.toString();
    }
}