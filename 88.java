import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }
        else{
            int k=m;
            int i=0;
            int j=0;
            while(i<nums1.length && j<nums2.length){
                int temp=nums1[i];
                if(temp==0){
                    nums1[i++]=nums2[j++];
                }
                else if(temp<=nums2[j]){
                    i++;
                }
                else{
                    nums1[k++]=nums1[i];
                    nums1[i++]=nums2[j++];
                }
            }
            Arrays.sort(nums1);
        }

        
    }
}