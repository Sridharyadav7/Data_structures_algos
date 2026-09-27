class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(hand[i])) {
                int cnt = 0;
                int val = hand[i];

                while (true) {
                    if (cnt == groupSize) {
                        break;
                    }
                    if (map.containsKey(val)) {
                        cnt++;
                        map.put(val, map.get(val) - 1);
                        if (map.get(val) <= 0) {
                            map.remove(val);
                        }
                        val = val + 1;
                    } 
                    else {
                        return false;
                    }   
                }
            }
        }
        return true;
    }
}