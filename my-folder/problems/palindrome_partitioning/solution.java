class Solution {

    List<List<String>> result = new ArrayList<>();
    String[][] pals;
    int n;

    void partition(int indx, List<String> prevPals) {
        if(indx == n) {
            result.add(new ArrayList<>(prevPals));
        }

        int i = indx;
        for(int j = i; j < n; j++) {
            if(pals[i][j] != null) {
                prevPals.add(pals[i][j]);
                partition(j+1, prevPals);
                if(!prevPals.isEmpty()) prevPals.remove(prevPals.size()-1);
            }
        }
    }

    boolean isPalindrome(char[] s, int i, int j) {
        if(j < i) return false;
        while(i <= j && s[i] == s[j]) {i++; j--;}
        return (i > j);
    }

    public List<List<String>> partition(String s) {
        this.n = s.length();
        pals = new String[n][n];
        char[] chars = s.toCharArray();

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(isPalindrome(chars, i, j)) {
                    pals[i][j] = s.substring(i, j+1);
                }
            }
        }
        partition(0, new ArrayList<String>());
        return result;
    }
}