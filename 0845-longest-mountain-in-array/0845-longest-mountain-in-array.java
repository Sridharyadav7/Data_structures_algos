class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3) return 0;

        List<Integer> validIndices = new ArrayList<>();
        for(int i = 1; i < n - 1; i++) {
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                validIndices.add(i);
            }
        }

        if(validIndices.size() == 0) return 0;
        int maxlen = Integer.MIN_VALUE;

        for(int i = 0; i < validIndices.size(); i++) {
            int validIndex = validIndices.get(i);

            int leftInd = validIndex - 1;
            int rightInd = validIndex + 1;
            boolean leftValid = true;
            boolean rightValid = true;

            while(leftInd >= 0 || rightInd < n) {
                if(leftInd >= 0 && leftValid && arr[leftInd] < arr[leftInd+1]) {
                    leftInd--;
                }
                else if(leftInd >= 0 && leftValid) {
                    leftValid = false;
                }
                if(rightInd < n && rightValid && arr[rightInd] < arr[rightInd-1]) {
                    rightInd++;
                }
                else if(rightInd < n && rightValid) {
                    rightValid = false;
                }

                if(leftInd < 0) {
                    leftValid = false;
                }
                if(rightInd >= n) {
                    rightValid = false;
                }
                if(!rightValid && !leftValid) {
                    break;
                }
            }
            maxlen = Math.max(maxlen, rightInd - leftInd - 1);
        }
        return maxlen;
    }
}