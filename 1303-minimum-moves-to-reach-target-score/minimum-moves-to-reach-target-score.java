// moves = 0
// while target > 1 and maxDoubles > 0:
//     if target is even:
//         target //= 2
//         maxDoubles -= 1
//     else:
//         target -= 1
//     moves += 1

// # if we used all doubles, we can only decrement
// moves += target - 1
// return moves


class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        while(target > 1 && maxDoubles > 0){
            if(target % 2 == 0){
                target /= 2;
                maxDoubles -= 1;
            }else{
                target -= 1;
            }
            moves += 1;
        }

        // If we run out of doubles, we can only increment (subtract backwards)
        moves += target -1;
        return moves;
    }
}