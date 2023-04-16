 class Solution {
        public int find(int[] nums1, int l1,
                        int r1,int[] nums2,
                        int l2,int r2,
                        int targetIndex){
            if(r1<l1){
                return nums2[ l2 + targetIndex];
            }
            if(r2<l2){
                return nums1[ l1 + targetIndex];
            }
            int mid1= (r1 + l1)/2;
            int mid2= (r2 + l2)/2;
            if(nums1[mid1] > nums2[mid2]){
                if(targetIndex >= ((mid2 - l2 )+ (mid1 - l1) + 1)){
                    return find(nums1, l1, r1, nums2, mid2+1, r2, targetIndex - (mid2 - l2 +1) );
                }
                else{
                    return find(nums1, l1, mid1- 1, nums2, l2, r2, targetIndex);
                }
            }
            else{
                if(targetIndex >= (mid2 - l2 + mid1 - l1 + 1)){
                    return find(nums1, mid1 + 1, r1, nums2, l2, r2, targetIndex - (mid1 - l1 +1)  );
                }
                else{
                    return find(nums1, l1, r1, nums2, l2, mid2 - 1, targetIndex);
                }  
            }
        }
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int l = nums1.length + nums2.length;
            if(l%2 == 0){
                int mid1 = find(nums1,0,nums1.length-1,nums2,0,nums2.length-1,l/2);
                int mid2 =find(nums1,0,nums1.length-1,nums2,0,nums2.length-1,l/2 - 1);
                return ((double)mid1 +(double)mid2) / 2.0; 
            }
            double ans =(double) find(nums1,0,nums1.length-1,nums2,0,nums2.length-1,l/2);
            return  ans;
        }
    }