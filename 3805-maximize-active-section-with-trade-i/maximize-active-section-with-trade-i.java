class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int totalOnes = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') totalOnes++;
        }

        // Augment the string
        String t = "1" + s + "1";

        List<Character> blocks = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < t.length()) {
            char ch = t.charAt(i);
            int j = i;

            while (j < t.length() && t.charAt(j) == ch) {
                j++;
            }

            blocks.add(ch);
            len.add(j - i);

            i = j;
        }

        int maxIncrease = 0;

        // Look for 0-block, 1-block, 0-block pattern
        for (int k = 1; k < blocks.size() - 1; k++) {

            if (blocks.get(k) == '1' &&
                blocks.get(k - 1) == '0' &&
                blocks.get(k + 1) == '0') {

                int increase = len.get(k - 1) + len.get(k + 1);
                maxIncrease = Math.max(maxIncrease, increase);
            }
        }

        return totalOnes + maxIncrease;
    }
}