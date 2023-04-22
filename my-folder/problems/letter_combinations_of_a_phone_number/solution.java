class Solution {
    List<String> mapping =  new ArrayList<>(List.of("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));
    List<String> ans = new ArrayList<>();
    void rec(String digits,StringBuilder sb, int i){
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        String cur = mapping.get(digits.charAt(i) - '2');
        for(int j = 0; j < cur.length(); j++){
            sb.append(cur.charAt(j));
            rec(digits, sb, i +1);
            if(sb.length() > i)
                sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return ans;
        }
        rec(digits,new StringBuilder(),0);
        return ans; 
    }
}