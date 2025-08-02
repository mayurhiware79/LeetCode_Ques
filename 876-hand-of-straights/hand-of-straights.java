class Solution {

    // Helper - find a group of 'groupSize' consecutive numbers starting from hand[i]
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;    // Next expected number in the group
        hand[i] = -1;           // Mark current card as used
        int count = 1;          // We already used one card, so count = 1
        i += 1;

        // Try to find next (groupSize - 1) consecutive cards
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;  // Expecting next consecutive number
                hand[i] = -1;     // Mark this card as used
                count++;          // One more card added to the group
            }
            i++;
        }

        // If we couldn't find enough cards to complete the group, return false
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        // If total cards can't be evenly divided into groups, return false
        if (n % groupSize != 0)
            return false;

        // Sort the hand so we can find consecutive cards easily
        Arrays.sort(hand);
        int i = 0;

        // Traverse each card in the sorted array
        for (; i < n; i++) {
            // If the card is not used yet
            if (hand[i] >= 0) {
                // Try to form a group starting from hand[i]
                if (!findsucessors(hand, groupSize, i, n))
                    return false; // If group formation fails, return false
            }
        }

        // All cards successfully grouped
        return true;
    }
}
