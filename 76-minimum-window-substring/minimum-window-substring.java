class Solution {
    public String minWindow(String s, String t) {

        // Frequency of characters required from t
        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;

        // Number of characters still required
        int required = t.length();

        // Best answer
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            // Add s[right] to the window
            char c = s.charAt(right);

            if (need[c] > 0) {
                required--;
            }

            need[c]--;

            right++;

            // Window is valid
            while (required == 0) {

                // Update minimum window
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                // Remove s[left] from window
                char leftChar = s.charAt(left);
                need[leftChar]++;

                if (need[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}