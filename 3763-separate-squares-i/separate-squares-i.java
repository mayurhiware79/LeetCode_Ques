class Solution {
    public double separateSquares(int[][] squares) {
        double low = 0, high = 0;
        double totalArea = 0;

        // Find search range and total area
        for (int[] s : squares) {
            double y = s[1], l = s[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
            totalArea += l * l;
        }

        double target = totalArea / 2.0;

        // Binary search for Y
        for (int i = 0; i < 80; i++) {   // enough for 1e-6 precision
            double mid = (low + high) / 2;
            double area = areaBelow(squares, mid);

            if (area < target)
                low = mid;
            else
                high = mid;
        }

        return low;
    }

    // Computes total area of squares below horizontal line Y
    private double areaBelow(int[][] squares, double Y) {
        double area = 0;

        for (int[] s : squares) {
            double y = s[1], l = s[2];

            if (Y <= y) continue;
            else if (Y >= y + l)
                area += l * l;
            else
                area += l * (Y - y);
        }

        return area;
    }
}
