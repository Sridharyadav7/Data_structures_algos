class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int ans[] = new int[n];
        int cnt1 = 1;
        ans[0] = 0;
        int cnt2 = 0;

        for (int i = 1; i < n; i++) {
            if (seq.charAt(i) == '(') {
                if (cnt1 < cnt2) {
                    cnt1++;
                    ans[i] = 0;
                }
                else {
                    cnt2++;
                    ans[i] = 1;
                }
            }
            else {
                if (cnt1 > 0) {
                    cnt1--;
                    ans[i] = 0;
                }
                else {
                    cnt2--;
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }
}