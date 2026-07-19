class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int idx = ch - 'a';

            freq[idx]--;

            if (used[idx]) continue;

            while (sb.length() > 0 &&
                   sb.charAt(sb.length() - 1) > ch &&
                   freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(ch);
            used[idx] = true;
        }

        return sb.toString();
    }
}