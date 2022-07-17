class Solution {
    public String intToRoman(int num) {
        int[] intArray = new int[]{     1000, 900, 500, 400, 100, 90, 50,   40, 10,  9    ,5, 4,1 }; 
        String[] strArray =new String[]{"M", "CM","D", "CD","C","XC","L",  "XL","X","IX","V", "IV","I"}; 
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<13;i++){
            while(num/intArray[i]>=1){
                ans.append(strArray[i]);
                num-=intArray[i];
            }
        }
        return ans.toString();
    }
}