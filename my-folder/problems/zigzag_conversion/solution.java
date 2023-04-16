class Solution {
    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> m = new HashMap<>();
        if(numRows == 1){
            return s;
        }
        int i = 0;
        int state = 0;
        for(int j = 0 ; j < s.length(); j++){
            Character c = s.charAt(j);
            if(state == 0){
                if(i < numRows){
                    if(!m.containsKey(i)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(c);
                        m.put(i, sb);
                    }else{
                        StringBuilder sb = m.get(i);
                        sb.append(c);
                    }
                    i++;
                }
                else{
                    state = 1;
                    j--;
                    i = numRows - 2;
                }
            }
        else if(state == 1){
                if(i > 0){
                    if(!m.containsKey(i)){
                        StringBuilder sb = new StringBuilder();
                        sb.append(c);
                        m.put(i, sb);
                    }else{
                        StringBuilder sb = m.get(i);
                        sb.append(c);
                    }
                    i--;
                }
                else{
                    state = 0;
                    j--;
                }
        }
        }
        StringBuilder ans = new StringBuilder();
        m.forEach((key, value) -> ans.append(value));
        return ans.toString();
    }
}