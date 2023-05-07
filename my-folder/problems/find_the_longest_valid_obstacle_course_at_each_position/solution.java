class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int z = 1;
        int ls[] = new int[obstacles.length];
        ls[0] = obstacles[0];
        
        int ans[] = new int[obstacles.length];
        ans[0] = 1;
        for(int i = 1; i < obstacles.length; i++){
            if(ls[z-1] <= obstacles[i]){
                ls[z++] = obstacles[i];
                ans[i] = z;
            } else {
                int x = Arrays.binarySearch(ls, 0, z, obstacles[i]);
                if(x < 0){
                    x += 1;
                    if(x < 0)
                        x *= -1;
                    ans[i] = x + 1;
                    ls[x] = obstacles[i];
                }else {
                    while(ls[x] <= obstacles[i])
                        x++;
                        
                    ls[x] = obstacles[i];
                    ans[i] = x + 1;
                }
            }
        }
        return ans;
    }
}