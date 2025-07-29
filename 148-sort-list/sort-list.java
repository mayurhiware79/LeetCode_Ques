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
    public ListNode sortList(ListNode head) {
        // Create a list to
        // store node values
        List<Integer> arr = new ArrayList<>();
        
        // Temporary pointer to
        // traverse the linked list
        ListNode temp = head;
        
        // Traverse the linked list and
        // store node values in the list
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        
        // Sort the list
        // containing node values
        Collections.sort(arr);
        
        // Reassign sorted values to
        // the linked list nodes
        temp = head;
        for(int i = 0; i < arr.size(); i++){
            // Update the node's data
            // with the sorted values
            temp.val = arr.get(i); 
            // Move to the next node
            temp = temp.next; 
        }
        
        // Return the head of the
        // sorted linked list
        return head; 
    }
}