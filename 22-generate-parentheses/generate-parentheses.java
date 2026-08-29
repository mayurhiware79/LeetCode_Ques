class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, 0, result);
        return result;
    }

    private void generate(String curr, int n, int length, List<String> result) {

        if (length == 2 * n) {
            if (isValid(curr)) {
                result.add(curr);
            }

            // IMPORTANT: Always stop at length 2*n
            return;
        }

        // BACKTRACKNG - Recursion

        // Add '(' -- do something
        curr += '(';

        // Explore
        generate(curr, n, length + 1, result);

        // Undo
        curr = curr.substring(0, curr.length() - 1);

        // Add ')'
        curr += ')';

        // Explore
        generate(curr, n, length + 1, result);
    }

    private boolean isValid(String str) {
        int sum = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                sum++;
            } else {
                sum--;
            }

            if (sum < 0)
                return false;
        }

        return sum == 0;
    }
}