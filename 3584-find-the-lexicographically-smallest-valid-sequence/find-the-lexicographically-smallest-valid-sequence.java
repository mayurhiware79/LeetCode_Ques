class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // dp[i] = maximum number of characters
        // of word2 that can be matched from word1[i...]
        int[] dp = new int[n + 1];

        int j = m - 1;

        // Build suffix DP
        for (int i = n - 1; i >= 0; i--) {

            dp[i] = dp[i + 1];

            if (j >= 0 && w1[i] == w2[j]) {
                dp[i]++;
                j--;
            }
        }

        // If even exact matching is impossible
        // with at most one mismatch, we will detect it below.

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        while (i < n && j < m) {

            // Case 1: characters already match
            if (w1[i] == w2[j]) {

                ans[j] = i;
                j++;
            }

            // Case 2: characters don't match.
            // We can use our ONE allowed mismatch here.
            else {

                /*
                 * After choosing i as the mismatching character,
                 * we need to match all remaining characters
                 * of word2 exactly.
                 *
                 * Number of remaining characters:
                 * m - j - 1
                 *
                 * dp[i + 1] tells us how many characters from
                 * word2's suffix can be matched.
                 */
                if (dp[i + 1] >= m - j - 1) {

                    ans[j] = i;
                    j++;

                    // Mismatch has been used.
                    i++;

                    // Now match the remaining characters EXACTLY.
                    while (i < n && j < m) {

                        if (w1[i] == w2[j]) {
                            ans[j] = i;
                            j++;
                        }

                        i++;
                    }

                    break;
                }
            }

            i++;
        }

        // We couldn't form word2
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}