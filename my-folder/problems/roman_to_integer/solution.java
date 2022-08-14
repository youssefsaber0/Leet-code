class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> charToInt = new HashMap<>();
        charToInt.put('I', 1);
        charToInt.put('V', 5);
        charToInt.put('X', 10);
        charToInt.put('L', 50);
        charToInt.put('C', 100);
        charToInt.put('D', 500);
        charToInt.put('M', 1000);
        
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && charToInt.get(s.charAt(i)) < charToInt.get(s.charAt(i + 1)))             {
                num += charToInt.get(s.charAt(i + 1)) - charToInt.get(s.charAt(i));
                i++;
            }
            
            else {
                num += charToInt.get(s.charAt(i));
            }
        }
        return num;
    }
}