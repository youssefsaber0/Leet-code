import java.io.*;
import java.util.HashSet;
class Solution {
        private boolean isMatching(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer>  entry : map1.entrySet()) {
            if (!Objects.equals(map2.get(entry.getKey()), entry.getValue()))
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character i:s1.toCharArray())
            map.put(i,map.getOrDefault(i,0)+1);
        int n = s1.length();
        int numberOfchar=0;
        HashMap<Character, Integer> window = new HashMap<>();
        for(int i=0;i<s2.length();i++){
            if(!map.containsKey(s2.charAt(i))){
                window.clear();
                numberOfchar=0;
            }
            else{
                window.put(s2.charAt(i),window.getOrDefault(s2.charAt(i),0)+1);
                numberOfchar++;
            }
            if(numberOfchar==n){//if window complete 
                // System.out.println(i);     
                if(isMatching(map,window)){
                    return true;
                }
                window.put(s2.charAt(i-n+1),window.get(s2.charAt(i-n+1))-1);
                numberOfchar--;
            }
            
        }
        return false;
    }
}
