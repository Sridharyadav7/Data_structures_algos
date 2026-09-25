class Solution {
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        int left = 1;
        int right = n;
        int ans = -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            long leftSum = sum(1, mid);
            long rightSum = sum(mid, n);

            if (leftSum == rightSum) {
                ans = mid;
                break;
            }
            else if (leftSum > rightSum) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
    public long sum(int start, int n) {
        if (n == 1) {
            return 1;
        }
        long sum = (n * (n + 1)) / 2;
        if (start == 1) {
            return sum;
        }
        int prev = start - 1;
        sum = sum - (prev * (prev + 1)) / 2;
        return sum;
    }
}