class Solution {

    private boolean isMatch(int i, String s, int j, String p) {
        int sn = s.length(), pn = p.length();
        if (j == pn) { // since * in p can match 0 of previous char, so empty string(i==sn) may match p
            return i == sn;
        }
        char pj = p.charAt(j);
        if (j + 1 < pn && p.charAt(j + 1) == '*') { //match *, needs to look at the next char to repeate current char
            if (isMatch(i, s, j + 2, p)) {
                return true;
            }
            while (i < sn && (pj == '.' || pj == s.charAt(i))) {
                if (isMatch(++i, s, j + 2, p)) {
                    return true;
                }
            }
        } else if (i < sn && (s.charAt(i) == pj || //match char
                pj == '.')) { //match dot
            return isMatch(i + 1, s, j + 1, p);
        }
        return false;

    }

    public boolean isMatch(String s, String p) {
        return isMatch(0, s, 0, p);
    }
}