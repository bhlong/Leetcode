/*

Problem Statement:

Reverse a singly linked list.


Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

*/

/*

Thought Process:

Change pointer direction as we loop through the list.

*/

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

/*

Final thoughts:

Time complexity: O()
Space complexity: O()



*/