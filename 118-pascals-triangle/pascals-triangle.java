class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements of each row are 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two values above in the triangle
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}

// class Solution {
//     public List<List<Integer>> generate(int numRows) {
        
//          // Base case
//         if (numRows == 1) {
//             List<List<Integer>> base = new ArrayList<>();
//             List<Integer> firstRow = new ArrayList<>();
//             firstRow.add(1);
//             base.add(firstRow);
//             return base;
//         }

//         // Recursive call
//         List<List<Integer>> triangle = generate(numRows - 1);

//         // Get the previous row
//         List<Integer> prevRow = triangle.get(numRows - 2);
//         List<Integer> newRow = new ArrayList<>();
//         newRow.add(1); // first element

//         // Compute the new row elements by summing adjacent elements
//         for (int i = 1; i < prevRow.size(); i++) {
//             newRow.add(prevRow.get(i - 1) + prevRow.get(i));
//         }

//         newRow.add(1); // last element

//         triangle.add(newRow); // add new row to triangle
//         return triangle;
//     }
// }