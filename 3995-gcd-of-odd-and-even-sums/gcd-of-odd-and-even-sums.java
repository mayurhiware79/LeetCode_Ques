// class Solution {
//     public int gcdOfOddEvenSums(int n) {
//         return n;
//     }
// }

// class Solution {

//     public int gcdOfOddEvenSums(int n) {

//         int sumOdd = 0;
//         int sumEven = 0;

//         for (int i = 1; i <= n; i++) {
//             sumOdd += (2 * i - 1);
//             sumEven += (2 * i);
//         }

//         return gcd(sumOdd, sumEven);
//     }

//     public int gcd(int a, int b) {
//         while (b != 0) {
//             int temp = a % b;
//             a = b;
//             b = temp;
//         }
//         return a;
//     }

// }

class Solution {

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int gcdOfOddEvenSums(int n) {

        int sumOdd = n * n;
        int sumEven = n * (n + 1);

        return gcd(sumOdd, sumEven);
    }
}