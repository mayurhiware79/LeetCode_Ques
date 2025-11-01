/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        //putting all nums element into hastset
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        //check node to handle edge casees, with val=0
        ListNode check = new ListNode(0); 
        check.next = head;
        ListNode current = check;

        //traversing list n deleting
        while(current.next != null){
            if(set.contains(current.next.val)){
                current.next = current.next.next; //to node skip kela
            }else {
                current = current.next;
            }
        }

        return check.next;
    }
}