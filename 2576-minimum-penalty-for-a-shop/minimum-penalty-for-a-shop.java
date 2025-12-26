class Solution {
    public int bestClosingTime(String customers) {
        int n= customers.length();

        //penalties if we close at hour 0(all future 'Y')
        int closePenalty = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') closePenalty++;
        }

        int openPenalty = 0;
        int minPenalty = closePenalty;
        int bestHour = 0;

        for(int i=0; i<n ;i++){
            char c = customers.charAt(i);
            if (c == 'Y') {
                closePenalty--; // this Y is no longer a closed-hour penalty if we move j right
            } else {
                openPenalty++;  // this N is an open-hour penalty
            }

            int currentPenalty = openPenalty + closePenalty;
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                bestHour = i + 1;  // closing after this hour
            }
        }

        return bestHour;
    }
}