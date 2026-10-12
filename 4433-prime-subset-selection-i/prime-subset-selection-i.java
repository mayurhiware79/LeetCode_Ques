class Solution {
    public List<Integer> maxPrimes(int n, int s) {

        // Find all primes <= n
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Select smallest primes while possible
        ArrayList<Integer> ans = new ArrayList<>();
        long sum = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && sum + i <= s) {
                ans.add(i);
                sum += i;
            }
        }

        return ans;
    }
}