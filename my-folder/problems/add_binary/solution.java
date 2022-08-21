class Solution {
    public String addBinary(String a, String b) {
        StringBuilder total = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0, res = 0;
        while (i >=0 || j>=0) {
            char c = (i >= 0) ? a.charAt(i--) : '0';
            char v = (j >= 0) ? b.charAt(j--) : '0';
            res = (c - '0') + (v - '0') + carry;
            if (res == 2) {
                res = 0;
                carry = 1;
            } else if (res == 3) {
                res = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            total.append(res);
        }
        if (carry == 1) total.append(carry);
        return total.reverse().toString();
    }
}