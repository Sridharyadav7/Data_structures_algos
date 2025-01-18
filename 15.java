class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      int k=0;
      Arrays.sort(nums);
      while(k<nums.length-2 && nums[k]<=0){
        int i=k+1;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]+nums[k]==0){
                ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                while(i<j && nums[i]==nums[i+1]){
                    i++;
                }
                while(i<j && nums[j]==nums[j-1]){
                    j--;
                }
                i++;
                j--;
            }
            else if(nums[i]+nums[j]+nums[k]<0) i++;
            else j--;
        }
        k++;
        while(k<nums.length-2 && nums[k]==nums[k-1]){
            k++;
        }
      }
      return ans;
}}