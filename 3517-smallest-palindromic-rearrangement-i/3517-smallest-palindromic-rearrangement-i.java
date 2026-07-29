class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        // Convert string to char array since String is immutable in Java
        char[] arr = s.toCharArray();

        // Sort the first half of the array
        Arrays.sort(arr, 0, mid);

        // Copy the first half to the second half in reverse order
        for (int i = 0; i < mid; i++) {
            arr[n - 1 - i] = arr[i];
        }

        // Convert back to String if needed
        s = new String(arr);
        return s;
    }
}