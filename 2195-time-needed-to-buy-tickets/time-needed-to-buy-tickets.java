class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< tickets.length; i++){
            queue.add(i);
        }

        int time=0;
        while(!queue.isEmpty()){
            int person = queue.poll(); //person at front buys a ticket
            tickets[person]--;
            time++;

            //if person still needs more tickets, go to end of queue
            if(tickets[person] > 0){
                queue.add(person);
            }

            //if this was person k and they finished buying, stop
            if(person == k && tickets[person] == 0){
                break;
            }
        }

        return time;
    }
}