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
    public ListNode swapPairs(ListNode head) {
        // Create dummy node pointing to the head.
        // This helps simplify edge cases (like swapping at the head of the list).
        ListNode dummy = new ListNode(0, head);
        
        // Initialize two pointers:
        // 'prev' is initially the dummy node.
        // 'cur' - checking for swapping, starting at head.
        ListNode prev = dummy, cur = head;

        // Loop while there are at least two nodes to swap
        while (cur != null && cur.next != null) {
            // Save the pointer to the node after the pair (used to reconnect after swap)
            ListNode npn = cur.next.next;

            // 'second' is the second node in the pair
            ListNode second = cur.next;

            // Perform swapping
            second.next = cur;   // Second node points to first node
            cur.next = npn;      // First node points to the next pair
            prev.next = second;  // Previous node points to second node (new head of the pair)

            // Move pointers forward for next swap
            prev = cur;  // 'cur' is now the second node after swap, becomes 'prev' for next pair
            cur = npn;   // Move 'cur' to next pair's first node
        }

        // Return the new head of the list (after dummy)
        return dummy.next;        
    }
}
