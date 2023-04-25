// Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
// Memory Usage: 42.2 MB, less than 92.95% of Java online submissions for Generate Parentheses.
class Solution {
    
    char[] charArray;
    List<String> result;
    
    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        this.charArray = new char[2*n];
        backtrack(0, 0, 0, n);
        return result;
    }
    
    private void backtrack(int open, int closed, int index, int n) {
        if (open == closed && index == 2 * n) {
            result.add(new String(charArray));
        }
        
        if (open < n) {
            charArray[index] = '(';
            backtrack(open + 1, closed, index + 1, n);
        }
        
        if (closed < open) {
            charArray[index] = ')';
            backtrack(open, closed + 1, index + 1, n);
        }
    }
}