class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        Arrays.sort(nums1);

        int evens = 0;
        int odds = 0;

        for(int i = 0; i < n; i++) {
            if(nums1[i] % 2 == 0) {
                evens++;
            }
            else {
                odds++;
            }
        }

        if(evens == n || odds == n) {
            return true;
        }

        return nums1[0] % 2 == 1;
    }
}