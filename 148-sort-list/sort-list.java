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

    public static ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
            // Create a dummy node to serve
            // as the head of the merged list
            ListNode dummyNode = new ListNode(-1);
            ListNode temp = dummyNode;

            // Traverse both lists simultaneously
            while (list1 != null && list2 != null) {
                // Compare elements of both lists and
                // link the smaller node to the merged list
                if (list1.val <= list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                // Move the temporary pointer
                // to the next node
                temp = temp.next; 
            }

            if (list1 != null) {
                temp.next = list1;
            } else {
                temp.next = list2;
            }
            // Return the merged list starting 
            // from the next of the dummy node
            return dummyNode.next;
    }

    public static ListNode findMiddle(ListNode head){
            if (head == null || head.next == null) {
                return head;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        
        // Find the middle of the list
        // using the findMiddle function
        ListNode middle = findMiddle(head);
        
        // Divide the list into two halves
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
        
        // Recursively sort the left and right halves
        left = sortList(left);
        right = sortList(right);
        
        // Merge the sorted halves using the
        return mergeTwoSortedLinkedLists(left, right);
    }
}

// class Solution {
//     public ListNode sortList(ListNode head) {
//         List<Integer> arr = new ArrayList<>();
        
//         ListNode temp = head;
        
//         while(temp != null){
//             arr.add(temp.val);
//             temp = temp.next;
//         }
        
//         // Sort the list
//         // containing node values
//         Collections.sort(arr);
        
//         temp = head;
//         for(int i = 0; i < arr.size(); i++){
//             // Update the node's data
//             // with the sorted values
//             temp.val = arr.get(i); 
//             // Move to the next node
//             temp = temp.next; 
//         }
        
//         // Return the head of the
//         // sorted linked list
//         return head; 
//     }
// }