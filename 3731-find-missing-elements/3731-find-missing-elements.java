class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int start = 101;
        int end = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] > end) {
                end = nums[i];
            }
            if(nums[i] < start) {
                start = nums[i];
            }
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = start + 1; i < end; i++) {
            if(!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }
}