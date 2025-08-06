class Solution {
    public int calPoints(String[] operations) {

        ArrayList<Integer> record = new ArrayList<>();

        for (String op : operations) {
            int n = record.size();

            if (op.equals("C")) {
                if (n > 0) record.remove(n - 1); // remove last one
            } else if (op.equals("D")) {
                if (n > 0) record.add(2 * record.get(n - 1)); // add double of last
            } else if (op.equals("+")) {
                if (n >= 2) {
                    record.add(record.get(n - 1) + record.get(n - 2));
                }
            } else {
                record.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : record) {
            sum += score;
        }

        return sum;
    }
}