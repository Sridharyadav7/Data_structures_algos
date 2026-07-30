class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        int val = 2;
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if(map.size() < 8) {
                map.put(c, 1);
                ans += 1;
            } 
            else {
                if(cnt < 8) {
                    ans += val;
                    cnt++;
                }
                else {
                    val++;
                    ans += val;
                    cnt = 1;
                }
            }
            
        }
        return ans;
    }
}