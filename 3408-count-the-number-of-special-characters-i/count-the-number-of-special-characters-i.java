class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();

        // store all characters
        for(char ch : word.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        // check a-z
        for(char ch = 'a'; ch <= 'z'; ch++) {

            if(set.contains(ch) &&
               set.contains(Character.toUpperCase(ch))) {

                count++;
            }
        }

        return count;
    }
}


// class Solution {
//     public int numberOfSpecialChars(String word) {

//         int count = 0;

//         // check every letter from a to z
//         for(char ch = 'a'; ch <= 'z'; ch++) {

//             boolean lowerFound = false;
//             boolean upperFound = false;

//             // traverse whole string
//             for(int i = 0; i < word.length(); i++) {

//                 if(word.charAt(i) == ch) {
//                     lowerFound = true;
//                 }

//                 if(word.charAt(i) == Character.toUpperCase(ch)) {
//                     upperFound = true;
//                 }
//             }

//             // if both exist
//             if(lowerFound && upperFound) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }