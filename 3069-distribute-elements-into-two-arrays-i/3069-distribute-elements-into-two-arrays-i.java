class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        int arr1Ele = nums[0];
        arr2.add(nums[1]);
        int arr2Ele = nums[1];

        for(int i = 2; i < n; i++) {
            if(arr1Ele > arr2Ele) {
                arr1.add(nums[i]);
                arr1Ele = nums[i]; 
            }
            else {
                arr2.add(nums[i]);
                arr2Ele = nums[i];
            }
        }
        int len = arr1.size() + arr2.size();
        int res[] = new int[len];
        for(int i = 0; i < arr1.size(); i++) {
            res[i] = arr1.get(i);
        }
        for(int i = arr1.size(); i < len; i++) {
            res[i] = arr2.get(i - arr1.size());
        }
        return res;
    }
}