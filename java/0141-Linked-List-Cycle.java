/*

Problem Statement:

Given a linked list, determine if it has a cycle in it.

Example:



*/

/*

Thought Process:

Turtle and hare.

*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}

/*

Final thoughts:

Time complexity: O(n)
Space complexity: O(1)



*/