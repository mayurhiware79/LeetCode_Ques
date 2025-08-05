class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) 1e14;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (isTimeSufficient(ranks, cars, mid)) {
                right = mid; // Try smaller time
            } else {
                left = mid + 1; // Need more time
            }
        }

        return left; // left == right is the minimum required time
    }

    private boolean isTimeSufficient(int[] ranks, int cars, long givenTime) {
        long totalCarsFixed = 0;

        for (int r : ranks) {
            // Each mechanic can fix floor(sqrt(givenTime / r)) cars
            long carsByThisMechanic = (long) Math.sqrt((double) givenTime / r);
            totalCarsFixed += carsByThisMechanic;

            if (totalCarsFixed >= cars) {
                return true;
            }
        }

        return false;
    }
}
