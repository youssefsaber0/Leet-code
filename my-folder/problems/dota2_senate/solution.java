class Solution {
    public String predictPartyVictory(String senate) {
       
        Queue<Character> q = new LinkedList<>();
        int nR = 0, nD=0;
        int notDeletedR = 0, notDeletedD = 0;
        for(int i = 0;i < senate.length();i++){
            if(senate.charAt(i) =='D'){
                q.add('D');
                nD++;
            }
            else{
                q.add('R');
                nR++;
            }
        }
        while(nR != 0 && nD != 0){
            char cur = q.remove();
            if(cur == 'D'){
                if(notDeletedD == 0){
                    notDeletedR++;
                    q.add('D');
                }
                else{
                    notDeletedD--;
                    nD--;
                }
            }else{
                if(notDeletedR == 0){
                    notDeletedD++;
                    q.add('R');
                }
                else{
                    notDeletedR--;
                    nR--;
                }
            }
        }
       return nR == 0 ? "Dire": "Radiant"; 
    }
}