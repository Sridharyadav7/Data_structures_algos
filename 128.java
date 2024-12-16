class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        List<Integer> lengths = new ArrayList<>();
        for(int num: set){
            if(!set.contains(num-1)){
                int count=1;
                int x=num;
                while(set.contains(x+1)){
                    count++;
                    x++;
                }
                lengths.add(count);
            }
        }
        return Collections.max(lengths);
}}