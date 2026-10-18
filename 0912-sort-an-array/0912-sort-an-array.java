class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }

        return nums;
    }

    private void heapify(int[] nums, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < size && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temp = nums[root];
            nums[root] = nums[largest];
            nums[largest] = temp;

            heapify(nums, size, largest);
        }
    }
}