class Solution {
    public String[] spellchecker(String[] wl, String[] qs) {
    Set<String> set = new HashSet<>(Arrays.asList(wl));
    Map<String, String> low = new HashMap<>();
    Map<String, String> vow = new HashMap<>();
    
    for (String w : wl) {
        String l = w.toLowerCase();
        String v = dev(l);
        low.putIfAbsent(l, w);
        vow.putIfAbsent(v, w);
    }
    
    for (int i = 0; i < qs.length; i++) {
        String q = qs[i];
        if (set.contains(q)) continue;
        String lq = q.toLowerCase();
        String vq = dev(lq);
        if (low.containsKey(lq)) qs[i] = low.get(lq);
        else if (vow.containsKey(vq)) qs[i] = vow.get(vq);
        else qs[i] = "";
    }
    return qs;
}

private String dev(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        if ("aeiou".indexOf(c) >= 0) sb.append('#');
        else sb.append(c);
    }
    return sb.toString();
}

}