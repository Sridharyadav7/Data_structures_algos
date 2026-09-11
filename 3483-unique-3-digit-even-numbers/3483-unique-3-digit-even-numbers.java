class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != j && i != k && j != k) {
                        if (digits[k] % 2 == 0 && digits[i] != 0) {
                            String val = Integer.toString(digits[i]).concat(Integer.toString(digits[j])).concat(Integer.toString(digits[k]));
                            set.add(val);
                        }
                    }
                }
            }
        }
        return set.size();
    }
}