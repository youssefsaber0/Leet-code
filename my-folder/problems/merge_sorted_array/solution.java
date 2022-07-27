class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        if(m==nums1.length){
            return;
        }
        if(m==0&&n!=0){
            while(j<n)
                nums1[k++]=nums2[j++];
            return;
        }
        for(i=n+m-1,j=m-1;i>=n&&j>=0;i--){
            nums1[i]=nums1[j--];
        }
        i++;
        j=0;
        while(i<n+m&&j<n){
            if(nums1[i]<nums2[j])
                nums1[k++]=nums1[i++];
            else 
                nums1[k++]=nums2[j++];
                
        }
        while(i<n+m)
            nums1[k++]=nums1[i++]; 
        while(j<n)
            nums1[k++]=nums2[j++];
    }
}