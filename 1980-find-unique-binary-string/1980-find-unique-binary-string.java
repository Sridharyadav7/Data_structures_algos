class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        String ans = build(set, n, sb);
        return ans;
    }

    public String build(Set<String> set, int n, StringBuilder sb) {
        if(sb.length() == n) {
            if(!set.contains(sb.toString())) {
                return sb.toString();
            }
            return null;
        }

        sb.append("0");
        String val = build(set, n, sb);
        if(val != null) return val;
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        val = build(set, n, sb);
        if(val != null) return val;
        sb.deleteCharAt(sb.length() - 1);
        
        return null;
    }
}