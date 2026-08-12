class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n < 3) return false;

        int validInd = -1;
        for(int i = 1; i < n - 1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                validInd = i;
                break;
            }
        }

        if(validInd == -1) return false;

        int leftInd = validInd - 1;
        int rightInd = validInd + 1;

        while(leftInd >= 0 || rightInd < n) {
            if(leftInd >= 0 && arr[leftInd] < arr[leftInd+1]) {
                leftInd--;
            }
            else if(leftInd >= 0) {
                return false;
            }
            if(rightInd < n && arr[rightInd] < arr[rightInd-1]) {
                rightInd++;
            }
            else if(rightInd < n) {
                return false;
            }
        }
        return true;
    }
}